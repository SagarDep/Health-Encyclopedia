package com.love.cookies.health_encyclopedia.Model.Biz;

import android.text.TextUtils;

import com.google.gson.Gson;

import com.love.cookies.health_encyclopedia.Config.APIs;
import com.love.cookies.health_encyclopedia.Model.Bean.SymptomBean;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.CallBack;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.ISymptomMainBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 症状逻辑
 */
public class SymptomMainBiz implements ISymptomMainBiz {

    Gson gson = new Gson();

    @Override
    public void getSymptomDate(final CallBack<SymptomBean> callBack) {
        RequestParams params = new RequestParams(APIs.APIX_SYMPTOM_PLACE);
        params.addHeader("apix-key", APIs.APIX_SYMPTOM_KEY);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                if(!TextUtils.isEmpty(s)) {
                    callBack.getSuccess(gson.fromJson(s, SymptomBean.class));
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
