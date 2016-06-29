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

import com.love.cookies.health_encyclopedia.Config.APIs;
import com.love.cookies.health_encyclopedia.Model.Bean.EffectBean;
import com.love.cookies.health_encyclopedia.Presenter.EffectMainPresenter;
import com.love.cookies.health_encyclopedia.R;
import com.love.cookies.health_encyclopedia.View.Activity.FoodCategoryActivity;
import com.love.cookies.health_encyclopedia.View.Interface.IEffectMain;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2015/11/26 0026.
 *
 * 疗效Fragment
 */
@ContentView(R.layout.fragment_effect_main)
public class EffectMainFragment extends BaseFragment implements IEffectMain {

    @ViewInject(R.id.grid_view)
    GridView gridView;
    @ViewInject(R.id.empty_view)
    LinearLayout emptyView;
    @ViewInject(R.id.failed_view)
    LinearLayout failedView;

    EffectGridViewAdapter effectGridViewAdapter;

    List<EffectBean.Yi18Entity> effectDate = new ArrayList<>();

    EffectMainPresenter effectMainPresenter = new EffectMainPresenter(this);

    @Override
    public void initWidget(Bundle savedInstanceState) {
        emptyView.setOnClickListener(this);
        failedView.setOnClickListener(this);
        initGridView();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                effectMainPresenter.getEffectDate();
            }
        }, 250);
    }

    private void initGridView() {
        effectGridViewAdapter = new EffectGridViewAdapter(getContext(), effectDate);
        gridView.setAdapter(effectGridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), FoodCategoryActivity.class);
                intent.putExtra("name", effectDate.get(position).getName());
                intent.putExtra("id", effectDate.get(position).getId());
                intent.putExtra("api", APIs.APIX_FOOD_MENU_LIST);
                startActivity(intent);
            }
        });
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.empty_view:
            case R.id.failed_view:
                effectMainPresenter.getEffectDate();
                break;
            default:
                break;
        }
    }

    @Override
    public void initEffectDate(EffectBean effectBean) {
        gridView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        failedView.setVisibility(View.GONE);

        effectDate.addAll(effectBean.getYi18());
        effectGridViewAdapter.notifyDataSetChanged();
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
        ProgressUtils.showProgress(getContext());
    }

    @Override
    public void hideLoading() {
        ProgressUtils.hideProgress();
    }

    class EffectGridViewAdapter extends CommonAdapter<EffectBean.Yi18Entity> {

        public EffectGridViewAdapter(Context context, List<EffectBean.Yi18Entity> datas) {
            super(context, R.layout.item_effect_list, datas);
        }

        @Override
        public void convert(CommonViewHolder viewHolder, EffectBean.Yi18Entity effect) {
            viewHolder.setText(R.id.effect_name, effect.getName());
        }
    }

}
