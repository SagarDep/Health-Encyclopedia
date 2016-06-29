package com.love.cookies.health_encyclopedia.View.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.FoodBean;

/**
 * Created by xiekun on 2015/11/27 0027.
 *
 * 食品条目Activity View接口
 */
public interface IFoodCategory {
    void initFoodDate(FoodBean foodBean);
    void setEmptyView();
    void setFailedView();
    void showLoading();
    void hideLoading();
}
