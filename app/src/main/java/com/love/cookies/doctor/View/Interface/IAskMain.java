package com.love.cookies.doctor.View.Interface;

import com.love.cookies.doctor.Model.Bean.AskBean;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 健康一问Activity View接口
 */
public interface IAskMain {
    void initAskDate(AskBean askBean);
    void setEmptyView();
    void setFailedView();
    void showLoading();
    void hideLoading();
}
