package cn.ca.lottery.domain.award.service.goods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class DistributionBase implements IDistributionGoods{
    protected Logger logger = LoggerFactory.getLogger(DistributionBase.class);

    protected void updateUserAwardState(String uId, String orderId, String awardId, Integer awardState, String awardStateInfo) {
        // TODO 后期添加更新分库分表中，用户个人的抽奖记录表中奖品发奖状态
        logger.info("TODO 后期添加更新分库分表中，用户个人的抽奖记录表中奖品发奖状态 uId：{}", uId);
    }
}
