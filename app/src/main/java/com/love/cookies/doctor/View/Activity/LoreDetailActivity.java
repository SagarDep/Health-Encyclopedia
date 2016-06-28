package com.love.cookies.doctor.View.Activity;

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

import com.love.cookies.doctor.Model.Bean.LoreDetailBean;
import com.love.cookies.doctor.Presenter.LoreDetailPresenter;
import com.love.cookies.doctor.R;
import com.love.cookies.doctor.View.Interface.ILoreDetail;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by xiekun on 2015/11/30 0030.
 *
 * 知识详情Activity
 */
@ContentView(R.layout.activity_lore_detail)
public class LoreDetailActivity extends BaseActivity implements ILoreDetail {

    @ViewInject(R.id.text_title)
    TextView pageTitle;
    @ViewInject(R.id.btn_left)
    ImageView btnLeft;
    @ViewInject(R.id.scroll_view)
    ScrollView scrollView;
    @ViewInject(R.id.lore_title)
    TextView loreTitle;
    @ViewInject(R.id.lore_class_name)
    TextView loreClassName;
    @ViewInject(R.id.lore_author)
    TextView loreAuthor;
    @ViewInject(R.id.lore_time)
    TextView loreTime;
    @ViewInject(R.id.lore_message)
    TextView loreMessage;
    @ViewInject(R.id.empty_view)
    LinearLayout emptyView;
    @ViewInject(R.id.failed_view)
    LinearLayout failedView;

    LoreDetailPresenter loreDetailPresenter = new LoreDetailPresenter(this);

    @Override
    public void initWidget(Bundle savedInstanceState) {
        pageTitle.setText(Html.fromHtml(getIntent().getStringExtra("name")));
        btnLeft.setImageResource(R.drawable.com_tit_bt_back);
        btnLeft.setOnClickListener(this);
        emptyView.setOnClickListener(this);
        failedView.setOnClickListener(this);
        loreDetailPresenter.getLoreDetail(getIntent().getIntExtra("id", -1));
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.btn_left:
                ActivityCollections.getInstance().finishActivity();
                break;
            case R.id.empty_view:
            case R.id.failed_view:
                loreDetailPresenter.getLoreDetail(getIntent().getIntExtra("id", -1));
                break;
            default:
                break;
        }
    }

    @Override
    public void initLoreDetail(LoreDetailBean loreDetailBean) {
        scrollView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        failedView.setVisibility(View.GONE);

        loreTitle.setText(loreDetailBean.getYi18().getTitle());
        loreClassName.setText(loreDetailBean.getYi18().getClassName());
        loreAuthor.setText(loreDetailBean.getYi18().getAuthor());
        loreTime.setText(loreDetailBean.getYi18().getTime());
        loreMessage.setText(Html.fromHtml(loreDetailBean.getYi18().getMessage()));
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
