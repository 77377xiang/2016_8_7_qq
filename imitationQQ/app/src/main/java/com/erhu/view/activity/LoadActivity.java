package com.erhu.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.erhu.view.base.ActivityBase;
import com.example.administrator.imitationqq.R;

import butterknife.BindView;

public class LoadActivity extends ActivityBase {
    @BindView(R.id.text)
    TextView text;
    @Override
    public int getContentViewId() {
        return R.layout.acivity_first;
    }

    @Override
    protected void initViews(Bundle bundle) {

    }

}
