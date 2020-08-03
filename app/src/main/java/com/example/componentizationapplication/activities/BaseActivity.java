package com.example.componentizationapplication.activities;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        initView();
        setTopTitle();
    }

    public abstract int getLayoutResId();

    public abstract void initView();

    public abstract void setTopTitle();
}
