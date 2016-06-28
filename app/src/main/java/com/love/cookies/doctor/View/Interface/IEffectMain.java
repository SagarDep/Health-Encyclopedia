package com.love.cookies.doctor.View.Interface;

import com.love.cookies.doctor.Model.Bean.EffectBean;

/**
 * Created by xiekun on 2015/11/26 0026.
 *
 * 疗效Fragment View接口
 */
public interface IEffectMain {
    void initEffectDate(EffectBean effectBean);
    void setEmptyView();
    void setFailedView();
    void showLoading();
    void hideLoading();
}
