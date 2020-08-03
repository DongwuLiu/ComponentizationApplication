package com.example.componentizationapplication.activities;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.componentizationapplication.R;
import com.example.componentizationapplication.views.TopTitleView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class DrawerLayoutActivity extends Activity implements View.OnClickListener {
    private DrawerLayout drawerLayout;
    private Button btnCloseRightView;
    private TopTitleView topTitleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_drawer_layout);

        initView();
    }

    private void initView() {
        drawerLayout = findViewById(R.id.drawer_layout);
        btnCloseRightView = findViewById(R.id.btn_close_right_sideslip_layout);
        topTitleView = findViewById(R.id.top_title_view);

        topTitleView.setOnClickListener(new TopTitleView.TopTitleClickListener() {
            @Override
            public void onLeftTitleClick() {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        setTopTitle();
        btnCloseRightView.setOnClickListener(this);
    }

    private void setTopTitle() {
        topTitleView.setTitleName("侧滑布局");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_close_right_sideslip_layout:
                //START、END对应布局文件中的layout_gravity属性
                drawerLayout.closeDrawer(GravityCompat.END);    //关闭右侧滑动布局
                drawerLayout.openDrawer(GravityCompat.START);   //打开左侧滑动布局
                break;
        }
    }
}
