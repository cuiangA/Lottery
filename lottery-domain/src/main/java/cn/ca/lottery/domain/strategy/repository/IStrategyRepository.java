package cn.ca.lottery.domain.strategy.repository;


import cn.ca.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.ca.lottery.infrastructure.po.Award;

/**
 *
 */
public interface IStrategyRepository {
 
    StrategyRich queryStrategyRich(Long strategyId);

    Award queryAwardInfo(String awardId);

}
