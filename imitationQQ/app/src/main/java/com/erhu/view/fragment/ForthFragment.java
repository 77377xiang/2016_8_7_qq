package com.erhu.view.fragment;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;
import android.widget.Toast;
import com.erhu.view.adapter.Fiagment_4_Adapter;
import com.erhu.view.base.FragmentBase;
import com.erhu.view.data.Pensen;
import com.erhu.view.pulllistview.PullToRefreshBase;
import com.erhu.view.pulllistview.PullToRefreshListView;
import com.example.administrator.imitationqq.R;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
public class ForthFragment extends FragmentBase {
    List<Pensen> pensens = new ArrayList<>();
    Fiagment_4_Adapter adapter;
    @BindView(R.id.listload)
    PullToRefreshListView listload;
    @Override
    public int getContentViewId() {
        return R.layout.fiagment4_list;
    }
    @Override
    protected void initViews(Bundle bundle) {
        initData();
        adapter = new Fiagment_4_Adapter(pensens, getContext());
        listload.setAdapter(adapter);
        //刷新
        listload.setMode(PullToRefreshBase.Mode.BOTH);
        listload.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                initData3();
                initSTOP();
            }
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                initData2();
                initSTOP();
            }
        });
    }

    public void initData() {
        for (int i = 0; i < 10; i++) {
            Pensen pensen = new Pensen();
            pensen.setName("小明");
            pensen.setAge("15岁");
            pensen.setHeig("170cm");
            pensens.add(pensen);
        }
    }

    public void initData2() {
        for (int i = 0; i < 3; i++) {
            Pensen pensen = new Pensen();
            pensen.setName("我是加载数据");
            pensen.setAge("30岁");
            pensen.setHeig("180cm");
            pensens.add(pensen);
        }

    }

    public void initData3() {
        pensens.clear();
        Pensen pensen1 = new Pensen();
        pensen1.setName("我是刷新数据");
        pensen1.setAge("40岁");
        pensen1.setHeig("190cm");
        pensens.add(pensen1);
    }

    public void initSTOP() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listload.onRefreshComplete();
                Toast.makeText(getContext(), "aa", Toast.LENGTH_LONG).show();
            }
        }, 2000);

    }
}

