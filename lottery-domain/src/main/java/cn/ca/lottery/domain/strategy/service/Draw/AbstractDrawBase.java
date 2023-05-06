package cn.ca.lottery.domain.strategy.service.Draw;

import cn.ca.lottery.common.Constants;
import cn.ca.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.ca.lottery.domain.strategy.model.req.DrawReq;
import cn.ca.lottery.domain.strategy.model.res.DrawResult;
import cn.ca.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.ca.lottery.domain.strategy.model.vo.DrawAwardInfo;
import cn.ca.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.ca.lottery.infrastructure.po.Award;
import cn.ca.lottery.infrastructure.po.StrategyDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDrawBase extends DrawStrategySupport  implements IDrawExec{
    protected Logger logger = LoggerFactory.getLogger(AbstractDrawBase.class);
    @Override
    public DrawResult doDrawExec(DrawReq req) {
        Long strategyId = req.getStrategyId();
        String uId = req.getUId();
        //通过数据库查询到strategy,strategyDetail 1. 获取抽奖策略
        StrategyRich strategyRich = getStrategyRich(strategyId);
        int strategyMode = strategyRich.getStrategy().getStrategyMode();
        // 2. 校验抽奖策略是否已经初始化到内存
        checkAndInitRateData(strategyId,strategyMode,strategyRich.getStrategyDetail());
        // 3. 获取不在抽奖范围内的列表，包括：奖品库存为空、风控策略、临时调整等
        List<String> excludeAwardIds = queryExcludeAwardIds(strategyId);
        // 4. 执行抽奖算法
        String awardId = drawAlgorithm(strategyId, StrategyMode.get(strategyMode), excludeAwardIds);
        // 5. 包装中奖结果
        return buildDrawResult(uId,strategyId,awardId);
    }
    /**
     * 获取不在抽奖范围内的列表，包括：奖品库存为空、风控策略、临时调整等，这类数据是含有业务逻辑的，所以需要由具体的实现方决定
     *
     * @param strategyId 策略ID
     * @return 排除的奖品ID集合
     */
    public abstract List<String> queryExcludeAwardIds(Long strategyId);
    /**
     * 执行抽奖算法
     *
     * @param strategyId      策略ID
     * @param drawAlgorithm   抽奖算法模型
     * @param excludeAwardIds 排除的抽奖ID集合
     * @return 中奖奖品ID
     */
    protected abstract String drawAlgorithm(Long strategyId,IDrawAlgorithm drawAlgorithm,List<String> excludeAwardIds);

    /**
     * 校验抽奖策略是否已经初始化到内存
     *
     * @param strategyID         抽奖策略ID
     * @param strategyMode       抽奖策略模式
     * @param strategyDetailList 抽奖策略详情
     */
    public void checkAndInitRateData(Long strategyID, Integer strategyMode, List<StrategyDetail> strategyDetailList){
        //非单体概率的策略无需进行散列表的初始化
        if (!Constants.StrategyMode.SINGLE.getCode().equals(strategyMode)){
            return;
        }

        IDrawAlgorithm drawAlgorithm = StrategyMode.get(strategyMode);
        // 已初始化过的数据，不必重复初始化
        if (drawAlgorithm.isExitRateTuple(strategyID)){
            return;
        }
        // 解析并初始化中奖概率数据到散列表
        ArrayList<AwardRateInfo> rateInfoList = new ArrayList<>();
        for (StrategyDetail strategyDetail : strategyDetailList) {
            rateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(),strategyDetail.getAwardRate()));
        }
        drawAlgorithm.initRateTuple(strategyID,rateInfoList);
    }
    /**
     * 包装抽奖结果
     *
     * @param uId        用户ID
     * @param strategyId 策略ID
     * @param awardId    奖品ID，null 情况：并发抽奖情况下，库存临界值1 -> 0，会有用户中奖结果为 null
     * @return 中奖结果
     */
    public DrawResult buildDrawResult(String uId,Long strategyId,String awardId){
        if (awardId==null){
            return new DrawResult(uId,strategyId,Constants.DrawState.FAIL.getCode());
        }
        Award awardInfo = getAwardInfo(awardId);
        return new DrawResult(uId,strategyId,Constants.DrawState.SUCCESS.getCode(),
                new DrawAwardInfo(awardId,awardInfo.getAwardName(),awardInfo.getAwardType(),awardInfo.getAwardContent()));
    }
}
