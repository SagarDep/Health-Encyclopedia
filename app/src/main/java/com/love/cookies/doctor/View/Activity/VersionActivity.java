package com.love.cookies.doctor.View.Activity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Adapter.CommonAdapter;
import com.love_cookies.cookie_library.Adapter.CommonViewHolder;
import com.love_cookies.cookie_library.Application.ActivityCollections;

import com.love.cookies.doctor.Model.Bean.ChangeLogBean;
import com.love.cookies.doctor.Presenter.VersionPresenter;
import com.love.cookies.doctor.R;
import com.love.cookies.doctor.View.Interface.IVersion;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2015/12/3 0003.
 *
 * 版本信息Activity
 */
@ContentView(R.layout.activity_version)
public class VersionActivity extends BaseActivity implements IVersion {

    @ViewInject(R.id.text_title)
    TextView pageTitle;
    @ViewInject(R.id.btn_left)
    ImageView btnLeft;
    @ViewInject(R.id.version_text)
    TextView versionText;
    @ViewInject(R.id.list_view)
    ListView listView;

    ChangeLogListViewAdapter changeLogListViewAdapter;

    List<ChangeLogBean.ChangeLogEntity> changeLogDate = new ArrayList<>();

    VersionPresenter versionPresenter = new VersionPresenter(this);

    @Override
    public void initWidget(Bundle savedInstanceState) {
        pageTitle.setText(R.string.setting_version);
        btnLeft.setImageResource(R.drawable.com_tit_bt_back);
        btnLeft.setOnClickListener(this);
        versionText.setText(getAppVersion());
        initListView();
        versionPresenter.getChangeLog(this);
    }

    private void initListView() {
        changeLogListViewAdapter = new ChangeLogListViewAdapter(this, changeLogDate);
        listView.setAdapter(changeLogListViewAdapter);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.btn_left:
                ActivityCollections.getInstance().finishActivity();
                break;
            default:
                break;
        }
    }

    @Override
    public void initChangeLog(ChangeLogBean changeLogBean) {
        changeLogDate.addAll(changeLogBean.getChange_log());
        changeLogListViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailed() {

    }

    private String getAppVersion() {
        PackageManager manager = this.getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(this.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return " V " + info.versionName;
    }

    class ChangeLogListViewAdapter extends CommonAdapter<ChangeLogBean.ChangeLogEntity> {
        public ChangeLogListViewAdapter(Context context, List<ChangeLogBean.ChangeLogEntity> datas) {
            super(context, R.layout.item_change_log_list, datas);
        }

        @Override
        public void convert(CommonViewHolder viewHolder, ChangeLogBean.ChangeLogEntity changeLog) {
            viewHolder.setText(R.id.version, changeLog.getVersion());
            viewHolder.setText(R.id.date, changeLog.getDate());
            viewHolder.setText(R.id.description, changeLog.getDescription());
        }
    }

}
