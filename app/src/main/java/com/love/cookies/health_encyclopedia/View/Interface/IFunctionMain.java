package com.love.cookies.health_encyclopedia.View.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.FunctionBean;

/**
 * Created by xiekun on 2015/11/26 0026.
 *
 * 功能Fragment View接口
 */
public interface IFunctionMain {
    void initFunctionDate(FunctionBean functionBean);
    void setEmptyView();
    void setFailedView();
    void showLoading();
    void hideLoading();
}
