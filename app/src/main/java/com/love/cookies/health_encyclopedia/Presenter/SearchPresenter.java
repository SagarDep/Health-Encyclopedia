package com.love.cookies.health_encyclopedia.Presenter;

import com.love.cookies.health_encyclopedia.App.HEApplication;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ToastUtils;

import com.love.cookies.health_encyclopedia.Model.Bean.SearchBean;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.CallBack;
import com.love.cookies.health_encyclopedia.Model.Biz.SearchBiz;
import com.love.cookies.health_encyclopedia.R;
import com.love.cookies.health_encyclopedia.View.Interface.ISearch;

/**
 * Created by xiekun on 2015/11/27 0027.
 *
 * 搜索Presenter
 */
public class SearchPresenter {

    private SearchBiz searchBiz;
    private ISearch iSearch;

    public SearchPresenter(ISearch iSearch) {
        searchBiz = new SearchBiz();
        this.iSearch = iSearch;
    }

    public void getSearchResult(String api, String key, final int page, String keyword) {
        if(HEApplication.getInstance().checkNetwork()) {
            iSearch.showLoading();
            searchBiz.doSearch(api, key, page, keyword, new CallBack<SearchBean>() {
                @Override
                public void getSuccess(SearchBean result) {
                    if(result.getYi18().size() == 0 && page == 1) {
                        iSearch.setEmptyView();
                    } else {
                        iSearch.initSearchResult(result);
                    }
                    iSearch.hideLoading();
                }

                @Override
                public void getFailed(String msg) {
                    ToastUtils.show(ActivityCollections.getInstance().currentActivity(), R.string.loading_failed);
                    iSearch.setFailedView();
                    iSearch.hideLoading();
                }
            });
        }
    }

}
