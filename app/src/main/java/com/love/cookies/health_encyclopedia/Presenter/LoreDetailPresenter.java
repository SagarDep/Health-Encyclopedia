package com.love.cookies.health_encyclopedia.Presenter;

import com.love.cookies.health_encyclopedia.App.HEApplication;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ToastUtils;

import com.love.cookies.health_encyclopedia.Model.Bean.LoreDetailBean;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.CallBack;
import com.love.cookies.health_encyclopedia.Model.Biz.LoreDetailBiz;
import com.love.cookies.health_encyclopedia.R;
import com.love.cookies.health_encyclopedia.View.Interface.ILoreDetail;

/**
 * Created by xiekun on 2015/11/30 0030.
 *
 * 知识详情Presenter
 */
public class LoreDetailPresenter {

    private LoreDetailBiz loreDetailBiz;
    private ILoreDetail iLoreDetail;

    public LoreDetailPresenter(ILoreDetail iLoreDetail) {
        loreDetailBiz = new LoreDetailBiz();
        this.iLoreDetail = iLoreDetail;
    }

    public void getLoreDetail(int id) {
        if(HEApplication.getInstance().checkNetwork()) {
            iLoreDetail.showLoading();
            loreDetailBiz.getLoreDetail(id, new CallBack<LoreDetailBean>() {
                @Override
                public void getSuccess(LoreDetailBean result) {
                    if(result.getYi18() != null) {
                        iLoreDetail.initLoreDetail(result);
                    } else {
                        iLoreDetail.setEmptyView();
                    }
                    iLoreDetail.hideLoading();
                }

                @Override
                public void getFailed(String msg) {
                    ToastUtils.show(ActivityCollections.getInstance().currentActivity(), R.string.loading_failed);
                    iLoreDetail.setFailedView();
                    iLoreDetail.hideLoading();
                }
            });
        }
    }

}
