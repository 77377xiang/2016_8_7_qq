package com.erhu.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.erhu.view.base.ActivityBase;
import com.example.administrator.imitationqq.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/6/14.
 */
public class InformationActivity extends ActivityBase {
    String Sickname;
    String Password;
    String Ssername;
    String Email;
    @BindView(R.id.registered)
    TextView registered;

    @BindView(R.id.theLogin)
    Button theLogin;

    @Override
    public int getContentViewId() {
        return R.layout.activity_registered;
    }

    @Override
    protected void initViews(Bundle bundle) {
        getInformation();
        registered.setText(
                "昵称：" + Sickname + "\n" + "用户名：" + Ssername + "\n" + "密码：" + Password + "\n" + "邮箱：" + Email + "\n"
        );
    }

    @OnClick({R.id.registered, R.id.theLogin})
    void olivk(View v) {
        switch (v.getId()) {
            case R.id.theLogin:
                showDialogwithString("正在登录请稍后");
                initTimeStopDialog(2000, InformationActivity.this, SecondActivity.class);

                break;
        }
    }

    public void getInformation() {
        SharedPreferences sharedPreferences = getSharedPreferences("pensen", Context.MODE_WORLD_WRITEABLE);
        Sickname = sharedPreferences.getString("Sickname", "");
        Ssername = sharedPreferences.getString("Ssername", "");
        Password = sharedPreferences.getString("Password", "");
        Email = sharedPreferences.getString("Email", "");
    }
}
