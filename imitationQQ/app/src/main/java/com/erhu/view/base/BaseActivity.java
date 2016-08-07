package com.erhu.view.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/6/12.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView();
        afterSetContentView();
        findViews();
        initData();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    /**
     * 设置初始化的页面
     */
    public abstract void setContentView();

    /**
     * 设置初始化页面后
     */
    public void afterSetContentView() {

    }

    /**
     * 查找页面中的控件
     */
    public abstract void findViews();

    /**
     * 初始化数据
     */
    public abstract void initData();

}
