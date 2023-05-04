package cn.ca.lottery.domain.strategy.repository.impl;

import cn.ca.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.ca.lottery.domain.strategy.repository.IStrategyRepository;
import cn.ca.lottery.infrastructure.dao.IAwardDao;
import cn.ca.lottery.infrastructure.dao.IStrategyDao;
import cn.ca.lottery.infrastructure.dao.IStrategyDetailDao;
import cn.ca.lottery.infrastructure.po.Award;
import cn.ca.lottery.infrastructure.po.Strategy;
import cn.ca.lottery.infrastructure.po.StrategyDetail;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Component
public class StrategyRepositoryImpl implements IStrategyRepository {
    @Resource
    IAwardDao awardDao;
    @Resource
    IStrategyDao strategyDao;
    @Resource
    IStrategyDetailDao strategyDetailDao;
    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategyById(strategyId);
        List<StrategyDetail> strategyDetails = strategyDetailDao.queryStrategyDetails(strategyId);
        return new StrategyRich(strategyId,strategy,strategyDetails);
    }

    @Override
    public Award queryAwardInfo(String awardId) {
        return awardDao.queryAwardInfoByID(awardId);
    }
}
