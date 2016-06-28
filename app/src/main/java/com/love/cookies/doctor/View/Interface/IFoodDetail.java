package com.love.cookies.doctor.View.Interface;

import com.love.cookies.doctor.Model.Bean.FoodDetailBean;

/**
 * Created by xiekun on 2015/11/26 0026.
 *
 * 食品详情Activity View接口
 */
public interface IFoodDetail {
    void initFoodDetail(FoodDetailBean foodDetailBean);
    void setEmptyView();
    void setFailedView();
    void showLoading();
    void hideLoading();
}
