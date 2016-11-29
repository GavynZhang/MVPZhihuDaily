package com.gavynzhang.mvpzhihudaily.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Message;

import com.gavynzhang.mvpzhihudaily.app.MyApplication;
import com.gavynzhang.mvpzhihudaily.config.API;
import com.gavynzhang.mvpzhihudaily.config.ConstData;
import com.gavynzhang.mvpzhihudaily.model.entities.JsonAndRequestTime;
import com.gavynzhang.mvpzhihudaily.presenter.ArticleIndexPresenter;
import com.gavynzhang.mvpzhihudaily.presenter.ArticleIndexPresenterInterface;
import com.gavynzhang.mvpzhihudaily.utils.other.AndroidStateUtils;
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

    SharedPreferences sharedPreferences = MyApplication.getContext().getSharedPreferences("latestJsonData",Context.MODE_PRIVATE);
    final JsonAndRequestTime jsonAndRequestTime = new JsonAndRequestTime();

    public ArticleLatestModel(ArticleIndexPresenterInterface articleIndexPresenterInterface){
        this.mArticleIndexPresenter = articleIndexPresenterInterface;
    }

    public JsonAndRequestTime loadJson() {

        if (TimeUtils.getCurTimeMills() - sharedPreferences.getLong("requestTime", 0) < ConstData.TIME_OVERRIDE
                && sharedPreferences.getLong("requestTime", 0) != 0){
            //执行从本地加载数据
            loadFromSharedPreference();

            LogUtils.d(CLASS_NAME,"NetWork: "+AndroidStateUtils.isNetWorkAvailable());

        }else if (!AndroidStateUtils.isNetWorkAvailable()) {
            loadFromSharedPreference();
        }
        else{
            //本地没有数据或者数据超时
            HttpUtil.sendHttpRequest(API.LATEST, new HttpCallBackListener() {
                @Override
                public void onFinish(String response) {
                    LogUtils.d(CLASS_NAME, "Load From Internet, and request response is: " + response);

                    jsonAndRequestTime.setJsonData(response);
                    jsonAndRequestTime.setRequestTime(TimeUtils.getCurTimeMills());
                    mArticleIndexPresenter.loadSuccess(jsonAndRequestTime);
                    saveJson(jsonAndRequestTime);
                }

                @Override
                public void onError(Exception e) {
                    mArticleIndexPresenter.loadError(e);
                }
            });
        }


        return null;
    }

    private void loadFromSharedPreference(){

        LogUtils.d(CLASS_NAME,"Load From SharedPreference, and requestTime is : "+sharedPreferences.getLong("requestTime",0));

        String jsonData = sharedPreferences.getString("jsonData","");
        long requestTime = sharedPreferences.getLong("requestTime", 0);

        LogUtils.d(CLASS_NAME, "saved jsonData: " + jsonData);

        jsonAndRequestTime.setJsonData(jsonData);
        jsonAndRequestTime.setRequestTime(requestTime);

        mArticleIndexPresenter.loadSuccess(jsonAndRequestTime);
    }

    private void saveJson(JsonAndRequestTime jsonAndRequestTime) {
        SharedPreferences.Editor editor = MyApplication.getContext().getSharedPreferences("latestJsonData", Context.MODE_PRIVATE).edit();
        editor.putString("jsonData",jsonAndRequestTime.getJsonData());
        editor.putLong("requestTime", jsonAndRequestTime.getRequestTime());
        LogUtils.d(CLASS_NAME,"will save requestTime: "+jsonAndRequestTime.getRequestTime());
        editor.commit();
    }
}
