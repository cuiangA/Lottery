package cn.ca.lottery.rpc;

import cn.ca.lottery.rpc.req.ActivityReq;
import cn.ca.lottery.rpc.res.ActivityRes;

/**
 * 活动展台
 * 1. 创建活动
 * 2. 更新活动
 * 3. 查询活动
 */
public interface IActivityBooth {
    ActivityRes queryActivityById(ActivityReq req);
}
