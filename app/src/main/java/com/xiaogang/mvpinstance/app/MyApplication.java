package com.xiaogang.mvpinstance.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

/**
 * Created by xiaogang on 2018/8/27.
 */

public class MyApplication extends Application {
    private static MyApplication app;

    public static Context getAppContext() {
        return app;
    }

    public static Resources getAppResources() {
        return app.getResources();
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
