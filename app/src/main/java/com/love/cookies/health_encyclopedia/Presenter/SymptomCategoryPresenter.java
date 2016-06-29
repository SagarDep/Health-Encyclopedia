package com.love.cookies.health_encyclopedia.Presenter;

import com.love.cookies.health_encyclopedia.App.DoctorApplication;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ToastUtils;

import com.love.cookies.health_encyclopedia.Model.Bean.SymptomCategoryBean;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.CallBack;
import com.love.cookies.health_encyclopedia.Model.Biz.SymptomCategoryBiz;
import com.love.cookies.health_encyclopedia.R;
import com.love.cookies.health_encyclopedia.View.Interface.ISymptomCategory;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 症状条目Presenter
 */
public class SymptomCategoryPresenter {

    private SymptomCategoryBiz symptomCategoryBiz;
    private ISymptomCategory iSymptomCategory;

    public SymptomCategoryPresenter(ISymptomCategory iSymptomCategory) {
        symptomCategoryBiz = new SymptomCategoryBiz();
        this.iSymptomCategory = iSymptomCategory;
    }

    public void getSymptomCategoryDate(final int page, int id) {
        if(DoctorApplication.getInstance().checkNetwork()) {
            iSymptomCategory.showLoading();
            symptomCategoryBiz.getSymptomCategoryDate(page, id, new CallBack<SymptomCategoryBean>() {
                @Override
                public void getSuccess(SymptomCategoryBean result) {
                    if(result.getYi18().size() == 0 && page == 1) {
                        iSymptomCategory.setEmptyView();
                    } else {
                        iSymptomCategory.initSymptomCategoryDate(result);
                    }
                    iSymptomCategory.hideLoading();
                }

                @Override
                public void getFailed(String msg) {
                    ToastUtils.show(ActivityCollections.getInstance().currentActivity(), R.string.loading_failed);
                    iSymptomCategory.setFailedView();
                    iSymptomCategory.hideLoading();
                }
            });
        }
    }

}
