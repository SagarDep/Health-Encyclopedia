package com.love.cookies.doctor.Model.Biz;

import android.text.TextUtils;

import com.google.gson.Gson;

import com.love.cookies.doctor.Config.APIs;
import com.love.cookies.doctor.Model.Bean.AskCategoryBean;
import com.love.cookies.doctor.Model.Biz.Interface.CallBack;
import com.love.cookies.doctor.Model.Biz.Interface.IAskCategoryBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 健康一问条目逻辑
 */
public class AskCategoryBiz implements IAskCategoryBiz {

    Gson gson = new Gson();

    @Override
    public void getAskCategoryDate(int page, int id, final CallBack<AskCategoryBean> callBack) {
        RequestParams params = new RequestParams(APIs.APIX_ASK_LIST);
        params.addHeader("apix-key", APIs.APIX_ASK_KEY);
        params.addQueryStringParameter("id", Integer.toString(id));
        params.addQueryStringParameter("page", Integer.toString(page));
        params.addQueryStringParameter("limit", Integer.toString(APIs.PAGE_LIMIT));
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                if(!TextUtils.isEmpty(s)) {
                    callBack.getSuccess(gson.fromJson(s, AskCategoryBean.class));
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
