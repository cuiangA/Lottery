package cn.ca.lottery.domain.strategy.model.vo;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class AwardRateInfo {
    private String awardId;
    private BigDecimal awardRate;

    public AwardRateInfo(String awardId, BigDecimal awardRate) {
        this.awardId = awardId;
        this.awardRate = awardRate;
    }
}
