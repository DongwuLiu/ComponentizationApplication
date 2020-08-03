package com.example.componentizationapplication.activities;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.componentizationapplication.R;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class DrawerLayoutActivity extends Activity implements View.OnClickListener {
    private DrawerLayout drawerLayout;
    private ImageView leftMenus;
    private Button btnCloseRightView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_drawer_layout);

        initView();
    }

    private void initView() {
        drawerLayout = findViewById(R.id.drawer_layout);
        leftMenus = findViewById(R.id.top_menus);
        btnCloseRightView = findViewById(R.id.btn_close_right_sideslip_layout);

        leftMenus.setOnClickListener(this);
        btnCloseRightView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_menus:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.btn_close_right_sideslip_layout:

                //START、END对应布局文件中的layout_gravity属性
                drawerLayout.closeDrawer(GravityCompat.END);    //关闭右侧滑动布局
                drawerLayout.openDrawer(GravityCompat.START);   //打开左侧滑动布局
                break;
        }
    }
}
