package com.love.cookies.health_encyclopedia.Model.Biz.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.EffectBean;

/**
 * Created by xiekun on 2015/11/26 0026.
 *
 * 疗效逻辑接口
 */
public interface IEffectMainBiz {
    public void getEffectDate(CallBack<EffectBean> callBack);
}
