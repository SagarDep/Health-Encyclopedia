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

import com.love.cookies.doctor.Model.Bean.FoodDetailBean;
import com.love.cookies.doctor.Presenter.FoodDetailPresenter;
import com.love.cookies.doctor.R;
import com.love.cookies.doctor.View.Interface.IFoodDetail;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by xiekun on 2015/11/26 0026.
 *
 * 食品详情Activity
 */
@ContentView(R.layout.activity_food_detail)
public class FoodDetailActivity extends BaseActivity implements IFoodDetail {

    @ViewInject(R.id.text_title)
    TextView pageTitle;
    @ViewInject(R.id.btn_left)
    ImageView btnLeft;
    @ViewInject(R.id.scroll_view)
    ScrollView scrollView;
    @ViewInject(R.id.food_img)
    ImageView foodImg;
    @ViewInject(R.id.food_summary)
    TextView foodSummary;
    @ViewInject(R.id.food_menu)
    TextView foodMenu;
    @ViewInject(R.id.food_bar)
    TextView foodBar;
    @ViewInject(R.id.food_detail)
    TextView foodDetail;
    @ViewInject(R.id.empty_view)
    LinearLayout emptyView;
    @ViewInject(R.id.failed_view)
    LinearLayout failedView;

    FoodDetailPresenter foodDetailPresenter = new FoodDetailPresenter(this);

    @Override
    public void initWidget(Bundle savedInstanceState) {
        pageTitle.setText(Html.fromHtml(getIntent().getStringExtra("name")));
        btnLeft.setImageResource(R.drawable.com_tit_bt_back);
        btnLeft.setOnClickListener(this);
        emptyView.setOnClickListener(this);
        failedView.setOnClickListener(this);
        foodDetailPresenter.getFoodDetail(getIntent().getIntExtra("id", -1));
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.btn_left:
                ActivityCollections.getInstance().finishActivity();
                break;
            case R.id.empty_view:
            case R.id.failed_view:
                foodDetailPresenter.getFoodDetail(getIntent().getIntExtra("id", -1));
                break;
            default:
                break;
        }
    }

    @Override
    public void initFoodDetail(FoodDetailBean foodDetailBean) {
        scrollView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        failedView.setVisibility(View.GONE);

        String imageUrl = foodDetailBean.getYi18().getImg();
        if (imageUrl.contains("default") || imageUrl.contains("null")) {
            foodImg.setImageResource(R.drawable.default_img);
        } else {
            ImageOptions imageOptions = new ImageOptions.Builder()
                    .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                    .setLoadingDrawableId(R.drawable.default_img)
                    .setPlaceholderScaleType(ImageView.ScaleType.CENTER_CROP)
                    .setFailureDrawableId(R.drawable.default_img)
                    .build();
            x.image().bind(foodImg, imageUrl, imageOptions);
        }
        foodSummary.setText(Html.fromHtml(foodDetailBean.getYi18().getSummary()));
        foodMenu.setText(foodDetailBean.getYi18().getMenu());
        foodBar.setText(foodDetailBean.getYi18().getBar());
        foodDetail.setText(Html.fromHtml(foodDetailBean.getYi18().getDetailText()));
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
