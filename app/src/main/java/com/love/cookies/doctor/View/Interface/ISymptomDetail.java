package com.love.cookies.doctor.View.Interface;

import com.love.cookies.doctor.Model.Bean.SymptomDetailBean;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 症状详情Activity View接口
 */
public interface ISymptomDetail {
    void initSymptomDetail(SymptomDetailBean symptomDetailBean);
    void setEmptyView();
    void setFailedView();
    void showLoading();
    void hideLoading();
}
