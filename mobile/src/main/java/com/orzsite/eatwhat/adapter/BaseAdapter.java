package com.orzsite.eatwhat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orzsite.eatwhat.bean.BaseBean;
import com.orzsite.eatwhat.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jimmy on 15/5/29.
 */
public abstract class BaseAdapter<T extends BaseBean, VH extends BaseViewHolder> extends android.widget.BaseAdapter {

    private Context context;
    private int layoutRes;
    private List<T> datas;
    public BaseAdapter(Context context, int layoutRes, List<T> datas) {
        this.context = context;
        this.layoutRes = layoutRes;
        this.datas = datas;
    }

    @Override
    public final int getCount() {
        return (datas == null) ? 0 :datas.size();
    }

    @Override
    public final T getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public final View getView(int position, View convertView, ViewGroup parent) {
        VH vh = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutRes, parent, false);
            vh = initView(convertView);
            convertView.setTag(vh);
        } else {
            vh = (VH) convertView.getTag();
        }

        fillView(vh, position);
        return convertView;
    }

    protected abstract VH initView(View convertView);
    protected abstract void fillView(VH vh, int position);
}
