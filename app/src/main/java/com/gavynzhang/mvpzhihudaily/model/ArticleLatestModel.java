package com.gavynzhang.mvpzhihudaily.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Message;

import com.gavynzhang.mvpzhihudaily.app.MyApplication;
import com.gavynzhang.mvpzhihudaily.config.API;
import com.gavynzhang.mvpzhihudaily.model.entities.JsonAndRequestTime;
import com.gavynzhang.mvpzhihudaily.presenter.ArticleIndexPresenter;
import com.gavynzhang.mvpzhihudaily.presenter.ArticleIndexPresenterInterface;
import com.gavynzhang.mvpzhihudaily.utils.other.ConstUtils;
import com.gavynzhang.mvpzhihudaily.utils.other.HttpCallBackListener;
import com.gavynzhang.mvpzhihudaily.utils.other.HttpUtil;
import com.gavynzhang.mvpzhihudaily.utils.other.LogUtils;
import com.gavynzhang.mvpzhihudaily.utils.other.TimeUtils;

/**
 * Created by GavynZhang on 2016/11/25 1:15.
 */

public class ArticleLatestModel {
    public static final String CLASS_NAME = "ArticleLatestModel";

    private ArticleIndexPresenterInterface mArticleIndexPresenter;

    public ArticleLatestModel(ArticleIndexPresenterInterface articleIndexPresenterInterface){
        this.mArticleIndexPresenter = articleIndexPresenterInterface;
    }

    public JsonAndRequestTime loadJson() {

                HttpUtil.sendHttpRequest(API.LATEST, new HttpCallBackListener() {

                    @Override
                    public void onFinish(String response) {
                        LogUtils.d(CLASS_NAME,"request response: "+response);
                        JsonAndRequestTime jsonAndRequestTime = new JsonAndRequestTime();
                        jsonAndRequestTime.setJsonData(response);
                        jsonAndRequestTime.setRequestTime(TimeUtils.getCurTimeMills());
                        mArticleIndexPresenter.loadSuccess(jsonAndRequestTime);
                    }

                    @Override
                    public void onError(Exception e) {
                        mArticleIndexPresenter.loadError(e);
                    }
                });


        return null;
    }

    public void saveJson(JsonAndRequestTime jsonAndRequestTime) {
        SharedPreferences.Editor editor = MyApplication.getContext().getSharedPreferences("latestJsonData", Context.MODE_PRIVATE).edit();
        editor.putString("jsonData",jsonAndRequestTime.getJsonData());
        editor.putLong("requestTime", jsonAndRequestTime.getRequestTime());
        editor.apply();
    }
}
