package com.xiaogang.mvpinstance.mvp.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xiaogang.mvpinstance.R;
import com.xiaogang.mvpinstance.bean.BookBean;
import com.xiaogang.mvpinstance.mvp.base.BaseActivity;
import com.xiaogang.mvpinstance.mvp.contract.CBook;
import com.xiaogang.mvpinstance.mvp.presenter.PBookImpl;


/**
 * Created by Liang_Lu on 2017/12/21.
 * V层 用于数据和页面UI展示（Fragment Dialog 同理）
 */

public class BookActivity extends BaseActivity<PBookImpl> implements CBook.IVBook {

    private TextView mTv;
    private Button mBtn;

    @Override
    protected void initView() {
        super.initView();
        mBtn = findViewById(R.id.btn);
        mTv = findViewById(R.id.tv);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.pBook();
            }
        });

    }

    @Override
    public int setContentViewId() {
        return R.layout.activity_book;
    }

    @Override
    public void createPresenter() {
        mPresenter = new PBookImpl(mContext, this);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }



    @Override
    public void vBookSuccess(BookBean bean) {
        mTv.setText("网络请求成功");
    }

    @Override
    public void vBookError(String reason) {
        mTv.setText(reason);
    }

}
