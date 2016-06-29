package com.love.cookies.health_encyclopedia.Presenter;

import com.love.cookies.health_encyclopedia.App.DoctorApplication;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ToastUtils;

import com.love.cookies.health_encyclopedia.Model.Bean.FoodDetailBean;
import com.love.cookies.health_encyclopedia.Model.Biz.FoodDetailBiz;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.CallBack;
import com.love.cookies.health_encyclopedia.R;
import com.love.cookies.health_encyclopedia.View.Interface.IFoodDetail;

/**
 * Created by xiekun on 2015/11/26 0026.
 *
 * 食品详情Presenter
 */
public class FoodDetailPresenter {
    private FoodDetailBiz foodDetailBiz;
    private IFoodDetail iFoodDetail;

    public FoodDetailPresenter(IFoodDetail iFoodDetail) {
        foodDetailBiz = new FoodDetailBiz();
        this.iFoodDetail = iFoodDetail;
    }

    public void getFoodDetail(int id) {
        if(DoctorApplication.getInstance().checkNetwork()) {
            iFoodDetail.showLoading();
            foodDetailBiz.getFoodDetail(id, new CallBack<FoodDetailBean>() {
                @Override
                public void getSuccess(FoodDetailBean result) {
                    if(result.getYi18() != null) {
                        iFoodDetail.initFoodDetail(result);
                    } else {
                        iFoodDetail.setEmptyView();
                    }
                    iFoodDetail.hideLoading();
                }

                @Override
                public void getFailed(String msg) {
                    ToastUtils.show(ActivityCollections.getInstance().currentActivity(), R.string.loading_failed);
                    iFoodDetail.setFailedView();
                    iFoodDetail.hideLoading();
                }
            });
        }
    }
}
