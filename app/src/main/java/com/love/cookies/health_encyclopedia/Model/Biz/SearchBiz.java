package com.love.cookies.health_encyclopedia.Model.Biz;

import android.text.TextUtils;

import com.google.gson.Gson;

import com.love.cookies.health_encyclopedia.Model.Bean.SearchBean;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.CallBack;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.ISearchBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by xiekun on 2015/11/27 0027.
 *
 * 搜索逻辑
 */
public class SearchBiz implements ISearchBiz {

    Gson gson = new Gson();

    @Override
    public void doSearch(String api, String key, int page, String keyword, final CallBack<SearchBean> callBack) {
        RequestParams params = new RequestParams(api);
        params.addHeader("apix-key", key);
        params.addQueryStringParameter("page", Integer.toString(page));
        params.addQueryStringParameter("keyword", keyword);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                if(!TextUtils.isEmpty(s)) {
                    callBack.getSuccess(gson.fromJson(s, SearchBean.class));
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
