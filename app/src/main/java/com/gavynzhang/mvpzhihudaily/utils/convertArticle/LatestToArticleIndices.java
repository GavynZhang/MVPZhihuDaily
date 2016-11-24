package com.gavynzhang.mvpzhihudaily.utils.convertArticle;

import com.gavynzhang.mvpzhihudaily.model.entities.ArticleIndex;
import com.gavynzhang.mvpzhihudaily.model.entities.latest.Latest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GavynZhang on 2016/11/25 1:42.
 */

public class LatestToArticleIndices {
    public static List<ArticleIndex> convertToArticleIndices(Latest latest){
        List<ArticleIndex> articleIndices = new ArrayList<>();
        int size = latest.getStories().size();
        String date = latest.getDate();
        for(int i = 0; i < size; i++){
            ArticleIndex articleIndex = new ArticleIndex();
            articleIndex.setDate(date);
            articleIndex.setId(String.valueOf(latest.getStories().get(i).getId()));
            articleIndex.setImage_url(latest.getStories().get(i).getImages().get(0));
            articleIndex.setTitle(latest.getStories().get(i).getTitle());
            articleIndices.add(articleIndex);
        }
        return articleIndices;
    }
}
