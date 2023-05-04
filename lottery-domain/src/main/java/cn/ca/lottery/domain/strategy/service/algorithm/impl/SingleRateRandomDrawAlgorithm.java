package cn.ca.lottery.domain.strategy.service.algorithm.impl;
import cn.ca.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {
    @Override
    public String RandomDraw(Long strategyId, List<String> excludeAwardIds) {
        SecureRandom secureRandom = new SecureRandom();
        int randomVal = secureRandom.nextInt(100)+1;
        int idx = super.haveIdx(randomVal);

        String[] rateTuples = rateTupleMap.get(strategyId);
        String awardId = rateTuples[idx];

        if (excludeAwardIds.contains(awardId)){
            return "未中奖";
        }
        return awardId;
    }
}
