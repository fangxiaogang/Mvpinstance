package com.xiaogang.mvpinstance.net;



import com.xiaogang.mvpinstance.bean.NewsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;



public interface ApiService {


    @GET(Constant.BOOK_CLASSIFY)
    Observable<NewsBean> bookClassify();

}
