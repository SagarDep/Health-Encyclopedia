package com.love.cookies.doctor.Model.Biz;

import android.text.TextUtils;

import com.google.gson.Gson;

import com.love.cookies.doctor.Config.APIs;
import com.love.cookies.doctor.Model.Bean.FoodDetailBean;
import com.love.cookies.doctor.Model.Biz.Interface.CallBack;
import com.love.cookies.doctor.Model.Biz.Interface.IFoodDetailBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by xiekun on 2015/11/26 0026.
 *
 * 食品详情逻辑
 */
public class FoodDetailBiz implements IFoodDetailBiz {

    Gson gson = new Gson();

    @Override
    public void getFoodDetail(int id, final CallBack<FoodDetailBean> callBack) {
        RequestParams params = new RequestParams(APIs.APIX_FOOD_DETAIL);
        params.addHeader("apix-key", APIs.APIX_FOOD_KEY);
        params.addQueryStringParameter("id", Integer.toString(id));
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                if(!TextUtils.isEmpty(s)) {
                    callBack.getSuccess(gson.fromJson(s, FoodDetailBean.class));
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
