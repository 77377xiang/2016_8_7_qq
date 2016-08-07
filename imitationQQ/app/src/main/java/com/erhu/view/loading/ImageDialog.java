package com.erhu.view.loading;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;

import com.example.administrator.imitationqq.R;

public class ImageDialog extends Dialog implements View.OnClickListener {
    ButtonOnClick listener;

    public ImageDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//没有这句话会有一条杠
        setContentView(R.layout.activity_headportrait);
        findViewById(R.id.photograph).setOnClickListener(this);
        findViewById(R.id.uploading).setOnClickListener(this);
    }

    public interface ButtonOnClick {
        void photo();

        void upload();
    }

    public void setListener(ButtonOnClick listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.photograph:
                listener.photo();//获得接口里的方法
                break;
            case R.id.uploading:
                listener.upload();
                break;
        }
    }
}

