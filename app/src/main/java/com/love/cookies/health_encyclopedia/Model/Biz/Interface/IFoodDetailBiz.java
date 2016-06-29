package com.love.cookies.health_encyclopedia.Model.Biz.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.FoodDetailBean;

/**
 * Created by xiekun on 2015/11/26 0026.
 *
 * 食品详情逻辑接口
 */
public interface IFoodDetailBiz {
    public void getFoodDetail(int id, CallBack<FoodDetailBean> callBack);
}
