package com.gavynzhang.mvpzhihudaily.utils.other;

import com.gavynzhang.mvpzhihudaily.model.entities.article.ArticleContent;
import com.gavynzhang.mvpzhihudaily.model.entities.before.Before;
import com.gavynzhang.mvpzhihudaily.model.entities.latest.Latest;
import com.google.gson.Gson;

/**
 * Created by GavynZhang on 2016/11/17 12:54.
 */

public class ParseJSON {
    public static Latest parseJsonToLatest(String jsonData){
        Gson gson = new Gson();
        Latest latest = gson.fromJson(jsonData, Latest.class);
        return latest;
    }
    public static Before parseJsonToBefore(String jsonData){
        Gson gson = new Gson();
        Before before = gson.fromJson(jsonData, Before.class);
        return before;
    }
    public static ArticleContent parseJsonToArticleContent(String jsonData){
        Gson gson = new Gson();
        ArticleContent articleContent = gson.fromJson(jsonData, ArticleContent.class);
        return articleContent;
    }

}
