package com.gavynzhang.mvpzhihudaily.model.entities;

import java.util.List;

/**
 * Created by GavynZhang on 2016/12/8 21:52.
 */

public class ArticleIndexAndDate {
    private List<ArticleIndex> mArticleIndices;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<ArticleIndex> getArticleIndices() {
        return mArticleIndices;
    }

    public void setArticleIndices(List<ArticleIndex> articleIndices) {
        mArticleIndices = articleIndices;
    }
}
