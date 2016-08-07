package com.erhu.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.erhu.view.base.ActivityBase;
import com.erhu.view.loading.RegisteredDialog;
import com.example.administrator.imitationqq.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/6/13.
 */
public class RegisterMainAcivity extends ActivityBase {
    @BindView(R.id.nickname)
    EditText nickname;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.confirmPassword)
    EditText confirmPassword;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.confirm)
    Button confirm;
    @BindView(R.id.quit)
    Button quit;

    @Override
    public int getContentViewId() {
        return R.layout.acivity_main_register;
    }

    @Override
    protected void initViews(Bundle bundle) {
    }

    @OnClick({R.id.confirm, R.id.quit})
    void click(View v) {
        switch (v.getId()) {
            case R.id.confirm:
                confirm();
                break;
            case R.id.quit:
                finish();
                break;
        }
    }

    public void confirm() {
        String mSickname = nickname.getText().toString().trim();
        String mUsername = username.getText().toString().trim();
        String mPassword = password.getText().toString().trim();
        String mConfirmPassword = confirmPassword.getText().toString().trim();
        String mEmail = email.getText().toString().trim();
        if ((!mSickname.equals("")) && (!mUsername.equals("")) && (!mPassword.equals("")) && (!mConfirmPassword.equals("")) && (!mEmail.equals("")) && (mPassword.equals(mConfirmPassword))) {
            SharedPreferences sharedPreferences = getSharedPreferences("pensen", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Sickname", mSickname);
            editor.putString("Ssername", mUsername);
            editor.putString("Password", mPassword);
            editor.putString("ConfirmPassword", mConfirmPassword);
            editor.putString("Email", mEmail);
            editor.putString("isfrist", "isfrist");
            editor.commit();
            showDialogwithString("请稍后");
            initIntent(2000,RegisterMainAcivity.this,InformationActivity.class);
        } else {
            Toast.makeText(RegisterMainAcivity.this, "输入有误", Toast.LENGTH_LONG).show();
        }

    }
}
