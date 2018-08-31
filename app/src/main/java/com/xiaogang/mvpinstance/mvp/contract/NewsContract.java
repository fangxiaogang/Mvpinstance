package com.xiaogang.mvpinstance.mvp.contract;


import com.xiaogang.mvpinstance.bean.NewsBean;
import com.xiaogang.mvpinstance.mvp.base.IBasePresenter;
import com.xiaogang.mvpinstance.mvp.base.IBaseView;



public interface NewsContract {

    interface IPBook extends IBasePresenter {

        void pBook();
    }

    interface IVBook extends IBaseView {

        void vBookSuccess(NewsBean bean);

        void vBookError(String reason);

    }
}
