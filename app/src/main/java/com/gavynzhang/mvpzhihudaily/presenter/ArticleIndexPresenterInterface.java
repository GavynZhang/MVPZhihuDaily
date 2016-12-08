package com.gavynzhang.mvpzhihudaily.presenter;

import com.gavynzhang.mvpzhihudaily.model.entities.JsonAndDate;
import com.gavynzhang.mvpzhihudaily.model.entities.JsonAndRequestTime;

/**
 * Created by GavynZhang on 2016/11/29 19:19.
 */

public interface ArticleIndexPresenterInterface {
    void loadSuccess(JsonAndRequestTime jsonAndRequestTime);
    void loadBeforeSuccess(JsonAndDate jsonAndDate);
    void loadError(Exception e);
}
