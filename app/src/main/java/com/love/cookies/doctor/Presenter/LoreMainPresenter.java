package com.love.cookies.doctor.Presenter;

import com.love.cookies.doctor.App.DoctorApplication;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ToastUtils;

import com.love.cookies.doctor.Model.Bean.LoreBean;
import com.love.cookies.doctor.Model.Biz.Interface.CallBack;
import com.love.cookies.doctor.Model.Biz.LoreMainBiz;
import com.love.cookies.doctor.R;
import com.love.cookies.doctor.View.Interface.ILoreMain;

/**
 * Created by xiekun on 2015/11/30 0030.
 *
 * 知识Presenter
 */
public class LoreMainPresenter {

    private LoreMainBiz loreMainBiz;
    private ILoreMain iLoreMain;

    public LoreMainPresenter(ILoreMain iLoreMain) {
        loreMainBiz = new LoreMainBiz();
        this.iLoreMain = iLoreMain;
    }

    public void getLoreDate() {
        if(DoctorApplication.getInstance().checkNetwork()) {
            iLoreMain.showLoading();
            loreMainBiz.getLoreDate(new CallBack<LoreBean>() {
                @Override
                public void getSuccess(LoreBean result) {
                    if(result.getYi18().size() > 0) {
                        iLoreMain.initLoreDate(result);
                    } else {
                        iLoreMain.setEmptyView();
                    }
                    iLoreMain.hideLoading();
                }

                @Override
                public void getFailed(String msg) {
                    ToastUtils.show(ActivityCollections.getInstance().currentActivity(), R.string.loading_failed);
                    iLoreMain.setFailedView();
                    iLoreMain.hideLoading();
                }
            });
        }
    }

}
