package com.erhu.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.erhu.view.adapter.WelcomedAdapter;
import com.erhu.view.base.ActivityBase;
import com.example.administrator.imitationqq.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/6/11.
 */
public class WelcomeActivity extends ActivityBase {
    View view4;
    @BindView(R.id.pager)
    ViewPager pager;
    private List<View> viewList = new ArrayList<>();
    WelcomedAdapter adapter;

    @Override
    public int getContentViewId() {
        return R.layout.acivity_welcomend;
    }

    @Override
    protected void initViews(Bundle bundle) {
        initData();
        init();
    }

    public void init() {
        adapter = new WelcomedAdapter(viewList);
        pager.setAdapter(adapter);
        fetchData();
    }

    public void fetchData() {
        ImageView view = (ImageView) view4.findViewById(R.id.pager4);
        SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        String bb = sharedPreferences.getString("Name", "");
        if (!bb.equals("") && bb.equals("b")) {
            Intent intent = new Intent(WelcomeActivity.this, FirstAcivity.class);
            startActivity(intent);
            finish();
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, FirstAcivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void initData() {
        View view1 = View.inflate(this, R.layout.pager1, null);
        View view2 = View.inflate(this, R.layout.pager2, null);
        View view3 = View.inflate(this, R.layout.pager3, null);
        view4 = View.inflate(this, R.layout.pager4, null);
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);
    }
}
