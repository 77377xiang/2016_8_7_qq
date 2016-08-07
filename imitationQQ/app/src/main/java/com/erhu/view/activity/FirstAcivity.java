package com.erhu.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.erhu.view.base.ActivityBase;
import com.example.administrator.imitationqq.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/6/10.
 */
public class FirstAcivity extends ActivityBase {
    @Override
    public int getContentViewId() {
        return R.layout.acivity_first;
    }

    @Override
    protected void initViews(Bundle bundle) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(FirstAcivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 500);

    }
}
