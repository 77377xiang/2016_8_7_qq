package com.erhu.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.erhu.view.adapter.SecoundApatter;
import com.erhu.view.base.ActivityBase;
import com.erhu.view.fragment.FirstFragment;
import com.erhu.view.fragment.ForthFragment;
import com.erhu.view.fragment.SecondFragment;
import com.erhu.view.fragment.ThirdFragment;
import com.example.administrator.imitationqq.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SecondActivity extends ActivityBase {
    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.iv3)
    ImageView iv3;
    @BindView(R.id.iv4)
    ImageView iv4;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    private List<Fragment> fragments = new ArrayList<>();
    private SecoundApatter fragmentApatter;

    @Override
    public int getContentViewId() {
        return R.layout.acivity_second;
    }

    @Override
    protected void initViews(Bundle bundle) {
        rePlayData();
        initData();
        pagerDefaule();
        fragmentApatter = new SecoundApatter(getSupportFragmentManager(), fragments);
        pager.setAdapter(fragmentApatter);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int arg0) {
                switch (arg0) {
                    case 0:
                        iv1.setImageResource(R.drawable.affinity_a);
                        iv2.setImageResource(R.drawable.pen_b);
                        iv3.setImageResource(R.drawable.umbrella_b);
                        iv4.setImageResource(R.drawable.book_b);
                        tv1.setTextColor(0xffff00ff);
                        tv2.setTextColor(0xffae2eac);
                        tv3.setTextColor(0xffae2eac);
                        tv4.setTextColor(0xffae2eac);

                        break;
                    case 1:
                        iv2.setImageResource(R.drawable.pen_a);
                        iv1.setImageResource(R.drawable.affinity_b);
                        iv3.setImageResource(R.drawable.umbrella_b);
                        iv4.setImageResource(R.drawable.book_b);
                        tv2.setTextColor(0xffff00ff);
                        tv1.setTextColor(0xffae2eac);
                        tv3.setTextColor(0xffae2eac);
                        tv4.setTextColor(0xffae2eac);
                        break;
                    case 2:
                        iv3.setImageResource(R.drawable.umbrella_a);
                        iv1.setImageResource(R.drawable.affinity_b);
                        iv2.setImageResource(R.drawable.pen_b);
                        iv4.setImageResource(R.drawable.book_b);
                        tv3.setTextColor(0xffff00ff);
                        tv1.setTextColor(0xffae2eac);
                        tv2.setTextColor(0xffae2eac);
                        tv4.setTextColor(0xffae2eac);
                        break;
                    case 3:
                        iv4.setImageResource(R.drawable.book_a);
                        iv1.setImageResource(R.drawable.affinity_b);
                        iv2.setImageResource(R.drawable.pen_b);
                        iv3.setImageResource(R.drawable.umbrella_b);
                        tv4.setTextColor(0xffff00ff);
                        tv1.setTextColor(0xffae2eac);
                        tv2.setTextColor(0xffae2eac);
                        tv3.setTextColor(0xffae2eac);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void rePlayData() {
        SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", "b");
        editor.commit();
    }

    public void initData() {
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThirdFragment());
        fragments.add(new ForthFragment());
    }

    @OnClick({R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv1:
                pagerDefaule();
                break;

            case R.id.iv2:
                pager.setCurrentItem(1);
                iv2.setImageResource(R.drawable.pen_a);
                iv1.setImageResource(R.drawable.affinity_b);
                iv3.setImageResource(R.drawable.umbrella_b);
                iv4.setImageResource(R.drawable.book_b);
                tv2.setTextColor(0xffff00ff);
                tv1.setTextColor(0xffae2eac);
                tv3.setTextColor(0xffae2eac);
                tv4.setTextColor(0xffae2eac);
                break;

            case R.id.iv3:
                pager.setCurrentItem(2);
                iv3.setImageResource(R.drawable.umbrella_a);
                iv1.setImageResource(R.drawable.affinity_b);
                iv2.setImageResource(R.drawable.pen_b);
                iv4.setImageResource(R.drawable.book_b);
                tv3.setTextColor(0xffff00ff);
                tv1.setTextColor(0xffae2eac);
                tv2.setTextColor(0xffae2eac);
                tv4.setTextColor(0xffae2eac);
                break;

            case R.id.iv4:
                pager.setCurrentItem(3);
                iv4.setImageResource(R.drawable.book_a);
                iv1.setImageResource(R.drawable.affinity_b);
                iv2.setImageResource(R.drawable.pen_b);
                iv3.setImageResource(R.drawable.umbrella_b);
                tv4.setTextColor(0xffff00ff);
                tv1.setTextColor(0xffae2eac);
                tv2.setTextColor(0xffae2eac);
                tv3.setTextColor(0xffae2eac);
                break;
            case R.id.tv1:
                pager.setCurrentItem(0);
                iv1.setImageResource(R.drawable.affinity_a);
                iv2.setImageResource(R.drawable.pen_b);
                iv3.setImageResource(R.drawable.umbrella_b);
                iv4.setImageResource(R.drawable.book_b);
                tv1.setTextColor(0xffff00ff);
                tv2.setTextColor(0xffae2eac);
                tv3.setTextColor(0xffae2eac);
                tv4.setTextColor(0xffae2eac);
                break;

            case R.id.tv2:
                pager.setCurrentItem(1);
                iv2.setImageResource(R.drawable.pen_a);
                iv1.setImageResource(R.drawable.affinity_b);
                iv3.setImageResource(R.drawable.umbrella_b);
                iv4.setImageResource(R.drawable.book_b);
                tv2.setTextColor(0xffff00ff);
                tv1.setTextColor(0xffae2eac);
                tv3.setTextColor(0xffae2eac);
                tv4.setTextColor(0xffae2eac);
                break;

            case R.id.tv3:
                pager.setCurrentItem(2);
                iv3.setImageResource(R.drawable.umbrella_a);
                iv1.setImageResource(R.drawable.affinity_b);
                iv2.setImageResource(R.drawable.pen_b);
                iv4.setImageResource(R.drawable.book_b);
                tv3.setTextColor(0xffff00ff);
                tv1.setTextColor(0xffae2eac);
                tv2.setTextColor(0xffae2eac);
                tv4.setTextColor(0xffae2eac);
                break;

            case R.id.tv4:
                pager.setCurrentItem(3);
                iv4.setImageResource(R.drawable.book_a);
                iv1.setImageResource(R.drawable.affinity_b);
                iv2.setImageResource(R.drawable.pen_b);
                iv3.setImageResource(R.drawable.umbrella_b);
                tv4.setTextColor(0xffff00ff);
                tv1.setTextColor(0xffae2eac);
                tv2.setTextColor(0xffae2eac);
                tv3.setTextColor(0xffae2eac);
                break;
        }
    }

    public void pagerDefaule() {
        pager.setCurrentItem(0);
        iv1.setImageResource(R.drawable.affinity_a);
        iv2.setImageResource(R.drawable.pen_b);
        iv3.setImageResource(R.drawable.umbrella_b);
        iv4.setImageResource(R.drawable.book_b);
        tv1.setTextColor(0xffff00ff);
        tv2.setTextColor(0xffae2eac);
        tv3.setTextColor(0xffae2eac);
        tv4.setTextColor(0xffae2eac);
    }
}
