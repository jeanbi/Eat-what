package com.orzsite.eatwhat.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.orzsite.eatwhat.R;
import com.orzsite.eatwhat.bean.Food;
import com.orzsite.eatwhat.bean.Shop;
import com.orzsite.eatwhat.viewholder.BaseViewHolder;

import java.util.List;

/**
 * copyright: Copyright(c) Jimmy Xue(jeanbi@gmail.com). All rights reserved.
 * license: GNU General Public License 2.0
 * Created by Jimmy on 15/5/30.
 */
public class FoodAdapter extends BaseAdapter<Food, FoodAdapter.ItemViewHolder> {

    public FoodAdapter(Context context, int layoutRes, List<Food> datas) {
        super(context, layoutRes, datas);
    }
    @Override
    protected ItemViewHolder initView(View convertView) {
        ItemViewHolder holder = new ItemViewHolder(convertView);
        return holder;
    }

    @Override
    protected void fillView(ItemViewHolder itemViewHolder, int position) {
        Food food = getItem(position);
        itemViewHolder.getItemView().setText(food.getName());
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
