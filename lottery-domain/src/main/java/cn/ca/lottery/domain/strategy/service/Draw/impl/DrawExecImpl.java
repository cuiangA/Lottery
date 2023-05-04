package cn.ca.lottery.domain.strategy.service.Draw.impl;

import ch.qos.logback.core.util.SystemInfo;
import cn.ca.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.ca.lottery.domain.strategy.model.req.DrawReq;
import cn.ca.lottery.domain.strategy.model.res.DrawResult;
import cn.ca.lottery.domain.strategy.repository.IStrategyRepository;
import cn.ca.lottery.domain.strategy.service.Draw.DrawBase;
import cn.ca.lottery.domain.strategy.service.Draw.IDrawExec;
import cn.ca.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.ca.lottery.infrastructure.po.Award;
import cn.ca.lottery.infrastructure.po.Strategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("drawExec")
public class DrawExecImpl extends DrawBase implements IDrawExec {
    private Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);
    @Resource
    private IStrategyRepository strategyRepository;

    @Override
    public DrawResult doDrawExec(DrawReq req) {
        Long strategyId = req.getStrategyId();
        logger.info("执行策略抽奖开始，strategyId：{}", strategyId);
        String uId = req.getUId();
        //通过数据库查询到strategy,strategyDetail
        StrategyRich strategyRich = strategyRepository.queryStrategyRich(strategyId);
        int strategyMode = strategyRich.getStrategy().getStrategyMode();
        //验证该抽奖策略是否完成初始化,否则完成初始化
        checkAndInitRateData(strategyId,strategyMode,strategyRich.getStrategyDetail());
        //按照既定策略抽奖
        IDrawAlgorithm drawAlgorithm = StrategyMode.get(strategyMode);
        String awardId = drawAlgorithm.RandomDraw(strategyId, new ArrayList<>());
        //获得奖品详情
        Award award = strategyRepository.queryAwardInfo(awardId);
        logger.info("执行策略抽奖完成，中奖用户：{} 奖品ID：{} 奖品名称：{}", uId, awardId, award.getAwardName());

        return new DrawResult(uId,strategyId,awardId,award.getAwardName());
    }
}
