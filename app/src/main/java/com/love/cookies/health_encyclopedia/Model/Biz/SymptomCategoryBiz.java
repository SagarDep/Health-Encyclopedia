package com.love.cookies.health_encyclopedia.Model.Biz;

import android.text.TextUtils;

import com.google.gson.Gson;

import com.love.cookies.health_encyclopedia.Config.APIs;
import com.love.cookies.health_encyclopedia.Model.Bean.SymptomCategoryBean;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.CallBack;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.ISymptomCategoryBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 症状条目逻辑
 */
public class SymptomCategoryBiz implements ISymptomCategoryBiz {

    Gson gson = new Gson();

    @Override
    public void getSymptomCategoryDate(int page, int id, final CallBack<SymptomCategoryBean> callBack) {
        RequestParams params = new RequestParams(APIs.APIX_SYMPTOM_LIST);
        params.addHeader("apix-key", APIs.APIX_SYMPTOM_KEY);
        params.addQueryStringParameter("id", Integer.toString(id));
        params.addQueryStringParameter("page", Integer.toString(page));
        params.addQueryStringParameter("limit", Integer.toString(APIs.PAGE_LIMIT));
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                if(!TextUtils.isEmpty(s)) {
                    callBack.getSuccess(gson.fromJson(s, SymptomCategoryBean.class));
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
