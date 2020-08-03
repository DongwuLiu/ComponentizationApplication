package com.example.componentizationapplication.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.componentizationapplication.R;
import com.example.componentizationapplication.application.MyApplication;


public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    Button goSwipeLayout;
    Button goDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication myApplication = MyApplication.getInstance();
        Log.d(TAG, "onCreate: MyApplication num = " + myApplication.getNum());
        myApplication.setNum(10);
        Log.d(TAG, "onCreate: MyApplication num = " + myApplication.getNum());

        initView();
    }

    private void initView() {
        goSwipeLayout = findViewById(R.id.go_swipe_refresh_layout);
        goDrawerLayout = findViewById(R.id.go_drawer_layout);

        goSwipeLayout.setOnClickListener(this);
        goDrawerLayout.setOnClickListener(this);
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
