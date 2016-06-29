package com.love.cookies.health_encyclopedia.View.Activity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ProgressUtils;

import com.love.cookies.health_encyclopedia.Model.Bean.AskDetailBean;
import com.love.cookies.health_encyclopedia.Presenter.AskDetailPresenter;
import com.love.cookies.health_encyclopedia.R;
import com.love.cookies.health_encyclopedia.View.Interface.IAskDetail;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by xiekun on 2015/12/1 0001
 *
 * 健康一问详情Activity
 */
@ContentView(R.layout.activity_ask_detail)
public class AskDetailActivity extends BaseActivity implements IAskDetail {

    @ViewInject(R.id.text_title)
    TextView pageTitle;
    @ViewInject(R.id.btn_left)
    ImageView btnLeft;
    @ViewInject(R.id.scroll_view)
    ScrollView scrollView;
    @ViewInject(R.id.ask_title)
    TextView askTitle;
    @ViewInject(R.id.ask_class_name)
    TextView askClassName;
    @ViewInject(R.id.ask_answer)
    TextView askAnswer;
    @ViewInject(R.id.empty_view)
    LinearLayout emptyView;
    @ViewInject(R.id.failed_view)
    LinearLayout failedView;

    AskDetailPresenter askDetailPresenter = new AskDetailPresenter(this);

    @Override
    public void initWidget(Bundle savedInstanceState) {
        pageTitle.setText(Html.fromHtml(getIntent().getStringExtra("name")));
        btnLeft.setImageResource(R.drawable.com_tit_bt_back);
        btnLeft.setOnClickListener(this);
        emptyView.setOnClickListener(this);
        failedView.setOnClickListener(this);
        askDetailPresenter.getAskDetail(getIntent().getIntExtra("id", -1));
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.btn_left:
                ActivityCollections.getInstance().finishActivity();
                break;
            case R.id.empty_view:
            case R.id.failed_view:
                askDetailPresenter.getAskDetail(getIntent().getIntExtra("id", -1));
                break;
            default:
                break;
        }
    }

    @Override
    public void initAskDetail(AskDetailBean askDetailBean) {
        scrollView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        failedView.setVisibility(View.GONE);

        askTitle.setText(askDetailBean.getYi18().getTitle());
        askClassName.setText(askDetailBean.getYi18().getClassname());
        askAnswer.setText(Html.fromHtml(askDetailBean.getYi18().getAnswer().get(0).getMessage()));
    }

    @Override
    public void setEmptyView() {
        scrollView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
        failedView.setVisibility(View.GONE);
    }

    @Override
    public void setFailedView() {
        scrollView.setVisibility(View.GONE);
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

}
