package com.xiaogang.mvpinstance.utils;




import com.xiaogang.mvpinstance.mvp.base.BaseModel;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * <p>
 * 控制操作线程的辅助类
 */

public class RxTransformer {

    /**
     * 无参数
     *
     * @param <T> 泛型
     * @return 返回Observable
     */
    public static <T> ObservableTransformer<T, T> switchSchedulers(BaseModel baseModel) {
        return upstream -> upstream
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> baseModel.mDisposable.add(disposable))
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
