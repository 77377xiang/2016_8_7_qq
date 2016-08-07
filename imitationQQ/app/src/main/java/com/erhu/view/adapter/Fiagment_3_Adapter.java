package com.erhu.view.adapter;

import android.content.Context;

import com.example.administrator.imitationqq.R;
import com.erhu.view.data.User;

import java.util.List;

/**
 * Created by Administrator on 2016/6/11.
 */
public class Fiagment_3_Adapter extends CommAdapter<User> {
    public Fiagment_3_Adapter(List<User> t, Context context) {
        super(t, context, R.layout.fiagment2_3_list_item);
    }

    @Override
    public void convert(ViewHolder holder, User user) {
        holder.setImg(R.id.image, user.getUri());
        holder.setViewOnClickListener(R.id.image, new ViewHolder.onViewClickListener() {
            @Override
            public void click() {


            }
        });
    }
}
