package com.love.cookies.doctor.Model.Biz.Interface;

import com.love.cookies.doctor.Model.Bean.AskDetailBean;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 健康一问详情逻辑接口
 */
public interface IAskDetailBiz {
    public void getAskDetail(int id, CallBack<AskDetailBean> callBack);
}
