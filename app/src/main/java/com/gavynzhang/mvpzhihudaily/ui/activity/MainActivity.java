package com.gavynzhang.mvpzhihudaily.ui.activity;

import android.graphics.Color;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gavynzhang.mvpzhihudaily.R;
import com.gavynzhang.mvpzhihudaily.app.BaseActivity;
import com.gavynzhang.mvpzhihudaily.app.MyApplication;
import com.gavynzhang.mvpzhihudaily.model.entities.ArticleIndex;
import com.gavynzhang.mvpzhihudaily.model.entities.JsonAndDate;
import com.gavynzhang.mvpzhihudaily.model.entities.before.Before;
import com.gavynzhang.mvpzhihudaily.model.entities.latest.Latest;
import com.gavynzhang.mvpzhihudaily.presenter.ArticleIndexPresenter;
import com.gavynzhang.mvpzhihudaily.ui.ArticleIndexInterface;
import com.gavynzhang.mvpzhihudaily.ui.adapter.ArticleIndexListAdapter;
import com.gavynzhang.mvpzhihudaily.ui.adapter.EndLessOnScrollListener;
import com.gavynzhang.mvpzhihudaily.utils.other.AndroidStateUtils;
import com.gavynzhang.mvpzhihudaily.utils.other.LogUtils;
import com.gavynzhang.mvpzhihudaily.utils.other.ModelUtils;
import com.gavynzhang.mvpzhihudaily.utils.other.ParseJSON;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements ArticleIndexInterface, SwipeRefreshLayout.OnRefreshListener {

    private static final String CLASS_NAME = "MainActivity";

    private ArticleIndexPresenter mPresenter = new ArticleIndexPresenter(MainActivity.this);

    private List<List<ArticleIndex>> mArticleIndicesList = new ArrayList<>();
    private RecyclerView mArticleIndexListView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    private LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
    private ArticleIndexListAdapter mIndexListAdapter = new ArticleIndexListAdapter(MainActivity.this, mArticleIndicesList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        mPresenter.showArticleIndices();
    }

    private void initView(){
        mArticleIndexListView = $(R.id.article_index);
        mSwipeRefreshLayout = $(R.id.swipe_refresh_layout);

        mArticleIndexListView.addOnScrollListener(new EndLessOnScrollListener(mLinearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                mPresenter.showBeforeArticleIndices("20161203");
            }
        });

        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.md_green_500,
                R.color.md_blue_500,
                R.color.md_orange_500,
                R.color.md_purple_500);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void showArticleLatestIndex(String jsonData) {
        Latest latest = ParseJSON.parseJsonToLatest(jsonData);
        List<ArticleIndex> mArticleIndices = ModelUtils.LatestToArticleIndexList(latest);
        mArticleIndicesList.add(mArticleIndices);
        mIndexListAdapter.notifyDataSetChanged();
        mArticleIndexListView.setLayoutManager(mLinearLayoutManager);
        mArticleIndexListView.setAdapter(mIndexListAdapter);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showArticleBeforeIndex(JsonAndDate jsonAndDate) {
        LogUtils.d(CLASS_NAME,"before response: "+jsonAndDate.getJsonData());
        Before before = ParseJSON.parseJsonToBefore(jsonAndDate.getJsonData());
        List<ArticleIndex> articleIndices = ModelUtils.BeforeToArticleIndexList(before);
        mArticleIndicesList.add(articleIndices);
        mIndexListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (!AndroidStateUtils.isNetWorkAvailable()){
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Snackbar snackbar = Snackbar.make(mArticleIndexListView,"好像没网 ￣へ￣ ？？",Snackbar.LENGTH_LONG);
                    setSnackBarColor(snackbar, getResources().getColor(R.color.mint_green_02),getResources().getColor(R.color.md_grey_300));
                    snackbar.show();
                    (MainActivity.this).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //切换回主线程中，可以更新UI
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    });
                }else{
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mPresenter.showLatestArticleIndices();
                }

            }
        }).start();
    }

    private void setSnackBarColor(Snackbar snackbar, int backgroundColor, int messageColor){
        View view = snackbar.getView();//获取Snackbar的view
        if(view!=null){
            view.setBackgroundColor(backgroundColor);//修改view的背景色
            ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(messageColor);//获取Snackbar的message控件，修改字体颜色
        }
    }
}
