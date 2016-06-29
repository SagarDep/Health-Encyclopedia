package com.love.cookies.health_encyclopedia.View.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.love_cookies.cookie_library.Adapter.CommonAdapter;
import com.love_cookies.cookie_library.Adapter.CommonViewHolder;
import com.love_cookies.cookie_library.Fragment.BaseFragment;
import com.love_cookies.cookie_library.Utils.ProgressUtils;
import com.love_cookies.cookie_library.Widget.LoadAndRefreshView;

import com.love.cookies.health_encyclopedia.Config.APIs;
import com.love.cookies.health_encyclopedia.Model.Bean.FoodBean;
import com.love.cookies.health_encyclopedia.Presenter.FoodMainPresenter;
import com.love.cookies.health_encyclopedia.R;
import com.love.cookies.health_encyclopedia.View.Activity.FoodDetailActivity;
import com.love.cookies.health_encyclopedia.View.Interface.IFoodMain;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2015/11/25 0025.
 *
 * 食品Fragment
 */
@ContentView(R.layout.fragment_food_list)
public class FoodMainFragment extends BaseFragment implements IFoodMain, LoadAndRefreshView.OnHeaderRefreshListener, LoadAndRefreshView.OnFooterRefreshListener {

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

    FoodMainPresenter foodMainPresenter = new FoodMainPresenter(this);

    private int page = 1;

    private int STATUS = APIs.REFRESH;

    @Override
    public void initWidget(Bundle savedInstanceState) {
        loadAndRefreshView.setOnHeaderRefreshListener(this);
        loadAndRefreshView.setOnFooterRefreshListener(this);
        emptyView.setOnClickListener(this);
        failedView.setOnClickListener(this);
        initGridView();
        STATUS = APIs.REFRESH;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                foodMainPresenter.getFoodDate(page);
            }
        }, 100);
    }

    private void initGridView() {
        foodGridViewAdapter = new FoodGridViewAdapter(getContext(), foodDate);
        gridView.setAdapter(foodGridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), FoodDetailActivity.class);
                intent.putExtra("name", foodDate.get(position).getName());
                intent.putExtra("id", foodDate.get(position).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.empty_view:
            case R.id.failed_view:
                foodMainPresenter.getFoodDate(page);
                break;
            default:
                break;
        }
    }

    @Override
    public void initFoodDate(FoodBean foodBean) {
        loadAndRefreshView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        failedView.setVisibility(View.GONE);

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
        ProgressUtils.showProgress(getContext());
    }

    @Override
    public void hideLoading() {
        ProgressUtils.hideProgress();
    }

    @Override
    public void onHeaderRefresh(LoadAndRefreshView view) {
        page = 1;
        STATUS = APIs.REFRESH;
        foodMainPresenter.getFoodDate(page);
    }

    @Override
    public void onFooterRefresh(LoadAndRefreshView view) {
        STATUS = APIs.LOADMORE;
        foodMainPresenter.getFoodDate(++page);
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
