package com.love.cookies.health_encyclopedia.Model.Biz;

import android.text.TextUtils;

import com.google.gson.Gson;

import com.love.cookies.health_encyclopedia.Config.APIs;
import com.love.cookies.health_encyclopedia.Model.Bean.FoodBean;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.CallBack;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.IFoodCategoryBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by xiekun on 2015/11/27 0027.
 *
 * 食品条目逻辑
 */
public class FoodCategoryBiz implements IFoodCategoryBiz {

    Gson gson = new Gson();

    @Override
    public void getFoodCategoryDate(int page, String api, int id, final CallBack<FoodBean> callBack) {
        RequestParams params = new RequestParams(api);
        params.addHeader("apix-key", APIs.APIX_FOOD_KEY);
        params.addQueryStringParameter("id", Integer.toString(id));
        params.addQueryStringParameter("page", Integer.toString(page));
        params.addQueryStringParameter("limit", Integer.toString(APIs.PAGE_LIMIT));
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                if(!TextUtils.isEmpty(s)) {
                    callBack.getSuccess(gson.fromJson(s, FoodBean.class));
                }
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                callBack.getFailed(throwable.getMessage());
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

}
