package cn.ca.lottery.common;

import lombok.Data;

/**
 * 枚举信息定义
 */
public class Constants {

    public enum ResponseCode {
        SUCCESS("0000", "成功"),
        UN_ERROR("0001","未知失败"),
        ILLEGAL_PARAMETER("0002","非法参数"),
        INDEX_DUP("0003","主键冲突");

        private String code;
        private String info;

        ResponseCode(String code, String info) {
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }

    }
    public enum StrategyMode{
        SINGLE(1,"单项概率"),
        ENTIRETY(2,"总体概率");
        private Integer code;
        private String info;
        StrategyMode(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    public enum DrawState{
        FAIL(0,"未中奖"),
        SUCCESS(1,"中奖"),
        Cover(2,"参与奖");
        private Integer code;
        private String Info;

        DrawState(Integer code, String info) {
            this.code = code;
            Info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return Info;
        }

        public void setInfo(String info) {
            Info = info;
        }
    }
    public enum AwardState{
        WAIT(0,"等待发奖"),
        SUCCESS(1,"已成功领奖"),
        FAILURE(2,"发奖失败");
        private Integer code;
        private String Info;

        AwardState(Integer code, String info) {
            this.code = code;
            Info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return Info;
        }

        public void setInfo(String info) {
            Info = info;
        }
    }
    public enum AwardType {
        /**
         * 文字描述
         */
        DESC(1, "文字描述"),
        /**
         * 兑换码
         */
        RedeemCodeGoods(2, "兑换码"),
        /**
         * 优惠券
         */
        CouponGoods(3, "优惠券"),
        /**
         * 实物奖品
         */
        PhysicalGoods(4, "实物奖品");

        private Integer code;
        private String info;

        AwardType(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }
}
