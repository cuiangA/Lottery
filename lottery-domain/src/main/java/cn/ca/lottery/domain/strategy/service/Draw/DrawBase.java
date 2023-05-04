package cn.ca.lottery.domain.strategy.service.Draw;

import cn.ca.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.ca.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.ca.lottery.infrastructure.po.StrategyDetail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DrawBase extends DrawConfig {
    public void checkAndInitRateData(Long strategyID, Integer strategyMode, List<StrategyDetail> strategyDetailList){
        if (strategyMode==1){
            return;
        }
        IDrawAlgorithm drawAlgorithm = StrategyMode.get(strategyMode);
        //验证是否已经初始化
        if (drawAlgorithm.isExitRateTuple(strategyID)){
            return;
        }
        //完成初始化
        ArrayList<AwardRateInfo> rateInfoList = new ArrayList<>();
        for (StrategyDetail strategyDetail : strategyDetailList) {
            BigDecimal awardRate = strategyDetail.getAwardRate();
            String awardId = strategyDetail.getAwardId();
            rateInfoList.add(new AwardRateInfo(awardId,awardRate));
        }
        drawAlgorithm.initRateTuple(strategyID,rateInfoList);
    }
}
