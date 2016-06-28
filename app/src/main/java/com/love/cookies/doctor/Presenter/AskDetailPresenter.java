package com.love.cookies.doctor.Presenter;

import com.love.cookies.doctor.App.DoctorApplication;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ToastUtils;

import com.love.cookies.doctor.Model.Bean.AskDetailBean;
import com.love.cookies.doctor.Model.Biz.AskDetailBiz;
import com.love.cookies.doctor.Model.Biz.Interface.CallBack;
import com.love.cookies.doctor.R;
import com.love.cookies.doctor.View.Interface.IAskDetail;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 健康一问详情Presenter
 */
public class AskDetailPresenter {

    private AskDetailBiz askDetailBiz;
    private IAskDetail iAskDetail;

    public AskDetailPresenter(IAskDetail iAskDetail) {
        askDetailBiz = new AskDetailBiz();
        this.iAskDetail = iAskDetail;
    }

    public void getAskDetail(int id) {
        if(DoctorApplication.getInstance().checkNetwork()) {
            iAskDetail.showLoading();
            askDetailBiz.getAskDetail(id, new CallBack<AskDetailBean>() {
                @Override
                public void getSuccess(AskDetailBean result) {
                    if(result.getYi18() != null) {
                        iAskDetail.initAskDetail(result);
                    } else {
                        iAskDetail.setEmptyView();
                    }
                    iAskDetail.hideLoading();
                }

                @Override
                public void getFailed(String msg) {
                    ToastUtils.show(ActivityCollections.getInstance().currentActivity(), R.string.loading_failed);
                    iAskDetail.setFailedView();
                    iAskDetail.hideLoading();
                }
            });
        }
    }

}
