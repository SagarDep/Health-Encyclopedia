package com.love.cookies.doctor.Model.Biz;

import android.text.TextUtils;

import com.google.gson.Gson;

import com.love.cookies.doctor.Config.APIs;
import com.love.cookies.doctor.Model.Bean.SymptomDetailBean;
import com.love.cookies.doctor.Model.Biz.Interface.CallBack;
import com.love.cookies.doctor.Model.Biz.Interface.ISymptomDetailBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 症状详情逻辑
 */
public class SymptomDetailBiz implements ISymptomDetailBiz {

    Gson gson = new Gson();

    @Override
    public void getSymptomDetail(int id, final CallBack<SymptomDetailBean> callBack) {
        RequestParams params = new RequestParams(APIs.APIX_SYMPTOM_DETAIL);
        params.addHeader("apix-key", APIs.APIX_SYMPTOM_KEY);
        params.addQueryStringParameter("id", Integer.toString(id));
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                if(!TextUtils.isEmpty(s)) {
                    callBack.getSuccess(gson.fromJson(s, SymptomDetailBean.class));
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
