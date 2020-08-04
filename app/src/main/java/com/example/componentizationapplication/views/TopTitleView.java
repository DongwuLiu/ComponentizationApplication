package com.example.componentizationapplication.views;

import android.app.Activity;
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
public class TopTitleView extends LinearLayout implements View.OnClickListener {
    protected Context mContext;
    private ImageView leftMenuButton;
    private ImageView leftBackButton;
    private TextView mainTitleView; //单标题
    private LinearLayout doubleTitleLayout; //双标题
    private TextView doubleMainTitleView;   //双标题-主标题
    private TextView doubleSubTitleView;    //双标题-副标题
    private TopTitleClickListener topTitleClickListener;

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

        leftMenuButton = topTitleView.findViewById(R.id.left_top_menus);
        leftBackButton = topTitleView.findViewById(R.id.left_top_back);
        mainTitleView = topTitleView.findViewById(R.id.top_title);
        doubleTitleLayout = topTitleView.findViewById(R.id.lin_double_title);
        doubleMainTitleView = topTitleView.findViewById(R.id.double_main_top_title);
        doubleSubTitleView = topTitleView.findViewById(R.id.double_sub_top_title);

        leftMenuButton.setOnClickListener(this);
        leftBackButton.setOnClickListener(this);
    }

    public void isShowLeftTopMenus(boolean isShow) {
        if (isShow) {
            if (leftBackButton.getVisibility() == VISIBLE) {
                leftBackButton.setVisibility(GONE);
            }
            leftMenuButton.setVisibility(VISIBLE);
        } else {
            leftMenuButton.setVisibility(GONE);
        }
    }

    public void isShowLeftTopBack(boolean isShow) {
        if (isShow) {
            if (leftMenuButton.getVisibility() == VISIBLE) {
                leftMenuButton.setVisibility(GONE);
            }
            leftBackButton.setVisibility(VISIBLE);
        } else {
            leftBackButton.setVisibility(GONE);
        }
    }

    /**
     * 设置主标题名称
     */
    public void setTitleName(String titleName) {
        mainTitleView.setVisibility(VISIBLE);
        doubleTitleLayout.setVisibility(GONE);
        mainTitleView.setText(titleName);
    }

    /**
     * 设置双标题
     */
    public void setDoubleTitleview(String mainTitleName, String subTitleName) {
        mainTitleView.setVisibility(GONE);
        doubleTitleLayout.setVisibility(VISIBLE);

        doubleMainTitleView.setText(mainTitleName);
        doubleSubTitleView.setText(subTitleName);
    }

    /**
     * 设置双标题-主标题
     */
    public void setDoubleMainTitleView(String mainTitleName) {
        doubleMainTitleView.setText(mainTitleName);
    }

    /**
     * 设置双标题-副标题
     */
    public void setDoubleSubTitleView(String subTitleName) {
        doubleSubTitleView.setText(subTitleName);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_top_menus:
                if (topTitleClickListener != null) {
                    topTitleClickListener.onLeftTitleClick();
                }
                break;
            case R.id.left_top_back:
                ((Activity)mContext).finish();
                break;
        }
    }

    public void setOnClickListener(TopTitleClickListener topTitleClickListener) {
        this.topTitleClickListener = topTitleClickListener;
    }

    /**
     * 标题按钮点击实现方法
     */
    public interface TopTitleClickListener {
        void onLeftTitleClick();
    }
}
