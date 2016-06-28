package com.love.cookies.doctor.Model.Biz.Interface;

import com.love.cookies.doctor.Model.Bean.LoreBean;

/**
 * Created by xiekun on 2015/11/30 0030.
 *
 * 健康知识逻辑接口
 */
public interface ILoreMainBiz {
    public void getLoreDate(CallBack<LoreBean> callBack);
}
