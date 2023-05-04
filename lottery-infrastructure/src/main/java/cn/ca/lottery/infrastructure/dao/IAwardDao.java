package cn.ca.lottery.infrastructure.dao;

import cn.ca.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IAwardDao {
    Award queryAwardInfoByID(String id);
}
