package com.love.cookies.doctor.Model.Biz.Interface;

import com.love.cookies.doctor.Model.Bean.AskBean;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 健康一问逻辑接口
 */
public interface IAskMainBiz {
    public void getAskDate(CallBack<AskBean> callBack);
}
