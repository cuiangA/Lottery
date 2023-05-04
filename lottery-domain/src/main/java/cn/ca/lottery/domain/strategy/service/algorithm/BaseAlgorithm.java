package cn.ca.lottery.domain.strategy.service.algorithm;
import cn.ca.lottery.domain.strategy.model.vo.AwardRateInfo;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseAlgorithm implements IDrawAlgorithm{
    //斐波那契散列增量，逻辑:黄金分割点
    private final int HASH_INCREMENT = 0x61c88647;
    // 数组初始化长度
    private final int RATE_TUPLE_LENGTH = 128;
    //存放概率与对应的散列结果 strategyId --> rateTuple
    protected Map<Long,String[]> rateTupleMap = new ConcurrentHashMap<>();
    //奖品概率区间 strategyId --> [awardId->begin,awardId->end]
    protected Map<Long,List<AwardRateInfo>> awardRateInfoMap = new ConcurrentHashMap<>();

    /**
     *初始化awardRateInfoMap
     *初始化存放概率与对应的散列结果
     */
    @Override
    public void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfos) {
        awardRateInfoMap.put(strategyId,awardRateInfos);
        String[] rateTuple = rateTupleMap.computeIfAbsent(strategyId, k -> new String[RATE_TUPLE_LENGTH]);

        int cursorVal = 0;
        for (AwardRateInfo awardRateInfo:awardRateInfos) {
            String awardId = awardRateInfo.getAwardId();
            int rateVal = awardRateInfo.getAwardRate().multiply(new BigDecimal(100)).intValue();

            for (int i = cursorVal+1; i <= (rateVal+cursorVal); i++) {
                rateTuple[haveIdx(i)] = awardId;
            }

            cursorVal+=rateVal;
        }
    }

    @Override
    public boolean isExitRateTuple(Long strategyId) {
        return rateTupleMap.containsKey(strategyId);
    }
    /**
     * 斐波那契（Fibonacci）散列法，计算哈希索引下标值
     * @param val 值
     * @return 索引
     */
    public int haveIdx(int val){
        int hashcode = val * HASH_INCREMENT + HASH_INCREMENT;
        return hashcode & (RATE_TUPLE_LENGTH - 1);
    }
}
