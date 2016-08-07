package com.erhu.view.loading;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.imitationqq.R;

public class LoadingDialog extends Dialog {
    TextView textView;
    public LoadingDialog(Context context, int themeResId) {
        super(context, themeResId);
    }
    public LoadingDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = getWindow();
        window.setGravity(Gravity.CENTER);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_view, null);
        setContentView(view);
        textView=(TextView) view.findViewById(R.id.textView);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = ((Activity) context).getWindowManager()
                .getDefaultDisplay().getWidth() * 5 / 6;
        window.setAttributes(params);
    }
    public void setDialogString(String string) {
        if (!string.equals("")){
            textView.setText(string);
        }
    }
}
