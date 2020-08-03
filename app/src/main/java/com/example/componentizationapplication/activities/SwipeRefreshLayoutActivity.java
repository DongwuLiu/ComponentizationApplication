package com.example.componentizationapplication.activities;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import com.example.componentizationapplication.R;
import com.example.componentizationapplication.Utils.Tools;
import com.example.componentizationapplication.views.TopTitleView;

import java.util.ArrayList;
import java.util.List;

public class SwipeRefreshLayoutActivity extends BaseActivity {
    private TopTitleView topTitleView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private ScrollView mScrollView;
    private ArrayAdapter adapter;
    private List<String> listData = new ArrayList<>();
    private int position;   //用于记录上次新增的最后一条数据编号

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.app_activity_swipe_refresh_layout;
    }

    @Override
    public void initView() {
        topTitleView = findViewById(R.id.app_top_layout_view);

        for (int i = 0; i < 5; i++) {
            listData.add("初始化的第" + i + "条数据");
        }
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);

        //设置下拉刷新按钮颜色:
        // setColorSchemeResources方法入参为：色值id;
        // setColorSchemeColors方法入参为：色值（#2C40C3），也可以通过getResources().getColor(色值id)方式
//        swipeRefreshLayout.setColorSchemeResources(R.color.app_swipe_refresh_color_start, R.color.app_swipe_refresh_color_middle, R.color.app_swipe_refresh_color_end);
//        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#2C40C3"), Color.parseColor("#E8C70D"), Color.parseColor("#F40521"));
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.app_swipe_refresh_color_start), getResources().getColor(R.color.app_swipe_refresh_color_middle), getResources().getColor(R.color.app_swipe_refresh_color_end));

        //设置刷新按钮的背景颜色，默认为白色；
//        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.parseColor("#F3938A"));
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.app_swipe_refresh_background_color);

        swipeRefreshLayout.setOnRefreshListener(onRefreshListener);
        listView = findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);
        listView.setOnScrollListener(scrollListener);

        //解决ScrollView与SwipeRefreshLayout滑动冲突问题方式
        if (mScrollView != null) {
            mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                @Override
                public void onScrollChanged() {
                    //当mScrollView的垂直滑动距离为0时才触发swipeRefreshLayout的刷新事件，否则视为mScrollView的向上滑动
                    swipeRefreshLayout.setEnabled(mScrollView.getScaleY() == 0);
                }
            });
        }
    }

    @Override
    public void setTopTitle() {
        topTitleView.setTitleName("SwipeRefresh布局");
        topTitleView.isShowLeftTopMenus(false);
    }

    private SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            //判断当前swipeRefreshLayout是否正在刷新
            if (swipeRefreshLayout.isRefreshing()) {
                Tools.showToast("swipe组件刷新中...");
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //执行延迟1s模拟网络请求
                    position = adapter.getCount();
                    for (int i = position; i < position + 5; i++) {
                        adapter.add("新请求的第" + i + "条数据");
                    }
                    //设置刷新状态：true--刷新，false--取消刷新
                    //不设置此行代码，页面会一直处于刷新状态，小圆圈不消失
                    swipeRefreshLayout.setRefreshing(false);

                    if (!swipeRefreshLayout.isRefreshing()) {
                        Tools.showToast("swipe组件刷新完成！");
                    }
                }
            }, 1000);
        }
    };

    //解决SwipeRefreshLayout下拉刷新手势与ListView向下滑动手势的滑动冲突
    private AbsListView.OnScrollListener scrollListener = new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            //当屏幕上方显示的数据是第0条数据时才触发swipeRefreshLayout的刷新事件，否则视为ListView的向上滑动
            swipeRefreshLayout.setEnabled(firstVisibleItem == 0);
        }
    };
}
