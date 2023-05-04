package cn.ca.lottery.interfaces;

/**
 * 活动展台
 */
//暴露接口
//@DubboService
//public class ActivityBooth implements IActivityBooth {
//
//    @Resource
//    private IActivityDao activityDao;
//
//    @Override
//    public ActivityRes queryActivityById(ActivityReq req) {
//        //通过活动的id获取活动信息
//        Activity activity = activityDao.queryActivityById(req.getActivityId());
//        ActivityDto activityDto = BeanUtil.copyProperties(activity, ActivityDto.class);
//        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo()), activityDto);
//    }
//
//}
