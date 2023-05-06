package cn.ca.lottery.domain.strategy.service.Draw;

import cn.ca.lottery.common.Constants;
import cn.ca.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import lombok.CustomLog;
import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 包装两种策略
 */
@Data
public class DrawConfig {
    @Resource(name = "entiretyRateRandomDrawAlgorithm")
    private IDrawAlgorithm entiretyRateRandomDrawAlgorithm;
    @Resource(name = "singleRateRandomDrawAlgorithm")
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;
    //封装两种策略
    protected static HashMap<Integer, IDrawAlgorithm> StrategyMode = new HashMap<>();

    @PostConstruct
    public void init(){
        StrategyMode.put(Constants.StrategyMode.ENTIRETY.getCode(), entiretyRateRandomDrawAlgorithm);
        StrategyMode.put(Constants.StrategyMode.SINGLE.getCode(), singleRateRandomDrawAlgorithm);
    }
}
