package com.example.componentizationapplication.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
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
        topTitleView.isShowLeftTopMenus(false);
        topTitleView.isShowLeftTopBack(false);
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            //如果用户按下返回键
            new AlertDialog.Builder(this)
                    .setTitle("退出应用")
                    .setMessage("确认退出" + getResources().getString(R.string.app_name) + "?")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("取消", null)
                    .show();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
