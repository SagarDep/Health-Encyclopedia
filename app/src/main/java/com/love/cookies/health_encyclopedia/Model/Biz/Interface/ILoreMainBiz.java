package com.love.cookies.health_encyclopedia.Model.Biz.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.LoreBean;

/**
 * Created by xiekun on 2015/11/30 0030.
 *
 * 健康知识逻辑接口
 */
public interface ILoreMainBiz {
    public void getLoreDate(CallBack<LoreBean> callBack);
}
