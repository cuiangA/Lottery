package cn.ca.lottery.domain.award.service.factory;
import cn.ca.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

/**
 * 配送商品简单工厂，提供获取配送服务
 */
@Service
public class DistributionFactory extends factoryConfig{
    public IDistributionGoods getDistributionGoodsService(Integer awardType){
        return goodsMap.get(awardType);
    }
}
