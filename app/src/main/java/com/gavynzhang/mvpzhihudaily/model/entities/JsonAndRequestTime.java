package com.gavynzhang.mvpzhihudaily.model.entities;

/**
 * Created by GavynZhang on 2016/11/25 9:14.
 */

public class JsonAndRequestTime {
    private String jsonData;
    private long requestTime;

    public JsonAndRequestTime(){
        this.jsonData = "";
        this.requestTime = 0;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    public long getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(long requestTime) {
        this.requestTime = requestTime;
    }
}
