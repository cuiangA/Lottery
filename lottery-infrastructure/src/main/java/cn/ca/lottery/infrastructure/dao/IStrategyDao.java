package cn.ca.lottery.infrastructure.dao;

import cn.ca.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IStrategyDao {
    Strategy queryStrategyById(Long id);
}
