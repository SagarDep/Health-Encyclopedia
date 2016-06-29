package com.love.cookies.health_encyclopedia.Model.Biz.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.SymptomDetailBean;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 症状详情逻辑接口
 */
public interface ISymptomDetailBiz {
    public void getSymptomDetail(int id, CallBack<SymptomDetailBean> callBack);
}
