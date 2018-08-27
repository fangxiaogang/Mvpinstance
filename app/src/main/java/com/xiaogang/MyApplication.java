package com.xiaogang;

import android.app.Application;

/**
 * Created by xiaogang on 2018/8/27.
 */

public class MyApplication extends Application {
    private static MyApplication app;


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
