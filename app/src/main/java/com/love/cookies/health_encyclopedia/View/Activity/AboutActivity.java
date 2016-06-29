package com.love.cookies.health_encyclopedia.View.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Application.ActivityCollections;

import com.love.cookies.health_encyclopedia.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by xiekun on 2015/12/3 0003.
 *
 * 关于软件Activity
 */
@ContentView(R.layout.activity_about)
public class AboutActivity extends BaseActivity {

    @ViewInject(R.id.text_title)
    TextView pageTitle;
    @ViewInject(R.id.btn_left)
    ImageView btnLeft;

    @Override
    public void initWidget(Bundle savedInstanceState) {
        pageTitle.setText(R.string.setting_about);
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
