package com.love.cookies.health_encyclopedia.View.Activity;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ProgressUtils;

import com.love.cookies.health_encyclopedia.Model.Bean.SymptomDetailBean;
import com.love.cookies.health_encyclopedia.Presenter.SymptomDetailPresenter;
import com.love.cookies.health_encyclopedia.R;
import com.love.cookies.health_encyclopedia.View.Interface.ISymptomDetail;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 症状详情Activity
 */
@ContentView(R.layout.activity_symptom_detail)
public class SymptomDetailActivity extends BaseActivity implements ISymptomDetail {

    @ViewInject(R.id.text_title)
    TextView pageTitle;
    @ViewInject(R.id.btn_left)
    ImageView btnLeft;
    @ViewInject(R.id.scroll_view)
    ScrollView scrollView;
    @ViewInject(R.id.symptom_img)
    ImageView symptomImg;
    @ViewInject(R.id.symptom_title)
    TextView symptomTitle;
    @ViewInject(R.id.symptom_summary)
    TextView symptomSummary;
    @ViewInject(R.id.symptom_place)
    TextView symptomPlace;
    @ViewInject(R.id.symptom_disease)
    TextView symptomDisease;
    @ViewInject(R.id.symptom_check)
    TextView symptomCheck;
    @ViewInject(R.id.symptom_cause)
    TextView symptomCause;
    @ViewInject(R.id.symptom_drug)
    TextView symptomDrug;
    @ViewInject(R.id.symptom_detail)
    TextView symptomDetail;
    @ViewInject(R.id.empty_view)
    LinearLayout emptyView;
    @ViewInject(R.id.failed_view)
    LinearLayout failedView;

    SymptomDetailPresenter symptomDetailPresenter = new SymptomDetailPresenter(this);

    @Override
    public void initWidget(Bundle savedInstanceState) {
        pageTitle.setText(Html.fromHtml(getIntent().getStringExtra("name")));
        btnLeft.setImageResource(R.drawable.com_tit_bt_back);
        btnLeft.setOnClickListener(this);
        emptyView.setOnClickListener(this);
        failedView.setOnClickListener(this);
        symptomDetailPresenter.getSymptomDetail(getIntent().getIntExtra("id", -1));
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.btn_left:
                ActivityCollections.getInstance().finishActivity();
                break;
            case R.id.empty_view:
            case R.id.failed_view:
                symptomDetailPresenter.getSymptomDetail(getIntent().getIntExtra("id", -1));
                break;
            default:
                break;
        }
    }

    @Override
    public void initSymptomDetail(SymptomDetailBean symptomDetailBean) {
        scrollView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        failedView.setVisibility(View.GONE);

        String imageUrl = symptomDetailBean.getYi18().getImg();
        if (imageUrl.contains("default") || imageUrl.contains("null")) {
            symptomImg.setImageResource(R.drawable.default_img);
        } else {
            ImageOptions imageOptions = new ImageOptions.Builder()
                    .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                    .setLoadingDrawableId(R.drawable.default_img)
                    .setPlaceholderScaleType(ImageView.ScaleType.CENTER_CROP)
                    .setFailureDrawableId(R.drawable.default_img)
                    .build();
            x.image().bind(symptomImg, imageUrl, imageOptions);
        }
        symptomTitle.setText(symptomDetailBean.getYi18().getName());
        symptomSummary.setText(Html.fromHtml(symptomDetailBean.getYi18().getSummary()));
        symptomPlace.setText(symptomDetailBean.getYi18().getPlace());
        symptomDisease.setText(symptomDetailBean.getYi18().getDisease());
        String check = symptomDetailBean.getYi18().getCheck();
        if(TextUtils.isEmpty(check)) {
            symptomCheck.setVisibility(View.GONE);
        } else {
            symptomCheck.setVisibility(View.VISIBLE);
            symptomCheck.setText(symptomDetailBean.getYi18().getCheck());
        }
        symptomCause.setText(Html.fromHtml(symptomDetailBean.getYi18().getCauseText()));
        symptomDrug.setText(symptomDetailBean.getYi18().getDrug());
        symptomDetail.setText(Html.fromHtml(symptomDetailBean.getYi18().getDetailText()));
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
