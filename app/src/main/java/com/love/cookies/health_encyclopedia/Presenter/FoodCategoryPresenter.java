package com.love.cookies.health_encyclopedia.Presenter;

import com.love.cookies.health_encyclopedia.App.HEApplication;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ToastUtils;

import com.love.cookies.health_encyclopedia.Model.Bean.FoodBean;
import com.love.cookies.health_encyclopedia.Model.Biz.FoodCategoryBiz;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.CallBack;
import com.love.cookies.health_encyclopedia.R;
import com.love.cookies.health_encyclopedia.View.Interface.IFoodCategory;

/**
 * Created by xiekun on 2015/11/27 0027.
 *
 * 食品条目Presenter
 */
public class FoodCategoryPresenter {

    private FoodCategoryBiz foodCategoryBiz;
    private IFoodCategory iFoodCategory;

    public FoodCategoryPresenter(IFoodCategory iFoodCategory) {
        foodCategoryBiz = new FoodCategoryBiz();
        this.iFoodCategory = iFoodCategory;
    }

    public void getFoodCategoryDate(final int page, String api, int id) {
        if(HEApplication.getInstance().checkNetwork()) {
            iFoodCategory.showLoading();
            foodCategoryBiz.getFoodCategoryDate(page, api, id, new CallBack<FoodBean>() {
                @Override
                public void getSuccess(FoodBean result) {
                    if(result.getYi18().size() == 0 && page == 1) {
                        iFoodCategory.setEmptyView();
                    } else {
                        iFoodCategory.initFoodDate(result);
                    }
                    iFoodCategory.hideLoading();
                }

                @Override
                public void getFailed(String msg) {
                    ToastUtils.show(ActivityCollections.getInstance().currentActivity(), R.string.loading_failed);
                    iFoodCategory.setFailedView();
                    iFoodCategory.hideLoading();
                }
            });
        }
    }

}
