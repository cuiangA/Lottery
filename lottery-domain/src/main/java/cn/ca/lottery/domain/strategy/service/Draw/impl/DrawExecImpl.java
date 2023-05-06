package cn.ca.lottery.domain.strategy.service.Draw.impl;

import cn.ca.lottery.domain.strategy.service.Draw.AbstractDrawBase;
import cn.ca.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.hutool.json.JSONUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("drawExec")
public class DrawExecImpl extends AbstractDrawBase {

    @Override
    public List<String> queryExcludeAwardIds(Long strategyId) {
        List<String> awardList = getExcludeAwardIds(strategyId);
        logger.info("执行抽奖策略 strategyId：{}，无库存排除奖品列表ID集合 awardList：{}", strategyId, JSONUtil.parse(awardList));
        return awardList;
    }
    @Override
    protected String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds) {
        String awardId = drawAlgorithm.RandomDraw(strategyId, excludeAwardIds);
        if (awardId==null){
            return null;
        }
        //删减库存操作
        boolean successDeduct = deductAwardStock(strategyId, awardId);
        return successDeduct?awardId:null;
    }
}
