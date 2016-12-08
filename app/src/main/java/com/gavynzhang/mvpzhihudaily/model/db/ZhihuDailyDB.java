package com.gavynzhang.mvpzhihudaily.model.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public void saveBeforeJson(String jsonData, String date){
        if (jsonData!=null){
            ContentValues values = new ContentValues();
            values.put("date",date);
            values.put("json",jsonData);
            db.insert("before",null,values);
        }
    }

    public String loadBeforeJson(String date){
        String jsonData = null;
        Cursor cursor = db.query("before",null,"date="+date,null,null,null,null);
        if (cursor.moveToFirst()){
            do{
                jsonData = cursor.getString(cursor.getColumnIndex("json"));
            }while(cursor.moveToNext());
        }
        return jsonData;
    }
}
