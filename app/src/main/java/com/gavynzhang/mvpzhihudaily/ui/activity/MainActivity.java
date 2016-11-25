package com.gavynzhang.mvpzhihudaily.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gavynzhang.mvpzhihudaily.R;
import com.gavynzhang.mvpzhihudaily.app.BaseActivity;
import com.gavynzhang.mvpzhihudaily.model.entities.ArticleIndex;
import com.gavynzhang.mvpzhihudaily.ui.ArticleIndexInterface;

import java.util.List;

public class MainActivity extends BaseActivity implements ArticleIndexInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void showArticleIndex(String jsonData) {

    }
}
