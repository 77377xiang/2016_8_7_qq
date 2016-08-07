package com.erhu.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.erhu.view.base.ActivityBase;
import com.example.administrator.imitationqq.R;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends ActivityBase {
    @BindView(R.id.go)
    Button go;
    @BindView(R.id.out)
    Button out;
    @BindView(R.id.register)
    Button register;
    @BindView(R.id.user)
    EditText user;
    @BindView(R.id.password)
    EditText password;
    String users;
    String passwords;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle bundle) {
    }

    public void fetchData() {
        SharedPreferences sharedPreferences = getSharedPreferences("pensen", Context.MODE_PRIVATE);
        String mUsers = sharedPreferences.getString("Ssername", "");
        String mPasswords = sharedPreferences.getString("Password", "");
        String isfrist = sharedPreferences.getString("isfrist", "");
        if (isfrist.equals("")) {
            Toast.makeText(MainActivity.this, "请注册", Toast.LENGTH_SHORT).show();
        } else if (isfrist.equals("isfrist")) {
            users = user.getText().toString().trim();
            passwords = password.getText().toString().trim();
            if ((!mUsers.equals("") && mUsers.equals(users)) && (!mPasswords.equals("") && mPasswords.equals(passwords))) {
                showDialogwithString("正在登录请稍后");
                initTimeStopDialog(3000, MainActivity.this, SecondActivity.class);
            } else {
                Toast.makeText(MainActivity.this, "输入有误或者为空", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @OnClick({R.id.go, R.id.out, R.id.register})
    void Click(View v) {
        switch (v.getId()) {
            case R.id.go:
                fetchData();
                break;
            case R.id.out:
                finish();
                break;
            case R.id.register:
                Intent intent = new Intent(MainActivity.this, RegisterMainAcivity.class);
                startActivity(intent);
                break;
        }
    }
}
