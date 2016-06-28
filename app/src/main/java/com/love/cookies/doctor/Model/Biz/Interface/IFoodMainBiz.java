package com.love.cookies.doctor.Model.Biz.Interface;

import com.love.cookies.doctor.Model.Bean.FoodBean;

/**
 * Created by xiekun on 2015/11/25 0025.
 *
 * 食品逻辑接口
 */
public interface IFoodMainBiz {
    public void getFoodDate(int page, CallBack<FoodBean> callBack);
}
