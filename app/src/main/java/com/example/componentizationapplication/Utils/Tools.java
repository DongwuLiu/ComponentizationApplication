package com.example.componentizationapplication.Utils;

import android.widget.Toast;

import com.example.componentizationapplication.application.MyApplication;

/**
 * @Package: com.example.componentizationapplication.Utils
 * @ClassName: Tools
 * @Description: java类作用描述
 * @CreateDate: 2020/7/24 16:28
 * @UpdateDate: 2020/7/24 16:28
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class Tools {
    public static void showToast(String msg) {
        Toast.makeText(MyApplication.getInstance(), msg, Toast.LENGTH_SHORT).show();
    }
}
