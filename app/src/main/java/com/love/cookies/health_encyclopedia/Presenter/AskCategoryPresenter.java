package com.love.cookies.health_encyclopedia.Presenter;

import com.love.cookies.health_encyclopedia.App.HEApplication;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ToastUtils;

import com.love.cookies.health_encyclopedia.Model.Bean.AskCategoryBean;
import com.love.cookies.health_encyclopedia.Model.Biz.AskCategoryBiz;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.CallBack;
import com.love.cookies.health_encyclopedia.R;
import com.love.cookies.health_encyclopedia.View.Interface.IAskCategory;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 健康一问条目Presenter
 */
public class AskCategoryPresenter {

    private AskCategoryBiz askCategoryBiz;
    private IAskCategory iAskCategory;

    public AskCategoryPresenter(IAskCategory iAskCategory) {
        askCategoryBiz = new AskCategoryBiz();
        this.iAskCategory = iAskCategory;
    }

    public void getAskCategoryDate(final int page, int id) {
        if(HEApplication.getInstance().checkNetwork()) {
            iAskCategory.showLoading();
            askCategoryBiz.getAskCategoryDate(page, id, new CallBack<AskCategoryBean>() {
                @Override
                public void getSuccess(AskCategoryBean result) {
                    if(result.getYi18().size() == 0 && page == 1) {
                        iAskCategory.setEmptyView();
                    } else {
                        iAskCategory.initAskCategoryDate(result);
                    }
                    iAskCategory.hideLoading();
                }

                @Override
                public void getFailed(String msg) {
                    ToastUtils.show(ActivityCollections.getInstance().currentActivity(), R.string.loading_failed);
                    iAskCategory.setFailedView();
                    iAskCategory.hideLoading();
                }
            });
        }
    }

}
