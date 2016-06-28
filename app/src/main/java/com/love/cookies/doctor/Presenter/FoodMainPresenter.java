package com.love.cookies.doctor.Presenter;

import com.love.cookies.doctor.App.DoctorApplication;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ToastUtils;

import com.love.cookies.doctor.Model.Bean.FoodBean;
import com.love.cookies.doctor.Model.Biz.FoodMainBiz;
import com.love.cookies.doctor.Model.Biz.Interface.CallBack;
import com.love.cookies.doctor.R;
import com.love.cookies.doctor.View.Interface.IFoodMain;

/**
 * Created by xiekun on 2015/11/25 0025.
 *
 * 食品Presenter
 */
public class FoodMainPresenter {

    private FoodMainBiz foodMainBiz;
    private IFoodMain iFoodMain;

    public FoodMainPresenter(IFoodMain iFoodMain) {
        foodMainBiz = new FoodMainBiz();
        this.iFoodMain = iFoodMain;
    }

    public void getFoodDate(final int page) {
        if(DoctorApplication.getInstance().checkNetwork()) {
            iFoodMain.showLoading();
            foodMainBiz.getFoodDate(page, new CallBack<FoodBean>() {
                @Override
                public void getSuccess(FoodBean result) {
                    if(result.getYi18().size() == 0 && page == 1) {
                        iFoodMain.setEmptyView();
                    } else {
                        iFoodMain.initFoodDate(result);
                    }
                    iFoodMain.hideLoading();
                }

                @Override
                public void getFailed(String msg) {
                    ToastUtils.show(ActivityCollections.getInstance().currentActivity(), R.string.loading_failed);
                    iFoodMain.setFailedView();
                    iFoodMain.hideLoading();
                }
            });
        }
    }

}
