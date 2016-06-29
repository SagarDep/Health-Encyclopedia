package com.love.cookies.health_encyclopedia.View.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.FoodBean;

/**
 * Created by xiekun on 2015/11/25 0025.
 *
 * 食品Fragment View接口
 */
public interface IFoodMain {
    void initFoodDate(FoodBean foodBean);
    void setEmptyView();
    void setFailedView();
    void showLoading();
    void hideLoading();
}
