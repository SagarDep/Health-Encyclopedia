package com.love.cookies.health_encyclopedia.Model.Biz;

import android.text.TextUtils;

import com.google.gson.Gson;

import com.love.cookies.health_encyclopedia.Config.APIs;
import com.love.cookies.health_encyclopedia.Model.Bean.LoreDetailBean;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.CallBack;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.ILoreDetailBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by xiekun on 2015/11/30 0030.
 *
 * 健康知识详情逻辑
 */
public class LoreDetailBiz implements ILoreDetailBiz {

    Gson gson = new Gson();

    @Override
    public void getLoreDetail(int id, final CallBack<LoreDetailBean> callBack) {
        RequestParams params = new RequestParams(APIs.APIX_LORE_DETAIL);
        params.addHeader("apix-key", APIs.APIX_LORE_KEY);
        params.addQueryStringParameter("id", Integer.toString(id));
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                if(!TextUtils.isEmpty(s)) {
                    callBack.getSuccess(gson.fromJson(s, LoreDetailBean.class));
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
