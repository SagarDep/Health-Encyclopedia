package com.love.cookies.doctor.View.Interface;

import com.love.cookies.doctor.Model.Bean.SymptomCategoryBean;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 症状条目Activity View接口
 */
public interface ISymptomCategory {
    void initSymptomCategoryDate(SymptomCategoryBean symptomCategoryBean);
    void setEmptyView();
    void setFailedView();
    void showLoading();
    void hideLoading();
}
