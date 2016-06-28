package com.love.cookies.doctor.Model.Biz;

import android.text.TextUtils;

import com.google.gson.Gson;

import com.love.cookies.doctor.Config.APIs;
import com.love.cookies.doctor.Model.Bean.LoreCategoryBean;
import com.love.cookies.doctor.Model.Biz.Interface.CallBack;
import com.love.cookies.doctor.Model.Biz.Interface.ILoreCategoryBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by xiekun on 2015/11/30 0030.
 *
 * 健康知识条目逻辑
 */
public class LoreCategoryBiz implements ILoreCategoryBiz {

    Gson gson = new Gson();

    @Override
    public void getLoreCategoryDate(int page, int id, final CallBack<LoreCategoryBean> callBack) {
        RequestParams params = new RequestParams(APIs.APIX_LORE_LIST);
        params.addHeader("apix-key", APIs.APIX_LORE_KEY);
        params.addQueryStringParameter("id", Integer.toString(id));
        params.addQueryStringParameter("page", Integer.toString(page));
        params.addQueryStringParameter("limit", Integer.toString(APIs.PAGE_LIMIT));
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                if(!TextUtils.isEmpty(s)) {
                    callBack.getSuccess(gson.fromJson(s, LoreCategoryBean.class));
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
