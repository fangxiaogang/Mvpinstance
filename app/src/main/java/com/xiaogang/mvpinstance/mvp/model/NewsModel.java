package com.xiaogang.mvpinstance.mvp.model;


import com.xiaogang.mvpinstance.mvp.base.BaseModel;
import com.xiaogang.mvpinstance.utils.RxObservable;
import com.xiaogang.mvpinstance.utils.RxTransformer;

/**
 *
 * model层用于处理数据,例：网络数据 数据库缓存数据 在此类处理以后返回给P层
 */

public class NewsModel extends BaseModel {

    public void mBook(RxObservable rxObservable) {
        apiService()
                .bookClassify()
                .compose(RxTransformer.switchSchedulers(this))
                .subscribe(rxObservable);
    }

}

