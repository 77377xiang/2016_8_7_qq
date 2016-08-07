package com.erhu.view.loading;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.imitationqq.R;

/**
 * Created by Administrator on 2016/6/14.
 */
public class RegisteredDialog extends Dialog {
    TextView registeredTv;
    Button landingBtn;

    public RegisteredDialog(Context context, int themeResId) {
        super(context, themeResId);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = getWindow();
        window.setGravity(Gravity.CENTER);
        View view = LayoutInflater.from(context).inflate(R.layout.activity_registered, null);
        setContentView(view);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = ((Activity) context).getWindowManager().getDefaultDisplay().getWidth() * 5 / 6;
        window.setAttributes(params);
        registeredTv = (TextView) view.findViewById(R.id.registered);

        registeredTv.setText("张山"+"\n"+"李四"+"\n"+"王五");
    }

    public RegisteredDialog(Context context) {
        this(context, 0);
    }
}
