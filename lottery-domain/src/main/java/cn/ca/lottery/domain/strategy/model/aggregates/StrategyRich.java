package cn.ca.lottery.domain.strategy.model.aggregates;

import cn.ca.lottery.infrastructure.po.Strategy;
import cn.ca.lottery.infrastructure.po.StrategyDetail;
import lombok.Data;

import java.util.List;

/**
 * strategyId strategy strategyDetail
 */
@Data
public class StrategyRich {
    private Long strategyId;
    private Strategy strategy;
    private List<StrategyDetail> strategyDetail;

    public StrategyRich(Long strategyId, Strategy strategy, List<StrategyDetail> strategyDetail) {
        this.strategyId = strategyId;
        this.strategy = strategy;
        this.strategyDetail = strategyDetail;
    }
}
