package com.gavynzhang.mvpzhihudaily.presenter;

import com.gavynzhang.mvpzhihudaily.model.ArticleIndexModel;
import com.gavynzhang.mvpzhihudaily.model.ModelInterface;
import com.gavynzhang.mvpzhihudaily.model.entities.ArticleIndex;
import com.gavynzhang.mvpzhihudaily.ui.ArticleIndexInterface;

/**
 * Created by GavynZhang on 2016/11/25 1:24.
 */

public class ArticleIndexPresenter {
    ArticleIndexInterface mArticleIndexView;
    ModelInterface articleIndexModel = new ArticleIndexModel();
    public ArticleIndexPresenter(ArticleIndexInterface articleIndexInterface){
        this.mArticleIndexView = articleIndexInterface;
    }

    public void showArticleIndices(){
        String jsonString = articleIndexModel.loadJson();

    }

}
