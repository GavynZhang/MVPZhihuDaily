package com.gavynzhang.mvpzhihudaily.presenter;

import com.gavynzhang.mvpzhihudaily.model.ArticleLatestModel;
import com.gavynzhang.mvpzhihudaily.model.entities.JsonAndRequestTime;
import com.gavynzhang.mvpzhihudaily.ui.ArticleIndexInterface;
import com.gavynzhang.mvpzhihudaily.utils.other.ParseJSON;

/**
 * Created by GavynZhang on 2016/11/25 1:24.
 */

public class ArticleIndexPresenter {
    ArticleIndexInterface mArticleIndexView;
    ArticleLatestModel articleLatestModel = new ArticleLatestModel();
    public ArticleIndexPresenter(ArticleIndexInterface articleIndexInterface){
        this.mArticleIndexView = articleIndexInterface;
    }

    public void showArticleIndices(){
        JsonAndRequestTime jsonString = articleLatestModel.loadJson();
        //if (jsonString.getJsonData()) 此处添加时间判断，根据之前请求时间判断是否通过网络请求
        mArticleIndexView.showArticleIndex(jsonString.getJsonData());
    }

}
