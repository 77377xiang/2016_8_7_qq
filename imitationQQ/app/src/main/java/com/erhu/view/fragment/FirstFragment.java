package com.erhu.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.erhu.view.activity.ImageActivity;
import com.erhu.view.base.FragmentBase;
import com.example.administrator.imitationqq.R;

import butterknife.BindView;
import butterknife.OnClick;

public class FirstFragment extends FragmentBase {
    @BindView(R.id.image)
    ImageView image;

    @Override
    public int getContentViewId() {
        return R.layout.view1;
    }

    @Override
    protected void initViews(Bundle bundle) {

    }

    @OnClick({R.id.image})
    void click(View v) {
        switch (v.getId()) {
            case R.id.image:
                Intent intent = new Intent(getActivity(), ImageActivity.class);
                startActivity(intent);
                break;
        }
    }

}
