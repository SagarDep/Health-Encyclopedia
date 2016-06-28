package com.love.cookies.doctor.Model.Biz;

import android.content.Context;

import com.google.gson.Gson;

import com.love.cookies.doctor.Model.Bean.ChangeLogBean;
import com.love.cookies.doctor.Model.Biz.Interface.CallBack;
import com.love.cookies.doctor.Model.Biz.Interface.IChangeLogBiz;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xiekun on 2015/12/3 0003.
 *
 * 更新日志逻辑
 */
public class ChangeLogBiz implements IChangeLogBiz {

    Gson gson = new Gson();

    @Override
    public void getChangeLog(Context context, CallBack<ChangeLogBean> callBack) {
        String changeLog;
        try {
            InputStream inputStream = context.getResources().getAssets().open("change_log.json");
            byte [] buffer = new byte[inputStream.available()] ;
            inputStream.read(buffer);
            changeLog = new String(buffer,"utf-8");

            callBack.getSuccess(gson.fromJson(changeLog, ChangeLogBean.class));
        } catch (IOException e) {
            e.printStackTrace();
            callBack.getFailed(e.getMessage());
        }
    }
}
