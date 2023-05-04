package cn.ca.lottery.domain.strategy.service.Draw;

import cn.ca.lottery.domain.strategy.model.req.DrawReq;
import cn.ca.lottery.domain.strategy.model.res.DrawResult;

public interface IDrawExec {
    DrawResult doDrawExec(DrawReq req);
}
