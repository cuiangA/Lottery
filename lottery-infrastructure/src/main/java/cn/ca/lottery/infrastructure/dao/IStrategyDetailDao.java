package cn.ca.lottery.infrastructure.dao;

import cn.ca.lottery.infrastructure.po.Strategy;
import cn.ca.lottery.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IStrategyDetailDao {
    List<StrategyDetail> queryStrategyDetails(Long strategyId);
}
