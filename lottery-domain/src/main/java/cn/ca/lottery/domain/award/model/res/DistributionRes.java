package cn.ca.lottery.domain.award.model.res;

import lombok.Data;

@Data
public class DistributionRes {
    /** 用户ID */
    private String uId;
    /** 编码 */
    private Integer code;
    /** 描述 */
    private String info;
    /** 结算单ID，如：发券后有券码、发货后有单号等，用于存根查询 */
    private String statementId;

    public DistributionRes(String uId, Integer code, String info) {
        this.uId = uId;
        this.code = code;
        this.info = info;
    }
    public DistributionRes(String uId, Integer code, String info, String statementId) {
        this.uId = uId;
        this.code = code;
        this.info = info;
        this.statementId = statementId;
    }
}
