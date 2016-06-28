package com.love.cookies.doctor.View.Fragment;

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

import com.love.cookies.doctor.Config.APIs;
import com.love.cookies.doctor.Model.Bean.FunctionBean;
import com.love.cookies.doctor.Presenter.FunctionMainPresenter;
import com.love.cookies.doctor.R;
import com.love.cookies.doctor.View.Activity.FoodCategoryActivity;
import com.love.cookies.doctor.View.Interface.IFunctionMain;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2015/11/26 0026.
 *
 * 功能Fragment
 */
@ContentView(R.layout.fragment_function_main)
public class FunctionMainFragment extends BaseFragment implements IFunctionMain {

    @ViewInject(R.id.grid_view)
    GridView gridView;
    @ViewInject(R.id.empty_view)
    LinearLayout emptyView;
    @ViewInject(R.id.failed_view)
    LinearLayout failedView;

    FunctionGridViewAdapter functionGridViewAdapter;

    List<FunctionBean.Yi18Entity> functionDate = new ArrayList<>();

    FunctionMainPresenter functionMainPresenter = new FunctionMainPresenter(this);

    @Override
    public void initWidget(Bundle savedInstanceState) {
        emptyView.setOnClickListener(this);
        failedView.setOnClickListener(this);
        initGridView();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                functionMainPresenter.getFunctionDate();
            }
        }, 400);
    }

    private void initGridView() {
        functionGridViewAdapter = new FunctionGridViewAdapter(getContext(), functionDate);
        gridView.setAdapter(functionGridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), FoodCategoryActivity.class);
                intent.putExtra("name", functionDate.get(position).getName());
                intent.putExtra("id", functionDate.get(position).getId());
                intent.putExtra("api", APIs.APIX_FOOD_BAR_LIST);
                startActivity(intent);
            }
        });
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.empty_view:
            case R.id.failed_view:
                functionMainPresenter.getFunctionDate();
                break;
            default:
                break;
        }
    }

    @Override
    public void initFunctionDate(FunctionBean functionBean) {
        gridView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        failedView.setVisibility(View.GONE);

        functionDate.addAll(functionBean.getYi18());
        functionGridViewAdapter.notifyDataSetChanged();
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

    class FunctionGridViewAdapter extends CommonAdapter<FunctionBean.Yi18Entity> {

        public FunctionGridViewAdapter(Context context, List<FunctionBean.Yi18Entity> datas) {
            super(context, R.layout.item_function_list, datas);
        }

        @Override
        public void convert(CommonViewHolder viewHolder, FunctionBean.Yi18Entity function) {
            viewHolder.setText(R.id.function_name, function.getName());
        }
    }

}
