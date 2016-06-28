package com.love.cookies.doctor.Model.Biz.Interface;

import com.love.cookies.doctor.Model.Bean.FunctionBean;

/**
 * Created by xiekun on 2015/11/26 0026.
 *
 * 功能逻辑接口
 */
public interface IFunctionMainBiz {
    public void getFunctionDate(CallBack<FunctionBean> callBack);
}
