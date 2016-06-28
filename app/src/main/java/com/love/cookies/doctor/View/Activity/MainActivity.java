package com.love.cookies.doctor.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ToastUtils;

import com.love.cookies.doctor.R;
import com.love.cookies.doctor.View.Wedget.MianMenuItem;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by xiekun on 2015/11/24 0024.
 *
 * 主页Activity
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewInject(R.id.text_title)
    TextView pageTitle;
    @ViewInject(R.id.btn_right)
    ImageView btnRight;
    @ViewInject(R.id.item_food)
    MianMenuItem itemFood;
    @ViewInject(R.id.item_knowledge)
    MianMenuItem itemKnowledge;
    @ViewInject(R.id.item_question)
    MianMenuItem itemQuestion;
    @ViewInject(R.id.item_search)
    MianMenuItem itemSearch;

    private long exitTime;

    @Override
    public void initWidget(Bundle savedInstanceState) {
        pageTitle.setText(R.string.app_name);
        btnRight.setImageResource(R.drawable.com_tit_bt_list);
        btnRight.setOnClickListener(this);
        itemFood.setOnClickListener(this);
        itemKnowledge.setOnClickListener(this);
        itemQuestion.setOnClickListener(this);
        itemSearch.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_right:
                intent = new Intent(MainActivity.this, SettingActivity.class);
                break;
            case R.id.item_food:
                intent = new Intent(MainActivity.this, FoodMainActivity.class);
                break;
            case R.id.item_knowledge:
                intent = new Intent(MainActivity.this, LoreMainActivity.class);
                break;
            case R.id.item_question:
                intent = new Intent(MainActivity.this, AskMainActivity.class);
                break;
            case R.id.item_search:
                intent = new Intent(MainActivity.this, SymptomMainActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) //System.currentTimeMillis()无论何时调用，肯定大于2000
            {
                ToastUtils.show(getApplicationContext(), R.string.exit_tip);
                exitTime = System.currentTimeMillis();
            } else {
                ActivityCollections.getInstance().finishAllActivity();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
