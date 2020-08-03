package com.example.componentizationapplication.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.componentizationapplication.R;
import com.example.componentizationapplication.application.MyApplication;
import com.example.componentizationapplication.views.TopTitleView;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private TopTitleView topTitleView;
    private Button goSwipeLayout;
    private Button goDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication myApplication = MyApplication.getInstance();
        Log.d(TAG, "onCreate: MyApplication num = " + myApplication.getNum());
        myApplication.setNum(10);
        Log.d(TAG, "onCreate: MyApplication num = " + myApplication.getNum());
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        topTitleView = findViewById(R.id.app_top_layout_view);
        goSwipeLayout = findViewById(R.id.go_swipe_refresh_layout);
        goDrawerLayout = findViewById(R.id.go_drawer_layout);

        goSwipeLayout.setOnClickListener(this);
        goDrawerLayout.setOnClickListener(this);
    }

    @Override
    public void setTopTitle() {
        topTitleView.setTitleName("组件化主界面");
//        topTitleView.isShowLeftTopMenus(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.go_swipe_refresh_layout:
                startActivity(new Intent(MainActivity.this, SwipeRefreshLayoutActivity.class));
                break;
            case R.id.go_drawer_layout:
                startActivity(new Intent(MainActivity.this, DrawerLayoutActivity.class));
                break;
        }
    }
}
