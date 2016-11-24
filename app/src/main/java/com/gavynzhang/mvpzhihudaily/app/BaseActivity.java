package com.gavynzhang.mvpzhihudaily.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by GavynZhang on 2016/11/25 0:57.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public <T extends View> T $(int id){
        return (T)findViewById(id);
    }
}
