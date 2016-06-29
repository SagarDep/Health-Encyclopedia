package com.love.cookies.health_encyclopedia.Model.Biz;

import android.text.TextUtils;

import com.google.gson.Gson;

import com.love.cookies.health_encyclopedia.Config.APIs;
import com.love.cookies.health_encyclopedia.Model.Bean.AskBean;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.CallBack;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.IAskMainBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 健康一问逻辑
 */
public class AskMainBiz implements IAskMainBiz {

    Gson gson = new Gson();

    @Override
    public void getAskDate(final CallBack<AskBean> callBack) {
        RequestParams params = new RequestParams(APIs.APIX_ASK_CLASS);
        params.addHeader("apix-key", APIs.APIX_ASK_KEY);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                if(!TextUtils.isEmpty(s)) {
                    callBack.getSuccess(gson.fromJson(s, AskBean.class));
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
