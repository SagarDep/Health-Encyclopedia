package com.love.cookies.doctor.View.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Application.ActivityCollections;

import com.love.cookies.doctor.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by xiekun on 2015/11/25 0025.
 *
 * 数据支持Activity
 */
@ContentView(R.layout.activity_support)
public class SupportActivity extends BaseActivity {

    @ViewInject(R.id.text_title)
    TextView pageTitle;
    @ViewInject(R.id.btn_left)
    ImageView btnLeft;

    @Override
    public void initWidget(Bundle savedInstanceState) {
        pageTitle.setText(R.string.setting_support);
        btnLeft.setImageResource(R.drawable.com_tit_bt_back);
        btnLeft.setOnClickListener(this);
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
}
