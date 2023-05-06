package cn.ca.lottery.domain.award.service.factory;

import cn.ca.lottery.common.Constants;
import cn.ca.lottery.domain.award.service.goods.IDistributionGoods;
import cn.ca.lottery.domain.award.service.goods.impl.CouponGoods;
import cn.ca.lottery.domain.award.service.goods.impl.DescGoods;
import cn.ca.lottery.domain.award.service.goods.impl.PhysicalGoods;
import cn.ca.lottery.domain.award.service.goods.impl.RedeemCodeGoods;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */

public class factoryConfig {
    @Resource
    CouponGoods couponGoods;
    @Resource
    DescGoods descGoods;
    @Resource
    PhysicalGoods physicalGoods;
    @Resource
    RedeemCodeGoods redeemCodeGoods;

    protected static Map<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();
    @PostConstruct
    public void init(){
        goodsMap.put(Constants.AwardType.DESC.getCode(), descGoods);
        goodsMap.put(Constants.AwardType.RedeemCodeGoods.getCode(), redeemCodeGoods);
        goodsMap.put(Constants.AwardType.CouponGoods.getCode(), couponGoods);
        goodsMap.put(Constants.AwardType.PhysicalGoods.getCode(), physicalGoods);
    }
}
