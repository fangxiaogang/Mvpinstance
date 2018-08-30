package com.xiaogang.mvpinstance.mvp.base;


import com.xiaogang.mvpinstance.net.DevMvpApi;
import com.xiaogang.mvpinstance.net.DevMvpService;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseModel {


    public CompositeDisposable mDisposable = new CompositeDisposable();

    /**
     * 初始化调用网络请求
     * @return
     */
    public DevMvpService apiService() {
        return DevMvpApi.createApi().create(DevMvpService.class);
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
