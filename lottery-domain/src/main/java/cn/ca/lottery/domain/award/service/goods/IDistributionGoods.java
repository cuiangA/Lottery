package cn.ca.lottery.domain.award.service.goods;

import cn.ca.lottery.domain.award.model.req.GoodsReq;
import cn.ca.lottery.domain.award.model.res.DistributionRes;

/**
 * 配发奖品的总接口
 */
public interface IDistributionGoods {
    /**
     * 执行分发操作
     * @param goodsReq 配发货物的信息
     * @return 配发结果
     */
    DistributionRes distributionGoods(GoodsReq goodsReq);

    Integer getGoodsName();
}
