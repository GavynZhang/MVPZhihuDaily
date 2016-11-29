package com.gavynzhang.mvpzhihudaily.utils.other;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.gavynzhang.mvpzhihudaily.app.MyApplication;

/**
 * Created by GavynZhang on 2016/11/29 21:32.
 */

public class AndroidStateUtils {
    public static boolean isNetWorkAvailable(){
        Context context = MyApplication.getContext();
        if (context != null) {
            // 获取手机所有连接管理对象(包括对wi-fi,net等连接的管理)
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            // 获取NetworkInfo对象
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            //判断NetworkInfo对象是否为空
            if (networkInfo != null)
                return networkInfo.isAvailable();
        }
        return false;
    }
}
