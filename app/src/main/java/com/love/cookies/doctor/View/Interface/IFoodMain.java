package com.love.cookies.doctor.View.Interface;

import com.love.cookies.doctor.Model.Bean.FoodBean;

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
