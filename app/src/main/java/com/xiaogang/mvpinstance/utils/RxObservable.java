package com.xiaogang.mvpinstance.utils;


import com.xiaogang.mvpinstance.bean.NewsBean;
import com.xiaogang.mvpinstance.mvp.base.IModelCallBack;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;



public abstract class RxObservable<T> implements Observer<T>, IModelCallBack<T> {

    public RxObservable() {
    }


    @Override
    public void onSubscribe(Disposable d) {
        LogUtils.print("RxObservable", d + "");
    }

    @Override
    public void onError(Throwable e) {
        String error = RxException.handleException(e).getMessage();
        ToastUtils.show(error);
        this.onFail(error);
    }


    @Override
    public void onNext(T value) {
        //可以根据需求对code统一处理
        this.onSuccess(value);
    }


    @Override
    public void onComplete() {
    }

    public abstract void onSuccess(NewsBean bean);

    public abstract void onFail(String reason);
}
