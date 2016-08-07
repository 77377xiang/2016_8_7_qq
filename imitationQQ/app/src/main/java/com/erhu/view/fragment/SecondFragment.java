package com.erhu.view.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.erhu.view.adapter.Fiagment_2_Adapter;
import com.erhu.view.base.FragmentBase;
import com.example.administrator.imitationqq.R;
import com.erhu.view.data.User;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
public class SecondFragment extends FragmentBase {
    @BindView(R.id.list)
    ListView list;
    List<User> users = new ArrayList<>();
    Fiagment_2_Adapter adapter;
    String uri1 = "https://img3.doubanio.com/view/photo/photo/public/p2358770224.jpg";
    String uri2 = "https://img3.doubanio.com/view/photo/photo/public/p2351942670.jpg";
    String uri3 = "https://img1.doubanio.com/view/photo/photo/public/p2323036188.jpg";
    @Override
    public int getContentViewId() {
        return R.layout.view2;
    }
    @Override
    protected void initViews(Bundle bundle) {
        initData();
        adapter = new Fiagment_2_Adapter(users, getContext());
        list.setAdapter(adapter);
    }
    public void initData() {
        User user = new User();
        user.setUri(uri1);
        users.add(user);
        User user1 = new User();
        user1.setUri(uri2);
        users.add(user1);
        User user2 = new User();
        user2.setUri(uri3);
        users.add(user2);
        User user3 = new User();
        users.add(user3);
    }
}
