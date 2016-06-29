package com.love.cookies.health_encyclopedia.Presenter;

import com.love.cookies.health_encyclopedia.App.DoctorApplication;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ToastUtils;

import com.love.cookies.health_encyclopedia.Model.Bean.FunctionBean;
import com.love.cookies.health_encyclopedia.Model.Biz.FunctionMainBiz;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.CallBack;
import com.love.cookies.health_encyclopedia.R;
import com.love.cookies.health_encyclopedia.View.Interface.IFunctionMain;

/**
 * Created by xiekun on 2015/11/26 0026.
 *
 * 功能Presenter
 */
public class FunctionMainPresenter {

    private FunctionMainBiz functionMainBiz;
    private IFunctionMain iFunctionMain;

    public FunctionMainPresenter(IFunctionMain iFunctionMain) {
        functionMainBiz = new FunctionMainBiz();
        this.iFunctionMain = iFunctionMain;
    }

    public void getFunctionDate() {
        if(DoctorApplication.getInstance().checkNetwork()) {
            iFunctionMain.showLoading();
            functionMainBiz.getFunctionDate(new CallBack<FunctionBean>() {
                @Override
                public void getSuccess(FunctionBean result) {
                    if(result.getYi18().size() > 0) {
                        iFunctionMain.initFunctionDate(result);
                    } else {
                        iFunctionMain.setEmptyView();
                    }
                    iFunctionMain.hideLoading();
                }

                @Override
                public void getFailed(String msg) {
                    ToastUtils.show(ActivityCollections.getInstance().currentActivity(), R.string.loading_failed);
                    iFunctionMain.setFailedView();
                    iFunctionMain.hideLoading();
                }
            });
        }
    }

}
