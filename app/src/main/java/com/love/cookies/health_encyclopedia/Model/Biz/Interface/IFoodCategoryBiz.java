package com.love.cookies.health_encyclopedia.Model.Biz.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.FoodBean;

/**
 * Created by xiekun on 2015/11/27 0027.
 *
 * 食品条目逻辑接口
 */
public interface IFoodCategoryBiz {
    public void getFoodCategoryDate(int page, String api, int id, CallBack<FoodBean> callBack);
}
