package com.gavynzhang.mvpzhihudaily.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by GavynZhang on 2016/11/25 9:01.
 */

public class ZhihuDailyDB {
    public static final String DB_NAME = "Zhihu_daily.db";
    public static final int VERSION = 1;
    public static ZhihuDailyDB zhihuDailyDB = null;
    private SQLiteDatabase db = null;

    private ZhihuDailyDB(Context context){
        ZhihuDailyOpenHelper dbHelper = new ZhihuDailyOpenHelper(context, DB_NAME, null, VERSION);
        db = dbHelper.getWritableDatabase();
    }

    public synchronized static ZhihuDailyDB getInstance(Context context){
        if(zhihuDailyDB == null){
            zhihuDailyDB = new ZhihuDailyDB(context);
        }
        return zhihuDailyDB;
    }

    public void saveLatestJson(String jsonData){

    }
}
