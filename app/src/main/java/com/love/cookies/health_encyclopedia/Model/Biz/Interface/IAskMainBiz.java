package com.love.cookies.health_encyclopedia.Model.Biz.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.AskBean;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 健康一问逻辑接口
 */
public interface IAskMainBiz {
    public void getAskDate(CallBack<AskBean> callBack);
}
