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

    public abstract int getLayoutResId();   //获取布局文件

    public abstract void initView();        //初始化页面

    public abstract void setTopTitle();     //设置头部标题
}
