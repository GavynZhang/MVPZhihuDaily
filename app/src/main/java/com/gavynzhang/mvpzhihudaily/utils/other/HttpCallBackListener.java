package com.gavynzhang.mvpzhihudaily.utils.other;

import com.gavynzhang.mvpzhihudaily.model.entities.JsonAndRequestTime;

/**
 * Created by GavynZhang on 2016/11/25 16:31.
 */

public interface HttpCallBackListener {
    void onFinish(String response);
    void onError(Exception e);
}
