package com.gavynzhang.mvpzhihudaily.ui;

import com.gavynzhang.mvpzhihudaily.model.entities.ArticleIndex;
import com.gavynzhang.mvpzhihudaily.model.entities.JsonAndDate;

import java.util.List;

/**
 * Created by GavynZhang on 2016/11/25 1:27.
 */

public interface ArticleIndexInterface {
    void showArticleLatestIndex(String jsonData);
    void showArticleBeforeIndex(JsonAndDate jsonAndDate);
}
