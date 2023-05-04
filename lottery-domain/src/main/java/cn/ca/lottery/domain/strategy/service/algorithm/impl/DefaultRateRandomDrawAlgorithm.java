package cn.ca.lottery.domain.strategy.service.algorithm.impl;

import cn.ca.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.ca.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
//@Component("defaultRateRandomDrawAlgorithm")
@Component("defaultRateRandomDrawAlgorithm")
public class DefaultRateRandomDrawAlgorithm extends BaseAlgorithm {
    @Override
    public String RandomDraw(Long strategyId, List<String> excludeAwardIds) {
        BigDecimal differenceDenominator = BigDecimal.ZERO;

        // 排除掉不在抽奖范围的奖品ID集合
        ArrayList<AwardRateInfo> remainingAward = new ArrayList<>();
        List<AwardRateInfo> awardRateInfoList = awardRateInfoMap.get(strategyId);
        for (AwardRateInfo awardRateInfo:awardRateInfoList) {
            String awardId = awardRateInfo.getAwardId();
            if (excludeAwardIds.contains(awardId)){
                continue;
            }
            remainingAward.add(awardRateInfo);
            differenceDenominator=differenceDenominator.add(awardRateInfo.getAwardRate());
        }

        // 前置判断
        if (remainingAward.isEmpty()) return "";
        if (remainingAward.size()==1) return remainingAward.get(0).getAwardId();

        // 获取随机概率值
        SecureRandom secureRandom = new SecureRandom();
        int randomVal = secureRandom.nextInt(100)+1;
        // 循环获取奖品
        String awardId = "";
        int curVal = 0;
        for (AwardRateInfo awardRateInfo:remainingAward) {
            BigDecimal awardRate = awardRateInfo.getAwardRate();
            int rateValue = awardRate.divide(differenceDenominator, 3, RoundingMode.UP).multiply(new BigDecimal(100)).intValue();
            if (randomVal<=(rateValue+curVal)){
                awardId = awardRateInfo.getAwardId();
                break;
            }
            curVal +=rateValue;
        }
        // 返回中奖结果
        return awardId;
    }
}
