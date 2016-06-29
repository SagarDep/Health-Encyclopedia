package com.love.cookies.health_encyclopedia.View.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.ChangeLogBean;

/**
 * Created by xiekun on 2015/12/3 0003.
 *
 * 版本信息Activity View接口
 */
public interface IVersion {
    void initChangeLog(ChangeLogBean changeLogBean);
    void onFailed();
}
