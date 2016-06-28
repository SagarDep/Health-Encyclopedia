package com.love.cookies.doctor.Presenter;

import com.love.cookies.doctor.App.DoctorApplication;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ToastUtils;

import com.love.cookies.doctor.Model.Bean.SymptomBean;
import com.love.cookies.doctor.Model.Biz.Interface.CallBack;
import com.love.cookies.doctor.Model.Biz.SymptomMainBiz;
import com.love.cookies.doctor.R;
import com.love.cookies.doctor.View.Interface.ISymptomMain;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 症状Presenter
 */
public class SymptomMainPresenter {

    private SymptomMainBiz symptomMainBiz;
    private ISymptomMain iSymptomMain;

    public SymptomMainPresenter(ISymptomMain iSymptomMain) {
        symptomMainBiz = new SymptomMainBiz();
        this.iSymptomMain = iSymptomMain;
    }

    public void getSymptomDate() {
        if(DoctorApplication.getInstance().checkNetwork()) {
            iSymptomMain.showLoading();
            symptomMainBiz.getSymptomDate(new CallBack<SymptomBean>() {
                @Override
                public void getSuccess(SymptomBean result) {
                    if(result.getYi18().size() > 0) {
                        iSymptomMain.initSymptomDate(result);
                    } else {
                        iSymptomMain.setEmptyView();
                    }
                    iSymptomMain.hideLoading();
                }

                @Override
                public void getFailed(String msg) {
                    ToastUtils.show(ActivityCollections.getInstance().currentActivity(), R.string.loading_failed);
                    iSymptomMain.setFailedView();
                    iSymptomMain.hideLoading();
                }
            });
        }
    }

}
