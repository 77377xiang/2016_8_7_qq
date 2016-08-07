package com.erhu.view.adapter;

import android.content.Context;

import com.erhu.view.data.Pensen;
import com.example.administrator.imitationqq.R;

import java.util.List;

/**
 * Created by Administrator on 2016/6/11.
 */
public class Fiagment_4_Adapter extends CommAdapter<Pensen> {
    public Fiagment_4_Adapter(List<Pensen> t, Context context) {
        super(t, context, R.layout.fiagment4_item);
    }
    @Override
    public void convert(ViewHolder holder, Pensen data) {
        holder.setText(R.id.text, data.getName());
        holder.setText(R.id.text1, data.getAge());
        holder.setText(R.id.text2, data.getHeig());

    }
}
