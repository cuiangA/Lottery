package cn.ca.lottery.domain.strategy.model.req;

import lombok.Data;

@Data
public class DrawReq {
    //用户id
    private String uId;
    //策略id
    private Long strategyId;

    public DrawReq(String uId, Long strategyId) {
        this.uId = uId;
        this.strategyId = strategyId;
    }
}
