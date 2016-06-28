package com.love.cookies.doctor.View.Interface;

import com.love.cookies.doctor.Model.Bean.SymptomBean;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 症状Activity View接口
 */
public interface ISymptomMain {
    void initSymptomDate(SymptomBean symptomBean);
    void setEmptyView();
    void setFailedView();
    void showLoading();
    void hideLoading();
}
