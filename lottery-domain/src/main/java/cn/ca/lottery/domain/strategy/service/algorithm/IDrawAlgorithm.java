package cn.ca.lottery.domain.strategy.service.algorithm;

import cn.ca.lottery.domain.strategy.model.res.DrawResult;
import cn.ca.lottery.domain.strategy.model.vo.AwardRateInfo;

import java.util.List;

public interface IDrawAlgorithm {
    void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfos);
    boolean isExitRateTuple(Long strategyId);
    String RandomDraw(Long strategyId,List<String> excludeAwardIds);
}
