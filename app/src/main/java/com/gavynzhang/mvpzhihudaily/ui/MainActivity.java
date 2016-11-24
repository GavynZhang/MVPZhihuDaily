package com.gavynzhang.mvpzhihudaily.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gavynzhang.mvpzhihudaily.R;
import com.gavynzhang.mvpzhihudaily.app.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
