package com.xiaogang.mvpinstance.mvp.base;

/**
 * Created by xiaogang on 2018/8/20.
 */

public interface IModelCallBack<T> {

    void onSuccess(T t);

    void onFail(String reason);
}
