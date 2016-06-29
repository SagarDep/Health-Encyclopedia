package com.love.cookies.health_encyclopedia.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Application.ActivityCollections;

import com.love.cookies.health_encyclopedia.R;
import com.love.cookies.health_encyclopedia.View.Wedget.SettingItem;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by xiekun on 2015/11/25 0025.
 *
 * 设置Activity
 */
@ContentView(R.layout.activity_setting)
public class SettingActivity extends BaseActivity {

    @ViewInject(R.id.text_title)
    TextView pageTitle;
    @ViewInject(R.id.btn_left)
    ImageView btnLeft;
    @ViewInject(R.id.version)
    SettingItem version;
    @ViewInject(R.id.about)
    SettingItem about;
    @ViewInject(R.id.support)
    SettingItem support;

    @Override
    public void initWidget(Bundle savedInstanceState) {
        pageTitle.setText(R.string.setting_title);
        btnLeft.setImageResource(R.drawable.com_tit_bt_back);
        btnLeft.setOnClickListener(this);
        version.setOnClickListener(this);
        about.setOnClickListener(this);
        support.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_left:
                ActivityCollections.getInstance().finishActivity();
                break;
            case R.id.version:
                intent = new Intent(ActivityCollections.getInstance().currentActivity(), VersionActivity.class);
                startActivity(intent);
                break;
            case R.id.about:
                intent = new Intent(ActivityCollections.getInstance().currentActivity(), AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.support:
                intent = new Intent(ActivityCollections.getInstance().currentActivity(), SupportActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
