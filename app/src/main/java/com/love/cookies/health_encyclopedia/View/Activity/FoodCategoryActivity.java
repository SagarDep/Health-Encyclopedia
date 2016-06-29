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
import com.love_cookies.cookie_library.Widget.LoadAndRefreshView;

import com.love.cookies.health_encyclopedia.Config.APIs;
import com.love.cookies.health_encyclopedia.Model.Bean.FoodBean;
import com.love.cookies.health_encyclopedia.Presenter.FoodCategoryPresenter;
import com.love.cookies.health_encyclopedia.R;
import com.love.cookies.health_encyclopedia.View.Interface.IFoodCategory;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2015/11/27 0027.
 *
 * 食品条目Activity
 */
@ContentView(R.layout.activity_food_category)
public class FoodCategoryActivity extends BaseActivity implements IFoodCategory, LoadAndRefreshView.OnHeaderRefreshListener, LoadAndRefreshView.OnFooterRefreshListener {

    @ViewInject(R.id.text_title)
    TextView pageTitle;
    @ViewInject(R.id.btn_left)
    ImageView btnLeft;
    @ViewInject(R.id.load_and_refresh_view)
    LoadAndRefreshView loadAndRefreshView;
    @ViewInject(R.id.grid_view)
    GridView gridView;
    @ViewInject(R.id.empty_view)
    LinearLayout emptyView;
    @ViewInject(R.id.failed_view)
    LinearLayout failedView;

    FoodGridViewAdapter foodGridViewAdapter;

    List<FoodBean.Yi18Entity> foodDate = new ArrayList<>();

    FoodCategoryPresenter foodCategoryPresenter = new FoodCategoryPresenter(this);

    private int page = 1;
    private String api = "";
    private int id = -1;

    private int STATUS = APIs.REFRESH;

    @Override
    public void initWidget(Bundle savedInstanceState) {
        pageTitle.setText(getIntent().getStringExtra("name"));
        btnLeft.setImageResource(R.drawable.com_tit_bt_back);
        btnLeft.setOnClickListener(this);
        loadAndRefreshView.setOnHeaderRefreshListener(this);
        loadAndRefreshView.setOnFooterRefreshListener(this);
        emptyView.setOnClickListener(this);
        failedView.setOnClickListener(this);
        initGridView();
        STATUS = APIs.REFRESH;
        api = getIntent().getStringExtra("api");
        id = getIntent().getIntExtra("id", -1);
        foodCategoryPresenter.getFoodCategoryDate(page, api, id);
    }

    private void initGridView() {
        foodGridViewAdapter = new FoodGridViewAdapter(this, foodDate);
        gridView.setAdapter(foodGridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ActivityCollections.getInstance().currentActivity(), FoodDetailActivity.class);
                intent.putExtra("name", foodDate.get(position).getName());
                intent.putExtra("id", foodDate.get(position).getId());
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
            case R.id.empty_view:
            case R.id.failed_view:
                foodCategoryPresenter.getFoodCategoryDate(page, api, id);
                break;
            default:
                break;
        }
    }

    @Override
    public void initFoodDate(FoodBean foodBean) {
        loadAndRefreshView.setVisibility(View.VISIBLE);
        failedView.setVisibility(View.GONE);
        emptyView.setVisibility(View.GONE);

        if(STATUS == APIs.REFRESH) {
            foodDate.clear();
            foodDate.addAll(foodBean.getYi18());
        } else if(STATUS == APIs.LOADMORE) {
            foodDate.addAll(foodBean.getYi18());
        }
        foodGridViewAdapter.notifyDataSetChanged();
        loadAndRefreshView.setResultSize(foodBean.getYi18().size());
        loadAndRefreshView.onHeaderRefreshComplete();
        loadAndRefreshView.onFooterRefreshComplete();
    }

    @Override
    public void setEmptyView() {
        loadAndRefreshView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
        failedView.setVisibility(View.GONE);
    }

    @Override
    public void setFailedView() {
        loadAndRefreshView.setVisibility(View.GONE);
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

    @Override
    public void onHeaderRefresh(LoadAndRefreshView view) {
        page = 1;
        STATUS = APIs.REFRESH;
        foodCategoryPresenter.getFoodCategoryDate(page, api, id);
    }

    @Override
    public void onFooterRefresh(LoadAndRefreshView view) {
        STATUS = APIs.LOADMORE;
        foodCategoryPresenter.getFoodCategoryDate(++page, api, id);
    }

    class FoodGridViewAdapter extends CommonAdapter<FoodBean.Yi18Entity> {

        public FoodGridViewAdapter(Context context, List<FoodBean.Yi18Entity> datas) {
            super(context, R.layout.item_food_list, datas);
        }

        @Override
        public void convert(CommonViewHolder viewHolder, FoodBean.Yi18Entity food) {
            viewHolder.setImage(R.id.food_img, food.getImg());
            viewHolder.setText(R.id.food_name, food.getName());
            viewHolder.setText(R.id.food_menu, food.getMenu());
            viewHolder.setText(R.id.food_bar, food.getBar());
        }
    }
}
