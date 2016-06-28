package com.love.cookies.doctor.Presenter;

import com.love.cookies.doctor.App.DoctorApplication;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ToastUtils;

import com.love.cookies.doctor.Model.Bean.AskBean;
import com.love.cookies.doctor.Model.Biz.AskMainBiz;
import com.love.cookies.doctor.Model.Biz.Interface.CallBack;
import com.love.cookies.doctor.R;
import com.love.cookies.doctor.View.Interface.IAskMain;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 健康一问Presenter
 */
public class AskMainPresenter {

    private AskMainBiz askMainBiz;
    private IAskMain iAskMain;

    public AskMainPresenter(IAskMain iAskMain) {
        askMainBiz = new AskMainBiz();
        this.iAskMain = iAskMain;
    }

    public void getAskDate() {
        if(DoctorApplication.getInstance().checkNetwork()) {
            iAskMain.showLoading();
            askMainBiz.getAskDate(new CallBack<AskBean>() {
                @Override
                public void getSuccess(AskBean result) {
                    if(result.getYi18().size() > 0) {
                        iAskMain.initAskDate(result);
                    } else {
                        iAskMain.setEmptyView();
                    }
                    iAskMain.hideLoading();
                }

                @Override
                public void getFailed(String msg) {
                    ToastUtils.show(ActivityCollections.getInstance().currentActivity(), R.string.loading_failed);
                    iAskMain.setFailedView();
                    iAskMain.hideLoading();
                }
            });
        }
    }

}
