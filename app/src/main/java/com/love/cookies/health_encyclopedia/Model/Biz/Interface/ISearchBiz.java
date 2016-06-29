package com.love.cookies.health_encyclopedia.Model.Biz.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.SearchBean;

/**
 * Created by xiekun on 2015/11/27 0027.
 *
 * 搜索逻辑接口
 */
public interface ISearchBiz {
    public void doSearch(String api, String key, int page, String keyword, CallBack<SearchBean> callBack);
}
