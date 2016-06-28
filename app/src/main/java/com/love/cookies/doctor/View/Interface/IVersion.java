package com.love.cookies.doctor.View.Interface;

import com.love.cookies.doctor.Model.Bean.ChangeLogBean;

/**
 * Created by xiekun on 2015/12/3 0003.
 *
 * 版本信息Activity View接口
 */
public interface IVersion {
    void initChangeLog(ChangeLogBean changeLogBean);
    void onFailed();
}
