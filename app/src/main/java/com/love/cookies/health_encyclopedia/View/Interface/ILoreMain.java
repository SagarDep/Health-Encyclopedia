package com.love.cookies.health_encyclopedia.View.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.LoreBean;

/**
 * Created by xiekun on 2015/11/30 0030.
 *
 * 知识Activity View接口
 */
public interface ILoreMain {
    void initLoreDate(LoreBean loreBean);
    void setEmptyView();
    void setFailedView();
    void showLoading();
    void hideLoading();
}
