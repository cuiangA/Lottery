package cn.ca.lottery.domain.award.service.goods.impl;

import cn.ca.lottery.common.Constants;
import cn.ca.lottery.domain.award.model.req.GoodsReq;
import cn.ca.lottery.domain.award.model.res.DistributionRes;
import cn.ca.lottery.domain.award.service.goods.DistributionBase;
import org.springframework.stereotype.Service;

@Service
public class CouponGoods extends DistributionBase {
    @Override
    public DistributionRes distributionGoods(GoodsReq goodsReq) {

        super.updateUserAwardState(goodsReq.getUId(), goodsReq.getOrderId(), goodsReq.getAwardId(),
                Constants.AwardState.SUCCESS.getCode(),
                Constants.AwardState.SUCCESS.getInfo());
        return new DistributionRes(goodsReq.getUId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }

    @Override
    public Integer getGoodsName() {
        return Constants.AwardType.CouponGoods.getCode();
    }
}
