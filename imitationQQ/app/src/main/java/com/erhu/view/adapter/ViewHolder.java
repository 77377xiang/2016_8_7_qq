package com.erhu.view.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.erhu.view.util.ImageUtil;

public class ViewHolder {
    public SparseArray<View> views;
    public Context context;
    private View convertView;

    public ViewHolder(Context context, int layoutId, ViewGroup parent) {
        this.views = new SparseArray<>();
        convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        convertView.setTag(this);
    }

    public static ViewHolder get(Context context, View convertView, int position, int layoutId, ViewGroup parent) {
        if (convertView == null) {
            return new ViewHolder(context, layoutId, parent);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            return holder;
        }

    }

    public View getConvertView() {
        return convertView;
    }

    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    public ViewHolder setText(int resId, String str) {
        TextView textView = getView(resId);
        textView.setText(str);
        return this;
    }

    public ViewHolder setImg(int resId, String url) {
        ImageView img = getView(resId);
        ImageUtil.setImg(url, img);
        return this;
    }


    public interface onViewClickListener {
        void click();
    }

    public void setViewOnClickListener(int resId, final onViewClickListener listener) {
        View view = getView(resId);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.click();
            }
        });
    }

}
