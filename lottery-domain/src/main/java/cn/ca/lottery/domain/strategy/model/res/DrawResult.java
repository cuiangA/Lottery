package cn.ca.lottery.domain.strategy.model.res;

import cn.ca.lottery.common.Constants;
import cn.ca.lottery.domain.strategy.model.vo.DrawAwardInfo;
import lombok.Data;

/**
 *UserId;
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
    /**
     * 中奖状态：0未中奖、1已中奖、2兜底奖 Constants.DrawState
     */
    private Integer drawState = Constants.DrawState.FAIL.getCode();
    /**
     * 中奖奖品信息
     */
    private DrawAwardInfo drawAwardInfo;

    public DrawResult(String userId, Long strategyId, Integer drawState) {
        UserId = userId;
        this.strategyId = strategyId;
        this.drawState = drawState;
    }

    public DrawResult(String userId, Long strategyId, Integer drawState, DrawAwardInfo drawAwardInfo) {
        UserId = userId;
        this.strategyId = strategyId;
        this.drawState = drawState;
        this.drawAwardInfo = drawAwardInfo;
    }
}
