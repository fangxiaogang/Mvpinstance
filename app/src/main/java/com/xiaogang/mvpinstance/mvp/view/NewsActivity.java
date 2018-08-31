package com.xiaogang.mvpinstance.mvp.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xiaogang.mvpinstance.R;
import com.xiaogang.mvpinstance.bean.NewsBean;
import com.xiaogang.mvpinstance.mvp.base.BaseActivity;
import com.xiaogang.mvpinstance.mvp.contract.NewsContract;
import com.xiaogang.mvpinstance.mvp.presenter.NewsPresenter;


/**
 *
 * V层 用于数据和页面UI展示（Fragment Dialog 同理）
 */

public class NewsActivity extends BaseActivity<NewsPresenter> implements NewsContract.IVBook {

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
        mPresenter = new NewsPresenter(mContext, this);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }



    @Override
    public void vBookSuccess(NewsBean bean) {
        mTv.setText("测试数据 bean:    " + bean.getStories().toString());
    }

    @Override
    public void vBookError(String reason) {
        mTv.setText(reason);
    }

}
