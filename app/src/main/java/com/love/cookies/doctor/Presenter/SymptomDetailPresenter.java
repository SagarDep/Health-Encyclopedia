package com.love.cookies.doctor.Presenter;

import com.love.cookies.doctor.App.DoctorApplication;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ToastUtils;

import com.love.cookies.doctor.Model.Bean.SymptomDetailBean;
import com.love.cookies.doctor.Model.Biz.Interface.CallBack;
import com.love.cookies.doctor.Model.Biz.SymptomDetailBiz;
import com.love.cookies.doctor.R;
import com.love.cookies.doctor.View.Interface.ISymptomDetail;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 症状详情Presenter
 */
public class SymptomDetailPresenter {

    private SymptomDetailBiz symptomDetailBiz;
    private ISymptomDetail iSymptomDetail;

    public SymptomDetailPresenter(ISymptomDetail iSymptomDetail) {
        symptomDetailBiz = new SymptomDetailBiz();
        this.iSymptomDetail = iSymptomDetail;
    }

    public void getSymptomDetail(final int id) {
        if(DoctorApplication.getInstance().checkNetwork()) {
            iSymptomDetail.showLoading();
            symptomDetailBiz.getSymptomDetail(id, new CallBack<SymptomDetailBean>() {
                @Override
                public void getSuccess(SymptomDetailBean result) {
                    if(result.getYi18() != null) {
                        iSymptomDetail.initSymptomDetail(result);
                    } else {
                        iSymptomDetail.setEmptyView();
                    }
                    iSymptomDetail.hideLoading();
                }

                @Override
                public void getFailed(String msg) {
                    ToastUtils.show(ActivityCollections.getInstance().currentActivity(), R.string.loading_failed);
                    iSymptomDetail.setFailedView();
                    iSymptomDetail.hideLoading();
                }
            });
        }
    }

}
