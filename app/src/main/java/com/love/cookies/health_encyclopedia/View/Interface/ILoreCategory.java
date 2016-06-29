package com.love.cookies.health_encyclopedia.View.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.LoreCategoryBean;

/**
 * Created by xiekun on 2015/11/30 0030.
 *
 * 知识条目Activity View接口
 */
public interface ILoreCategory {
    void initLoreCategoryDate(LoreCategoryBean loreCategoryBean);
    void setEmptyView();
    void setFailedView();
    void showLoading();
    void hideLoading();
}
