package com.orzsite.eatwhat.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.orzsite.eatwhat.R;
import com.orzsite.eatwhat.bean.Shop;
import com.orzsite.eatwhat.viewholder.BaseViewHolder;

import java.util.List;

/**
 * Created by Jimmy on 15/5/30.
 */
public class ShopAdapter extends BaseAdapter<Shop, ShopAdapter.ItemViewHolder> {

    public ShopAdapter(Context context, int layoutRes, List<Shop> datas) {
        super(context, layoutRes, datas);
    }
    @Override
    protected ItemViewHolder initView(View convertView) {
        ItemViewHolder holder = new ItemViewHolder(convertView);
        return holder;
    }

    @Override
    protected void fillView(ItemViewHolder itemViewHolder, int position) {
        Shop shop = getItem(position);
        itemViewHolder.getItemView().setText(shop.getName());
    }

    protected class ItemViewHolder extends BaseViewHolder {
        public ItemViewHolder(View view) {
            super(view);
        }

        private TextView itemView;
        public TextView getItemView() {
            if (itemView == null) {
                itemView = (TextView) getViewById(R.id.tv_shop_name);
            }
            return itemView;
        }
    }
}
