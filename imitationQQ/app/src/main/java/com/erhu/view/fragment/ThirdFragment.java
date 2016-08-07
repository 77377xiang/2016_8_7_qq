package com.erhu.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.erhu.view.adapter.Fiagment_3_Adapter;
import com.erhu.view.base.FragmentBase;
import com.example.administrator.imitationqq.R;
import com.erhu.view.data.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/6/10.
 */
public class ThirdFragment extends FragmentBase  {
    View view;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    List<User> users = new ArrayList<>();
    Fiagment_3_Adapter adapter;
    String uri1 = "https://img3.doubanio.com/view/photo/photo/public/p2358770224.jpg";
    String uri2 = "https://img3.doubanio.com/view/photo/photo/public/p2351942670.jpg";
    String uri3 = "https://img1.doubanio.com/view/photo/photo/public/p2323036188.jpg";
    @BindView(R.id.list)
    ListView list;

    @Override
    public int getContentViewId() {
        return R.layout.view3;
    }

    @Override
    protected void initViews(Bundle bundle) {
        initData();
        adapter = new Fiagment_3_Adapter(users, getContext());
        list.setAdapter(adapter);

    }
    @OnClick({ R.id.button,R.id.button2})
     void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                User user = new User();
                user.setUri(uri2);
                users.add(0,user);
                adapter.notifyDataSetChanged();
                break;
            case R.id.button2:
                Random random = new Random(users.size());
                int n = random.nextInt(users.size());
                users.remove(n);
                if (n<1){
                    Toast.makeText(getContext(),"图片为空自动加载默认图片",Toast.LENGTH_SHORT).show();
                    User user1 = new User();
                    user1.setUri(uri3);
                    users.add(user1);
                    adapter.notifyDataSetChanged();

                }
                adapter.notifyDataSetChanged();
                break;
        }
    }
    public void initData() {
        User user = new User();
        user.setUri(uri1);
        users.add(user);
    }

}
