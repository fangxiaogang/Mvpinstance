package com.xiaogang.mvpinstance.mvp.base;


import com.xiaogang.mvpinstance.net.RetrofitManager;
import com.xiaogang.mvpinstance.net.ApiService;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseModel {


    public CompositeDisposable mDisposable = new CompositeDisposable();

    /**
     * 初始化调用网络请求
     * @return
     */
    public ApiService apiService() {
        return RetrofitManager.createApi().create(ApiService.class);
    }
    /**
     * 取消网络请求
     */
    public void onDestroy() {

        if (mDisposable != null) {
            mDisposable.dispose();
            mDisposable.clear();
        }
    }
}
