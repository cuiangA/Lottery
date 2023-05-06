package cn.ca.lottery.test;


import cn.ca.lottery.domain.strategy.model.req.DrawReq;
import cn.ca.lottery.domain.strategy.model.res.DrawResult;
import cn.ca.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.ca.lottery.domain.strategy.service.Draw.IDrawExec;
import cn.ca.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.hutool.json.JSONUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DrawAlgorithmTest {

//    @Resource(name = "defaultRateRandomDrawAlgorithm")
    @Resource(name = "singleRateRandomDrawAlgorithm")
    private IDrawAlgorithm randomDrawAlgorithm;
    @Resource
    private IDrawExec drawExec;
    @Before
    public void init() {
        // 奖品信息
        List<AwardRateInfo> strategyList = new ArrayList<>();
        strategyList.add(new AwardRateInfo("一等奖：IMac", new BigDecimal("0.05")));
        strategyList.add(new AwardRateInfo("二等奖：iphone", new BigDecimal("0.15")));
        strategyList.add(new AwardRateInfo("三等奖：ipad", new BigDecimal("0.20")));
        strategyList.add(new AwardRateInfo("四等奖：AirPods", new BigDecimal("0.25")));
        strategyList.add(new AwardRateInfo("五等奖：充电宝", new BigDecimal("0.35")));

        // 初始数据
        randomDrawAlgorithm.initRateTuple(100001L, strategyList);
    }

    @Test
    public void test_randomDrawAlgorithm() {

        DrawReq drawReq = new DrawReq("1", 10001L);
        for (int i = 0; i < 100; i++) {
            DrawResult drawResult = drawExec.doDrawExec(drawReq);
            System.out.println("中奖结果：" + JSONUtil.parse(drawResult));
        }
    }
}