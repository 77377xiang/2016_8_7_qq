package com.erhu.view.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.erhu.view.loading.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class ActivityBase extends AppCompatActivity {
    LoadingDialog loadingDialog;

    public abstract int getContentViewId();

    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadingDialog = new LoadingDialog(ActivityBase.this);
        setContentView(getContentViewId());
        unbinder = ButterKnife.bind(this);
        initViews(savedInstanceState);
    }


    protected abstract void initViews(Bundle bundle);

    /**
     * 解除绑定
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    //显示对话框
    public void showDialog() {
        if (loadingDialog != null && !loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    //显示对话框并显示有字体
    public void showDialogwithString(String string) {
        if (loadingDialog != null && !loadingDialog.isShowing()) {
            loadingDialog.setDialogString(string);
            loadingDialog.show();
        }
    }

    // 关闭对话框
    public void dissDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    //时间控制对话框的关闭并跳转页面
    public void initTimeStopDialog(int time, final Context oneActivity, final Class twoActivity) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingDialog.dismiss();
                Intent intent = new Intent(oneActivity, twoActivity);
                startActivity(intent);
            }
        }, time);
    }
    //时间控制跳转
    public  void initIntent(int time, final Context oneActivity, final Class twoActivity){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(oneActivity, twoActivity);
                startActivity(intent);
            }
        }, time);
    }
}
