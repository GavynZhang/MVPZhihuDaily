package com.gavynzhang.mvpzhihudaily.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by GavynZhang on 2016/11/25 8:55.
 */

public class ZhihuDailyOpenHelper extends SQLiteOpenHelper {

    public static final String CREATE_LATEST = "create table latest(date text," +
            "id integer primary key autoincrement," +
            "json text)";

    public static final String CREATE_BEFORE = "create table before(date text," +
            "id integer primary key autoincrement," +
            "json text)";

    public ZhihuDailyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_LATEST);
        db.execSQL(CREATE_BEFORE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
