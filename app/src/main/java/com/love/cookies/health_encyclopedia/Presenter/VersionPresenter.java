package com.love.cookies.health_encyclopedia.Presenter;

import android.content.Context;

import com.love.cookies.health_encyclopedia.Model.Bean.ChangeLogBean;
import com.love.cookies.health_encyclopedia.Model.Biz.ChangeLogBiz;
import com.love.cookies.health_encyclopedia.Model.Biz.Interface.CallBack;
import com.love.cookies.health_encyclopedia.View.Interface.IVersion;

/**
 * Created by xiekun on 2015/12/3 0003.
 *
 * 版本信息Presenter
 */
public class VersionPresenter {

    private ChangeLogBiz changeLogBiz;
    private IVersion iVersion;

    public VersionPresenter(IVersion iVersion) {
        changeLogBiz = new ChangeLogBiz();
        this.iVersion = iVersion;
    }

    public void getChangeLog(Context context) {
        changeLogBiz.getChangeLog(context, new CallBack<ChangeLogBean>() {
            @Override
            public void getSuccess(ChangeLogBean result) {
                iVersion.initChangeLog(result);
            }

            @Override
            public void getFailed(String msg) {
                iVersion.onFailed();
            }
        });
    }

}
