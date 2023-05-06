package cn.ca.lottery.domain.strategy.service.Draw;
import cn.ca.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.ca.lottery.domain.strategy.repository.IStrategyRepository;
import cn.ca.lottery.infrastructure.po.Award;
import cn.ca.lottery.infrastructure.po.Strategy;

import javax.annotation.Resource;
import java.util.List;

public class DrawStrategySupport extends DrawConfig{
    @Resource
    private IStrategyRepository strategyRepository;
    /**
     * 查询策略配置信息
     * @param strategyId 策略ID
     * @return 策略配置信息
     */
    public StrategyRich getStrategyRich(Long strategyId){
        return strategyRepository.queryStrategyRich(strategyId);
    }

    /**
     * 查询奖品详细信息
     * @param awardId 奖品id
     * @return 奖品详细信息
     */
    public Award getAwardInfo(String awardId){
        return strategyRepository.queryAwardInfo(awardId);
    }

    /**
     * 查询没有库存的奖品
     * @param strategyId 策略id
     * @return 没有库存的奖品id集合
     */
    public List<String> getExcludeAwardIds(Long strategyId){
        return strategyRepository.queryNoStockAwards(strategyId);
    }

    /**
     * 扣减库存id
     * @param strategyId 策略id
     * @param awardId 奖品id
     * @return 扣减库存id是否成功
     */
    public boolean deductAwardStock(Long strategyId, String awardId){
        return strategyRepository.deductStock(strategyId,awardId);
    }
}
