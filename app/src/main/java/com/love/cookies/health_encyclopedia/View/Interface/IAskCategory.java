package com.love.cookies.health_encyclopedia.View.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.AskCategoryBean;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 健康一问条目Activity View接口
 */
public interface IAskCategory {
    void initAskCategoryDate(AskCategoryBean askCategoryBean);
    void setEmptyView();
    void setFailedView();
    void showLoading();
    void hideLoading();
}
