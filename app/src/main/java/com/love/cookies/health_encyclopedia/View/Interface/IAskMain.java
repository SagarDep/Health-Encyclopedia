package com.love.cookies.health_encyclopedia.View.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.AskBean;

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
