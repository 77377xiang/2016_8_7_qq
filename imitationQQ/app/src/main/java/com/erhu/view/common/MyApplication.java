package com.erhu.view.common;

import android.app.Application;

import com.erhu.view.util.ImageUtil;

/**
 * Created by Administrator on 2016/6/9.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //以下只可以选择一个、第一个为系统默认，第二个 是自己定义的

       //ImageUtil.initConfig(getApplicationContext());
        ImageUtil.initConfigdefult(getApplicationContext());
    }
}
