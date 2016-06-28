package com.love.cookies.doctor.Model.Biz.Interface;

import com.love.cookies.doctor.Model.Bean.EffectBean;

/**
 * Created by xiekun on 2015/11/26 0026.
 *
 * 疗效逻辑接口
 */
public interface IEffectMainBiz {
    public void getEffectDate(CallBack<EffectBean> callBack);
}
