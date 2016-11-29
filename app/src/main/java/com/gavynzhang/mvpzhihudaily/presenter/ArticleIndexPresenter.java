package com.gavynzhang.mvpzhihudaily.presenter;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.gavynzhang.mvpzhihudaily.model.ArticleLatestModel;
import com.gavynzhang.mvpzhihudaily.model.entities.JsonAndRequestTime;
import com.gavynzhang.mvpzhihudaily.ui.ArticleIndexInterface;
import com.gavynzhang.mvpzhihudaily.utils.other.ConstUtils;
import com.gavynzhang.mvpzhihudaily.utils.other.ParseJSON;
import com.gavynzhang.mvpzhihudaily.utils.other.TimeUtils;

/**
 * Created by GavynZhang on 2016/11/25 1:24.
 */

public class ArticleIndexPresenter implements ArticleIndexPresenterInterface{

    public static final int SHOW_RESPONSE = 0;
    public static final int REQUEST_ERROR = 1;

    ArticleIndexInterface mArticleIndexView;
    ArticleLatestModel articleLatestModel = new ArticleLatestModel(this);

    public ArticleIndexPresenter(ArticleIndexInterface articleIndexInterface){
        this.mArticleIndexView = articleIndexInterface;
    }

    public void showArticleIndices(){
        JsonAndRequestTime jsonData = articleLatestModel.loadJson();

        if (jsonData != null) {
            mArticleIndexView.showArticleIndex(jsonData.getJsonData());
        }
    }

    public Handler mHandler = new Handler(Looper.getMainLooper()){
        public void handleMessage(Message msg){
            switch (msg.what){
                case SHOW_RESPONSE:
                    mArticleIndexView.showArticleIndex(msg.obj.toString());
            }
        }
    };


    @Override
    public void loadSuccess(final JsonAndRequestTime jsonAndRequestTime) {
        Message message = new Message();
        message.what = SHOW_RESPONSE;
        message.obj = jsonAndRequestTime.getJsonData();
        //if (jsonAndRequestTime != null)
        //articleLatestModel.saveJson(jsonAndRequestTime);
        mHandler.sendMessage(message);
    }

    @Override
    public void loadError(Exception e) {
        e.printStackTrace();
    }
}
