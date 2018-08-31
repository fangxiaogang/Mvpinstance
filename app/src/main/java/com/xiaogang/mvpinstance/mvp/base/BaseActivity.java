package com.xiaogang.mvpinstance.mvp.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;



public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    public Context mContext;
    public T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//子类的super.OnCreate必须在setContentView后调用
        mContext = this;
        if (setContentViewId() != 0) {
            setContentView(setContentViewId());
        } else {
            throw new RuntimeException(" you have to setContentViewId");
        }
        createPresenter();
        ButterKnife.bind(this);
        initView();
    }

    /**
     * 初始化方法
     */
    protected void initView() {

    }

    /**
     * 获取contentView 资源id
     */
    public abstract int setContentViewId();

    /**
     * 创建presenter实例
     */
    public abstract void createPresenter();

    /**
     * activity跳转（无参数）
     *
     * @param className
     */
    public void startActivity(Class<?> className) {
        Intent intent = new Intent(mContext, className);
        startActivity(intent);
    }

    /**
     * activity跳转（有参数）
     *
     * @param className
     */
    public void startActivity(Class<?> className, Bundle bundle) {
        Intent intent = new Intent(mContext, className);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();//页面销毁 网络请求同销毁
        }
    }
}
