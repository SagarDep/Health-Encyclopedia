package com.love.cookies.health_encyclopedia.Model.Biz.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.SymptomCategoryBean;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 症状条目逻辑接口
 */
public interface ISymptomCategoryBiz {
    public void getSymptomCategoryDate(int page, int id, CallBack<SymptomCategoryBean> callBack);
}
