package com.love.cookies.doctor.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.love_cookies.cookie_library.Activity.BaseFragmentActivity;

import com.love.cookies.doctor.Config.APIs;
import com.love.cookies.doctor.R;
import com.love.cookies.doctor.View.Fragment.EffectMainFragment;
import com.love.cookies.doctor.View.Fragment.FoodMainFragment;
import com.love.cookies.doctor.View.Fragment.FunctionMainFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2015/11/25 0025.
 *
 * 食品Activity
 */
@ContentView(R.layout.activity_food_main)
public class FoodMainActivity extends BaseFragmentActivity {

    @ViewInject(R.id.text_title)
    TextView pageTitle;
    @ViewInject(R.id.btn_left)
    ImageView btnLeft;
    @ViewInject(R.id.btn_right)
    ImageView btnRight;
    @ViewInject(R.id.tabs)
    PagerSlidingTabStrip tabStrip;
    @ViewInject(R.id.view_pager)
    ViewPager viewPager;

    private List<Fragment> fragmentList;

    @Override
    public void initWidget(Bundle savedInstanceState) {
        pageTitle.setText(R.string.main_food_title);
        btnLeft.setImageResource(R.drawable.com_tit_bt_back);
        btnLeft.setOnClickListener(this);
        btnRight.setImageResource(R.drawable.com_tit_bt_search);
        btnRight.setOnClickListener(this);
        initPager();
    }

    private void initPager() {
        fragmentList = new ArrayList<Fragment>();
        FoodMainFragment foodListFragment = new FoodMainFragment();
        EffectMainFragment effectMainFragment = new EffectMainFragment();
        FunctionMainFragment functionMainFragment = new FunctionMainFragment();
        fragmentList.add(foodListFragment);
        fragmentList.add(effectMainFragment);
        fragmentList.add(functionMainFragment);
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        tabStrip.setViewPager(viewPager);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.btn_left:
                finish();
                break;
            case R.id.btn_right:
                Intent intent = new Intent(this, SearchActivity.class);
                intent.putExtra("api", APIs.APIX_FOOD_SEARCH);
                intent.putExtra("key", APIs.APIX_FOOD_KEY);
                intent.putExtra("tag", APIs.TAG_FOOD);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        List<Fragment> list;

        private final String[] TITLES = getResources().getStringArray(R.array.food_main_tab);

        public MyPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

    }

}
