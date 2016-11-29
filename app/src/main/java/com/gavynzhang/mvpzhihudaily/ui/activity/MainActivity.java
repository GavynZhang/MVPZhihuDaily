package com.gavynzhang.mvpzhihudaily.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gavynzhang.mvpzhihudaily.R;
import com.gavynzhang.mvpzhihudaily.app.BaseActivity;
import com.gavynzhang.mvpzhihudaily.model.entities.ArticleIndex;
import com.gavynzhang.mvpzhihudaily.model.entities.latest.Latest;
import com.gavynzhang.mvpzhihudaily.presenter.ArticleIndexPresenter;
import com.gavynzhang.mvpzhihudaily.ui.ArticleIndexInterface;
import com.gavynzhang.mvpzhihudaily.ui.adapter.ArticleIndexListAdapter;
import com.gavynzhang.mvpzhihudaily.utils.other.ModelUtils;
import com.gavynzhang.mvpzhihudaily.utils.other.ParseJSON;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements ArticleIndexInterface {

    private ArticleIndexPresenter mPresenter = new ArticleIndexPresenter(MainActivity.this);

    private List<ArticleIndex> mArticleIndices = new ArrayList<>();
    private RecyclerView mArticleIndexList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        mPresenter.showArticleIndices();
    }

    private void initView(){
        mArticleIndexList = $(R.id.article_index);

    }


    @Override
    public void showArticleIndex(String jsonData) {
        Latest latest = ParseJSON.parseJsonToLatest(jsonData);
        mArticleIndices = ModelUtils.LatestToArticleIndexList(latest);
        mArticleIndexList.setLayoutManager(new LinearLayoutManager(this));
        mArticleIndexList.setAdapter(new ArticleIndexListAdapter(MainActivity.this, mArticleIndices));

    }
}
