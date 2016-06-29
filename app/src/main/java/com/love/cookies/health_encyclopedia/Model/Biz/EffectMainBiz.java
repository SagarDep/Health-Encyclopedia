package com.love.cookies.health_encyclopedia.Model.Biz;

import android.text.TextUtils;

import com.google.gson.Gson;

import com.love.cookies.health_encyclopedia.Config.APIs;
import com.love.cookies.health_encyclopedia.Model.Bean.EffectBean;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.CallBack;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.IEffectMainBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by xiekun on 2015/11/26 0026.
 *
 * 疗效逻辑
 */
public class EffectMainBiz implements IEffectMainBiz {

    Gson gson = new Gson();

    @Override
    public void getEffectDate(final CallBack<EffectBean> callBack) {
        RequestParams params = new RequestParams(APIs.APIX_FOOD_MENU);
        params.addHeader("apix-key", APIs.APIX_FOOD_KEY);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                if(!TextUtils.isEmpty(s)) {
                    callBack.getSuccess(gson.fromJson(s, EffectBean.class));
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
