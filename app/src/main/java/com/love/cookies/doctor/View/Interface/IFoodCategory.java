package com.love.cookies.doctor.View.Interface;

import com.love.cookies.doctor.Model.Bean.FoodBean;

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
