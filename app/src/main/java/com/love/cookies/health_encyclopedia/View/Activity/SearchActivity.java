package com.love.cookies.health_encyclopedia.View.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.love_cookies.cookie_library.Activity.BaseActivity;
import com.love_cookies.cookie_library.Adapter.CommonAdapter;
import com.love_cookies.cookie_library.Adapter.CommonViewHolder;
import com.love_cookies.cookie_library.Application.ActivityCollections;
import com.love_cookies.cookie_library.Utils.ProgressUtils;
import com.love_cookies.cookie_library.Utils.ToastUtils;
import com.love_cookies.cookie_library.Widget.LoadAndRefreshView;

import com.love.cookies.health_encyclopedia.Config.APIs;
import com.love.cookies.health_encyclopedia.Model.Bean.SearchBean;
import com.love.cookies.health_encyclopedia.Presenter.SearchPresenter;
import com.love.cookies.health_encyclopedia.R;
import com.love.cookies.health_encyclopedia.View.Interface.ISearch;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiekun on 2015/11/27 0027.
 *
 * 搜索Activity
 */
@ContentView(R.layout.activity_search)
public class SearchActivity extends BaseActivity implements ISearch, LoadAndRefreshView.OnHeaderRefreshListener, LoadAndRefreshView.OnFooterRefreshListener {

    @ViewInject(R.id.text_title)
    TextView pageTitle;
    @ViewInject(R.id.btn_left)
    ImageView btnLeft;
    @ViewInject(R.id.edit_search)
    EditText editText;
    @ViewInject(R.id.btn_search)
    TextView btnSearch;
    @ViewInject(R.id.load_and_refresh_view)
    LoadAndRefreshView loadAndRefreshView;
    @ViewInject(R.id.list_view)
    ListView listView;
    @ViewInject(R.id.empty_view)
    LinearLayout emptyView;
    @ViewInject(R.id.failed_view)
    LinearLayout failedView;

    SearchListViewAdapter searchListViewAdapter;

    List<SearchBean.Yi18Entity> searchDate = new ArrayList<>();

    SearchPresenter searchPresenter = new SearchPresenter(this);

    private String api = "";
    private String key = "";
    private int tag = -1;
    private int page = 1;
    private String keyword = "";

    private int STATUS = APIs.REFRESH;

    @Override
    public void initWidget(Bundle savedInstanceState) {
        api = getIntent().getStringExtra("api");
        key = getIntent().getStringExtra("key");
        tag = getIntent().getIntExtra("tag", -1);
        pageTitle.setText(R.string.search_title);
        btnLeft.setImageResource(R.drawable.com_tit_bt_back);
        btnLeft.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        emptyView.setOnClickListener(this);
        failedView.setOnClickListener(this);
        loadAndRefreshView.setOnHeaderRefreshListener(this);
        loadAndRefreshView.setOnFooterRefreshListener(this);
        initListView();
    }

    private void initListView() {
        searchListViewAdapter = new SearchListViewAdapter(this, searchDate);
        listView.setAdapter(searchListViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (tag) {
                    case APIs.TAG_FOOD:
                        intent = new Intent(ActivityCollections.getInstance().currentActivity(), FoodDetailActivity.class);
                        break;
                    case APIs.TAG_LORE:
                        intent = new Intent(ActivityCollections.getInstance().currentActivity(), LoreDetailActivity.class);
                        break;
                    case APIs.TAG_ASK:
                        intent = new Intent(ActivityCollections.getInstance().currentActivity(), AskDetailActivity.class);
                        break;
                    case APIs.TAG_SYMPTOM:
                        intent = new Intent(ActivityCollections.getInstance().currentActivity(), SymptomDetailActivity.class);
                        break;
                    default:
                        break;
                }
                intent.putExtra("name", searchDate.get(position).getTitle());
                intent.putExtra("id", searchDate.get(position).getId());
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
            case R.id.btn_search:
                startSearch();
                break;
            case R.id.empty_view:
            case R.id.failed_view:
                startSearch();
                break;
            default:
                break;
        }
    }

    @Override
    public void startSearch() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);

        keyword = editText.getText().toString();
        if(!TextUtils.isEmpty(keyword)) {
            page = 1;
            STATUS = APIs.REFRESH;
            searchPresenter.getSearchResult(api, key, page, keyword);
            listView.setSelection(0);
        } else {
            ToastUtils.show(this, R.string.search_keyword_hint);
        }
    }

    @Override
    public void initSearchResult(SearchBean searchBean) {
        loadAndRefreshView.setVisibility(View.VISIBLE);
        failedView.setVisibility(View.GONE);
        emptyView.setVisibility(View.GONE);

        if(STATUS == APIs.REFRESH) {
            searchDate.clear();
            searchDate.addAll(searchBean.getYi18());
        } else if(STATUS == APIs.LOADMORE) {
            searchDate.addAll(searchBean.getYi18());
        }
        searchListViewAdapter.notifyDataSetChanged();
        loadAndRefreshView.setResultSize(searchBean.getYi18().size());
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
        searchPresenter.getSearchResult(api, key, page, keyword);
    }

    @Override
    public void onFooterRefresh(LoadAndRefreshView view) {
        STATUS = APIs.LOADMORE;
        searchPresenter.getSearchResult(api, key, ++page, keyword);
    }

    class SearchListViewAdapter extends CommonAdapter<SearchBean.Yi18Entity> {

        public SearchListViewAdapter(Context context, List<SearchBean.Yi18Entity> datas) {
            super(context, R.layout.item_search_list, datas);
        }

        @Override
        public void convert(CommonViewHolder viewHolder, SearchBean.Yi18Entity result) {
            viewHolder.setImage(R.id.img, result.getImg());
            viewHolder.setHtmlText(R.id.title, result.getTitle());
            viewHolder.setHtmlText(R.id.content, result.getContent());
        }
    }

}
