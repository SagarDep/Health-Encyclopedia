package com.love.cookies.health_encyclopedia.Model.Biz.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.LoreDetailBean;

/**
 * Created by xiekun on 2015/11/30 0030.
 *
 * 健康知识详情逻辑接口
 */
public interface ILoreDetailBiz {
    public void getLoreDetail(int id, CallBack<LoreDetailBean> callBack);
}
