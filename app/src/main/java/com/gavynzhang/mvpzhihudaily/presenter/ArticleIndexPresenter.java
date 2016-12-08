package com.gavynzhang.mvpzhihudaily.presenter;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.gavynzhang.mvpzhihudaily.model.ArticleBeforeModel;
import com.gavynzhang.mvpzhihudaily.model.ArticleLatestModel;
import com.gavynzhang.mvpzhihudaily.model.entities.JsonAndDate;
import com.gavynzhang.mvpzhihudaily.model.entities.JsonAndRequestTime;
import com.gavynzhang.mvpzhihudaily.ui.ArticleIndexInterface;
import com.gavynzhang.mvpzhihudaily.utils.other.ConstUtils;
import com.gavynzhang.mvpzhihudaily.utils.other.ParseJSON;
import com.gavynzhang.mvpzhihudaily.utils.other.TimeUtils;

/**
 * Created by GavynZhang on 2016/11/25 1:24.
 */

public class ArticleIndexPresenter implements ArticleIndexPresenterInterface{

    public static final int SHOW_LATEST = 0;
    public static final int SHOW_BEFORE = 1;
    public static final int REQUEST_ERROR = 2;

    ArticleIndexInterface mArticleIndexView;
    ArticleLatestModel articleLatestModel = new ArticleLatestModel(this);
    ArticleBeforeModel articleBeforeModel = new ArticleBeforeModel(this);

    public ArticleIndexPresenter(ArticleIndexInterface articleIndexInterface){
        this.mArticleIndexView = articleIndexInterface;
    }

    public void showArticleIndices(){
        JsonAndRequestTime jsonData = articleLatestModel.loadJson();

        if (jsonData != null) {
            mArticleIndexView.showArticleLatestIndex(jsonData.getJsonData());
        }
    }

    public void showLatestArticleIndices(){
        articleLatestModel.loadLatestJson();
    }

    public void showBeforeArticleIndices(String date){
        JsonAndDate jsonAndDate = articleBeforeModel.loadJson(date);
        if (jsonAndDate != null){
            mArticleIndexView.showArticleBeforeIndex(jsonAndDate);
        }
    }

    public Handler mHandler = new Handler(Looper.getMainLooper()){
        public void handleMessage(Message msg){
            switch (msg.what){
                case SHOW_LATEST:
                    mArticleIndexView.showArticleLatestIndex(msg.obj.toString());
                    break;
                case SHOW_BEFORE:
                    mArticleIndexView.showArticleBeforeIndex((JsonAndDate) msg.obj);
                    break;
            }
        }
    };


    @Override
    public void loadSuccess(final JsonAndRequestTime jsonAndRequestTime) {
        Message message = new Message();
        message.what = SHOW_LATEST;
        message.obj = jsonAndRequestTime.getJsonData();
        //if (jsonAndRequestTime != null)
        //articleLatestModel.saveJson(jsonAndRequestTime);
        mHandler.sendMessage(message);
    }

    @Override
    public void loadBeforeSuccess(JsonAndDate jsonAndDate) {
        Message message = new Message();
        message.what = SHOW_LATEST;
        message.obj = jsonAndDate;
        mHandler.sendMessage(message);
    }

    @Override
    public void loadError(Exception e) {
        e.printStackTrace();
    }
}
