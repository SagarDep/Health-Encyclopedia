package com.love.cookies.doctor.View.Activity;

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

import com.love.cookies.doctor.Config.APIs;
import com.love.cookies.doctor.Model.Bean.AskBean;
import com.love.cookies.doctor.Presenter.AskMainPresenter;
import com.love.cookies.doctor.R;
import com.love.cookies.doctor.View.Interface.IAskMain;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 健康一问Activity
 */
@ContentView(R.layout.activity_ask_main)
public class AskMainActivity extends BaseActivity implements IAskMain {

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

    AskGridViewAdapter askGridViewAdapter;

    List<AskBean.Yi18Entity> askDate = new ArrayList<>();

    AskMainPresenter askMainPresenter = new AskMainPresenter(this);

    @Override
    public void initWidget(Bundle savedInstanceState) {
        pageTitle.setText(R.string.main_question_title);
        btnLeft.setImageResource(R.drawable.com_tit_bt_back);
        btnLeft.setOnClickListener(this);
        btnRight.setImageResource(R.drawable.com_tit_bt_search);
        btnRight.setOnClickListener(this);
        emptyView.setOnClickListener(this);
        failedView.setOnClickListener(this);
        initGridView();
        askMainPresenter.getAskDate();
    }

    private void initGridView() {
        askGridViewAdapter = new AskGridViewAdapter(this, askDate);
        gridView.setAdapter(askGridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ActivityCollections.getInstance().currentActivity(), AskCategoryActivity.class);
                intent.putExtra("name", askDate.get(position).getName());
                intent.putExtra("id", askDate.get(position).getId());
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
                intent.putExtra("api", APIs.APIX_ASK_SEARCH);
                intent.putExtra("key", APIs.APIX_ASK_KEY);
                intent.putExtra("tag", APIs.TAG_ASK);
                startActivity(intent);
                break;
            case R.id.empty_view:
            case R.id.failed_view:
                askMainPresenter.getAskDate();
                break;
            default:
                break;
        }
    }


    @Override
    public void initAskDate(AskBean askBean) {
        gridView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        failedView.setVisibility(View.GONE);

        askDate.addAll(askBean.getYi18());
        askGridViewAdapter.notifyDataSetChanged();
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

    class AskGridViewAdapter extends CommonAdapter<AskBean.Yi18Entity> {

        public AskGridViewAdapter(Context context, List<AskBean.Yi18Entity> datas) {
            super(context, R.layout.item_ask_list, datas);
        }

        @Override
        public void convert(CommonViewHolder viewHolder, AskBean.Yi18Entity ask) {
            viewHolder.setText(R.id.ask_name, ask.getName());
        }
    }

}
