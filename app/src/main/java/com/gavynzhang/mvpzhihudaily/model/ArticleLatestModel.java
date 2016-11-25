package com.gavynzhang.mvpzhihudaily.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.gavynzhang.mvpzhihudaily.app.MyApplication;
import com.gavynzhang.mvpzhihudaily.model.entities.JsonAndRequestTime;

/**
 * Created by GavynZhang on 2016/11/25 1:15.
 */

public class ArticleLatestModel {
    public JsonAndRequestTime loadJson() {
        SharedPreferences preferences = MyApplication.getContext().getSharedPreferences("latestJsonData", Context.MODE_PRIVATE);
        JsonAndRequestTime jsonAndRequestTime = new JsonAndRequestTime();
        jsonAndRequestTime.setJsonData(preferences.getString("jsonData",""));
        jsonAndRequestTime.setRequestTime(preferences.getString("requestTime",""));
        return jsonAndRequestTime;
    }

    public void saveJson(JsonAndRequestTime jsonAndRequestTime) {
        SharedPreferences.Editor editor = MyApplication.getContext().getSharedPreferences("latestJsonData", Context.MODE_PRIVATE).edit();
        editor.putString("jsonData",jsonAndRequestTime.getJsonData());
        editor.putString("requestTime", jsonAndRequestTime.getRequestTime());
        editor.commit();
    }
}
