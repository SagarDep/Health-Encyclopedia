package com.love.cookies.health_encyclopedia.View.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Adapter.CommonAdapter;
import com.love_cookies.cookie_library.Adapter.CommonViewHolder;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ProgressUtils;

import com.love.cookies.health_encyclopedia.Config.APIs;
import com.love.cookies.health_encyclopedia.Model.Bean.LoreBean;
import com.love.cookies.health_encyclopedia.Presenter.LoreMainPresenter;
import com.love.cookies.health_encyclopedia.R;
import com.love.cookies.health_encyclopedia.View.Interface.ILoreMain;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2015/11/30 0030.
 *
 * 知识Activity
 */
@ContentView(R.layout.activity_lore_main)
public class LoreMainActivity extends BaseActivity implements ILoreMain {

    @ViewInject(R.id.text_title)
    TextView pageTitle;
    @ViewInject(R.id.btn_left)
    ImageView btnLeft;
    @ViewInject(R.id.btn_right)
    ImageView btnRight;
    @ViewInject(R.id.grid_view)
    GridView gridView;
    @ViewInject(R.id.empty_view)
    LinearLayout emptyView;
    @ViewInject(R.id.failed_view)
    LinearLayout failedView;

    LoreGridViewAdapter loreGridViewAdapter;

    List<LoreBean.Yi18Entity> loreDate = new ArrayList<>();

    LoreMainPresenter loreMainPresenter = new LoreMainPresenter(this);

    @Override
    public void initWidget(Bundle savedInstanceState) {
        pageTitle.setText(R.string.main_knowledge_title);
        btnLeft.setImageResource(R.drawable.com_tit_bt_back);
        btnLeft.setOnClickListener(this);
        btnRight.setImageResource(R.drawable.com_tit_bt_search);
        btnRight.setOnClickListener(this);
        emptyView.setOnClickListener(this);
        failedView.setOnClickListener(this);
        initGridView();
        loreMainPresenter.getLoreDate();
    }

    private void initGridView() {
        loreGridViewAdapter = new LoreGridViewAdapter(this, loreDate);
        gridView.setAdapter(loreGridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ActivityCollections.getInstance().currentActivity(), LoreCategoryActivity.class);
                intent.putExtra("name", loreDate.get(position).getName());
                intent.putExtra("id", loreDate.get(position).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.btn_left:
                ActivityCollections.getInstance().finishActivity();
                break;
            case R.id.btn_right:
                Intent intent = new Intent(this, SearchActivity.class);
                intent.putExtra("api", APIs.APIX_LORE_SEARCH);
                intent.putExtra("key", APIs.APIX_LORE_KEY);
                intent.putExtra("tag", APIs.TAG_LORE);
                startActivity(intent);
                break;
            case R.id.empty_view:
            case R.id.failed_view:
                loreMainPresenter.getLoreDate();
                break;
            default:
                break;
        }
    }

    @Override
    public void initLoreDate(LoreBean loreBean) {
        gridView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        failedView.setVisibility(View.GONE);

        loreDate.addAll(loreBean.getYi18());
        loreGridViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void setEmptyView() {
        gridView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
        failedView.setVisibility(View.GONE);
    }

    @Override
    public void setFailedView() {
        gridView.setVisibility(View.GONE);
        emptyView.setVisibility(View.GONE);
        failedView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoading() {
        ProgressUtils.showProgress(this);
    }

    @Override
    public void hideLoading() {
        ProgressUtils.hideProgress();
    }

    class LoreGridViewAdapter extends CommonAdapter<LoreBean.Yi18Entity> {

        public LoreGridViewAdapter(Context context, List<LoreBean.Yi18Entity> datas) {
            super(context, R.layout.item_lore_list, datas);
        }

        @Override
        public void convert(CommonViewHolder viewHolder, LoreBean.Yi18Entity lore) {
            viewHolder.setText(R.id.lore_name, lore.getName());
        }
    }

}
