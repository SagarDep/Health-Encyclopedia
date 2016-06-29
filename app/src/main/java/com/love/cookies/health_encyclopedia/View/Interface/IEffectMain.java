package com.love.cookies.health_encyclopedia.View.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.EffectBean;

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
