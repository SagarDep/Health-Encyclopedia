package com.love.cookies.health_encyclopedia.Model.Biz.Interface;

/**
 * Created by xiekun on 2015/11/25 0025.
 *
 * 回调
 */
public interface CallBack<T> {
    void getSuccess(T result);
    void getFailed(String msg);
}
