package com.example.componentizationapplication.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.componentizationapplication.R;

import androidx.annotation.Nullable;

import static android.content.ContentValues.TAG;

/**
 * @Package: com.example.componentizationapplication
 * @ClassName: TopTitleView
 * @Description: java类作用描述
 * @CreateDate: 2020/7/25 9:49
 * @UpdateDate: 2020/7/25 9:49
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class TopTitleView extends LinearLayout {
    protected Context mContext;
    private ImageView leftMenuButton;
    private TextView mainTitleView;

    public TopTitleView(Context context) {
        super(context);
        this.mContext = context;
        initView();
        Log.d(TAG, "TopTitleView: first function");
    }

    public TopTitleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView();
        Log.d(TAG, "TopTitleView: second function");
    }

    public TopTitleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
        Log.d(TAG, "TopTitleView: thrid function");
    }

    private void initView() {
        View topTitleView = LayoutInflater.from(mContext).inflate(R.layout.app_top_view_layout, this);

        leftMenuButton = topTitleView.findViewById(R.id.top_menus);
        mainTitleView = topTitleView.findViewById(R.id.top_Title);
    }
}
