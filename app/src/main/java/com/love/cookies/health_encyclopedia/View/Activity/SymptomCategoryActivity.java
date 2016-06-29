package com.love.cookies.health_encyclopedia.View.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Adapter.CommonAdapter;
import com.love_cookies.cookie_library.Adapter.CommonViewHolder;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ProgressUtils;
import com.love_cookies.cookie_library.Widget.LoadAndRefreshView;

import com.love.cookies.health_encyclopedia.Config.APIs;
import com.love.cookies.health_encyclopedia.Model.Bean.SymptomCategoryBean;
import com.love.cookies.health_encyclopedia.Presenter.SymptomCategoryPresenter;
import com.love.cookies.health_encyclopedia.R;
import com.love.cookies.health_encyclopedia.View.Interface.ISymptomCategory;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2015/12/1 0001.
 *
 * 症状条目Activity
 */
@ContentView(R.layout.activity_symptom_category)
public class SymptomCategoryActivity extends BaseActivity implements ISymptomCategory, LoadAndRefreshView.OnHeaderRefreshListener, LoadAndRefreshView.OnFooterRefreshListener {

    @ViewInject(R.id.text_title)
    TextView pageTitle;
    @ViewInject(R.id.btn_left)
    ImageView btnLeft;
    @ViewInject(R.id.load_and_refresh_view)
    LoadAndRefreshView loadAndRefreshView;
    @ViewInject(R.id.list_view)
    ListView listView;
    @ViewInject(R.id.empty_view)
    LinearLayout emptyView;
    @ViewInject(R.id.failed_view)
    LinearLayout failedView;

    SymptomCategoryListViewAdapter symptomCategoryListViewAdapter;

    List<SymptomCategoryBean.Yi18Entity> symptomCategoryDate = new ArrayList<>();

    SymptomCategoryPresenter symptomCategoryPresenter = new SymptomCategoryPresenter(this);

    private int page = 1;
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
        initListView();
        STATUS = APIs.REFRESH;
        id = getIntent().getIntExtra("id", -1);
        symptomCategoryPresenter.getSymptomCategoryDate(page, id);
    }

    private void initListView() {
        symptomCategoryListViewAdapter = new SymptomCategoryListViewAdapter(this, symptomCategoryDate);
        listView.setAdapter(symptomCategoryListViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ActivityCollections.getInstance().currentActivity(), SymptomDetailActivity.class);
                intent.putExtra("name", symptomCategoryDate.get(position).getName());
                intent.putExtra("id", symptomCategoryDate.get(position).getId());
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
                symptomCategoryPresenter.getSymptomCategoryDate(page, id);
                break;
            default:
                break;
        }
    }

    @Override
    public void onHeaderRefresh(LoadAndRefreshView view) {
        page = 1;
        STATUS = APIs.REFRESH;
        symptomCategoryPresenter.getSymptomCategoryDate(page, id);
    }

    @Override
    public void onFooterRefresh(LoadAndRefreshView view) {
        STATUS = APIs.LOADMORE;
        symptomCategoryPresenter.getSymptomCategoryDate(++page, id);
    }

    @Override
    public void initSymptomCategoryDate(SymptomCategoryBean symptomCategoryBean) {
        loadAndRefreshView.setVisibility(View.VISIBLE);
        failedView.setVisibility(View.GONE);
        emptyView.setVisibility(View.GONE);

        if(STATUS == APIs.REFRESH) {
            symptomCategoryDate.clear();
            symptomCategoryDate.addAll(symptomCategoryBean.getYi18());
        } else if(STATUS == APIs.LOADMORE) {
            symptomCategoryDate.addAll(symptomCategoryBean.getYi18());
        }
        symptomCategoryListViewAdapter.notifyDataSetChanged();
        loadAndRefreshView.setResultSize(symptomCategoryBean.getYi18().size());
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

    class SymptomCategoryListViewAdapter extends CommonAdapter<SymptomCategoryBean.Yi18Entity> {

        public SymptomCategoryListViewAdapter(Context context, List<SymptomCategoryBean.Yi18Entity> datas) {
            super(context, R.layout.item_symptom_category_list, datas);
        }

        @Override
        public void convert(CommonViewHolder viewHolder, SymptomCategoryBean.Yi18Entity symptomCategory) {
            viewHolder.setImage(R.id.symptom_img, symptomCategory.getImg());
            viewHolder.setText(R.id.symptom_title, symptomCategory.getName());
            viewHolder.setText(R.id.symptom_place, symptomCategory.getPlace());
        }
    }

}
