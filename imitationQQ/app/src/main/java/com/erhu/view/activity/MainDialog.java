package com.erhu.view.activity;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.administrator.imitationqq.R;

/**
 * Created by Administrator on 2016/6/12.
 */
public class MainDialog extends Dialog {
    Dialog dialog;
    TextView leftTv, bettomTv;

    public MainDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//让dialog 显示没有表题，没有标题下的一条线
        dialog = new Dialog(getContext());
        Window window = dialog.getWindow();
        View view = LayoutInflater.from(context).inflate(R.layout.acivity_load, null);
        leftTv = (TextView) view.findViewById(R.id.left);
        bettomTv = (TextView) view.findViewById(R.id.bettom);
        window.setContentView(view);
    }

    public void setText(int type, String string) {
        if (type == 1) {
            leftTv.setVisibility(View.VISIBLE);
            leftTv.setText(string);
        } else if (type == 2) {
            bettomTv.setVisibility(View.VISIBLE);
            bettomTv.setText(string);
        } else {
            leftTv.setVisibility(View.VISIBLE);
            leftTv.setText("正在加载中，你输入的TYPE有误");
        }
    }

    public void setText(int type) {
        if (type == 1) {
            leftTv.setVisibility(View.VISIBLE);
            leftTv.setText("正在加载中，左边显示");
        } else if (type == 2) {
            bettomTv.setVisibility(View.VISIBLE);
            bettomTv.setText("正在加载中，上边显示");
        } else {
            leftTv.setVisibility(View.VISIBLE);
            leftTv.setText("正在加载中，你输入的TYPE有误");
        }
    }

    public void setText(String string) {
        leftTv.setVisibility(View.VISIBLE);
        leftTv.setText("默认左边显示");
    }

    public void showDialog() {
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    public void disDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

}
