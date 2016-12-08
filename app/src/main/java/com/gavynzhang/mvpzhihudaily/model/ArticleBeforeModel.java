package com.gavynzhang.mvpzhihudaily.model;

import android.util.Log;

import com.gavynzhang.mvpzhihudaily.app.MyApplication;
import com.gavynzhang.mvpzhihudaily.config.API;
import com.gavynzhang.mvpzhihudaily.model.db.ZhihuDailyDB;
import com.gavynzhang.mvpzhihudaily.model.db.ZhihuDailyOpenHelper;
import com.gavynzhang.mvpzhihudaily.model.entities.JsonAndDate;
import com.gavynzhang.mvpzhihudaily.presenter.ArticleIndexPresenterInterface;
import com.gavynzhang.mvpzhihudaily.utils.other.HttpCallBackListener;
import com.gavynzhang.mvpzhihudaily.utils.other.HttpUtil;
import com.gavynzhang.mvpzhihudaily.utils.other.LogUtils;

/**
 * Created by GavynZhang on 2016/12/4 16:58.
 */

public class ArticleBeforeModel {

    private static final String CLASS_NAME = "ArticleBeforeModel";

    private ArticleIndexPresenterInterface mArticleIndexPresenter = null;
    private ZhihuDailyDB mZhihuDailyDB = ZhihuDailyDB.getInstance(MyApplication.getContext());

    public ArticleBeforeModel(ArticleIndexPresenterInterface articleIndexPresenterInterface){
        this.mArticleIndexPresenter = articleIndexPresenterInterface;
    }

    public JsonAndDate loadJson(final String date){
        JsonAndDate jsonAndDate = new JsonAndDate();
        String response = null;
        response = mZhihuDailyDB.loadBeforeJson(date);
        LogUtils.d(CLASS_NAME,"DBresponse: "+response);
        if (response == null){
            LogUtils.d(CLASS_NAME, "Will send Http request: "+API.getBEFORE(date));
            HttpUtil.sendHttpRequest(API.getBEFORE(date), new HttpCallBackListener() {
                @Override
                public void onFinish(String response) {
                    LogUtils.d(CLASS_NAME, "httpResponse: "+response);
                    JsonAndDate jsonAndDate = new JsonAndDate();
                    jsonAndDate.setDate(date);
                    jsonAndDate.setJsonData(response);
                    mArticleIndexPresenter.loadBeforeSuccess(jsonAndDate);
                    mZhihuDailyDB.saveBeforeJson(response,date);
                }

                @Override
                public void onError(Exception e) {
                    LogUtils.d(CLASS_NAME,"loadBeforeError: "+e);
                    mArticleIndexPresenter.loadError(e);
                }
            });
        }
        jsonAndDate.setDate(date);
        jsonAndDate.setJsonData(response);
        return jsonAndDate;
    }

}
