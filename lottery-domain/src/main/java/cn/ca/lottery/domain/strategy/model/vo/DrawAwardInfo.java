package cn.ca.lottery.domain.strategy.model.vo;

import lombok.Data;

@Data
public class DrawAwardInfo {
    private String awardId;
    private String awardName;
    private Integer awardType;
    private String awardContent;

    public DrawAwardInfo(String awardId, String awardName, Integer awardType, String awardContent) {
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardType = awardType;
        this.awardContent = awardContent;
    }
}
