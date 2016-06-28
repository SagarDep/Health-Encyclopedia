package com.love.cookies.doctor.View.Interface;

import com.love.cookies.doctor.Model.Bean.AskDetailBean;

/**
 * Created by xiekun on 2015/12/1 0001
 *
 * 健康一问详情Activity View接口
 */
public interface IAskDetail {
    void initAskDetail(AskDetailBean askDetailBean);
    void setEmptyView();
    void setFailedView();
    void showLoading();
    void hideLoading();
}
