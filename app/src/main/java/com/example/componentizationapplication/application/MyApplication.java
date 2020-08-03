package com.example.componentizationapplication.application;

import android.app.Application;
import android.util.Log;

/**
 * @Package: com.example.componentizationapplication.application
 * @ClassName: MyApplication
 * @Description: java类作用描述
 * @CreateDate: 2020/7/1 9:33
 * @UpdateDate: 2020/7/1 9:33
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MyApplication extends Application {
    private static final String TAG = "MyApplication";
    private int num;
    private static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        Log.d(TAG, "onCreate: MyApplication is creating");
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public static MyApplication getInstance() {
        return myApplication;
    }
}
