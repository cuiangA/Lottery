package cn.ca.lottery.domain.strategy.model.res;

import lombok.Data;

/**UserId;
 *strategyId;
 *awardID;
 *awardName;
 */
@Data
public class DrawResult {
    //用户id
    private String UserId;
    //策略ID
    private Long strategyId;
    //奖品id
    private String awardID;
    //奖品name
    private String awardName;

    public DrawResult(String userId, Long strategyId, String awardID, String awardName) {
        UserId = userId;
        this.strategyId = strategyId;
        this.awardID = awardID;
        this.awardName = awardName;
    }
}
