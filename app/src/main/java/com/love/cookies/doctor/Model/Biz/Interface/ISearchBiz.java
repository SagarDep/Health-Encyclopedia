package com.love.cookies.doctor.Model.Biz.Interface;

import com.love.cookies.doctor.Model.Bean.SearchBean;

/**
 * Created by xiekun on 2015/11/27 0027.
 *
 * 搜索逻辑接口
 */
public interface ISearchBiz {
    public void doSearch(String api, String key, int page, String keyword, CallBack<SearchBean> callBack);
}
