package com.love.cookies.doctor.Model.Biz.Interface;

import com.love.cookies.doctor.Model.Bean.SymptomBean;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 症状逻辑接口
 */
public interface ISymptomMainBiz {
    public void getSymptomDate(CallBack<SymptomBean> callBack);
}
