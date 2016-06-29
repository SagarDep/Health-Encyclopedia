package com.love.cookies.health_encyclopedia.View.Interface;

import com.love.cookies.health_encyclopedia.Model.Bean.SearchBean;

/**
 * Created by xiekun on 2015/11/27 0027.
 *
 * 搜索Activity View接口
 */
public interface ISearch {
    void startSearch();
    void initSearchResult(SearchBean searchBean);
    void setEmptyView();
    void setFailedView();
    void showLoading();
    void hideLoading();
}
