package com.love.cookies.doctor.Model.Biz.Interface;

import android.content.Context;

import com.love.cookies.doctor.Model.Bean.ChangeLogBean;

/**
 * Created by xiekun on 2015/12/3 0003.
 *
 * 更新日志逻辑接口
 */
public interface IChangeLogBiz {
    void getChangeLog(Context context, CallBack<ChangeLogBean> callBack);
}
