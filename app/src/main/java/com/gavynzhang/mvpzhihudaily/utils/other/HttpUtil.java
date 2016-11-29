package com.gavynzhang.mvpzhihudaily.utils.other;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by GavynZhang on 2016/11/25 16:31.
 */

public class HttpUtil {
    public static void sendHttpRequest(final String address, final HttpCallBackListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url(address).build();
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    if (response.isSuccessful()){
                        listener.onFinish(response.body().string());
                    }else{
                        listener.onError(new IOException("Unexpected code " + response));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
