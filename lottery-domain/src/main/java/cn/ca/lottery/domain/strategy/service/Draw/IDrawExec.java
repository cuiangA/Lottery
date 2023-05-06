package cn.ca.lottery.domain.strategy.service.Draw;

import cn.ca.lottery.domain.strategy.model.req.DrawReq;
import cn.ca.lottery.domain.strategy.model.res.DrawResult;

import java.util.List;

/**
 * 抽奖操作接口
 */
public interface IDrawExec {
    /**
     * 抽奖方法
     * @param req 抽奖信息
     * @return 抽奖结果
     */
    DrawResult doDrawExec(DrawReq req);


    /**
     * 获取不在抽奖范围内的列表，包括：奖品库存为空、风控策略、临时调整等，这类数据是含有业务逻辑的，所以需要由具体的实现方决定
     *
     * @param strategyId 策略ID
     * @return 排除的奖品ID集合
     */
    List<String> queryExcludeAwardIds(Long strategyId);
}
