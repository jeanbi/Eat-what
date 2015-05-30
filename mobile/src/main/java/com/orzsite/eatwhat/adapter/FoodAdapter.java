package com.orzsite.eatwhat.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.orzsite.eatwhat.R;
import com.orzsite.eatwhat.bean.Food;
import com.orzsite.eatwhat.viewholder.BaseViewHolder;

import java.util.List;

/**
 * copyright: Copyright(c) Jimmy Xue(jeanbi@gmail.com). All rights reserved.
 * license: GNU General Public License 2.0
 * Created by Jimmy on 15/5/30.
 */
public class FoodAdapter extends BaseAdapter<Food, FoodAdapter.ItemViewHolder> {

    private Context context;

    public FoodAdapter(Context context, int layoutRes, List<Food> datas) {
        super(context, layoutRes, datas);
        this.context = context;
    }

    @Override
    protected ItemViewHolder initView(View convertView) {
        ItemViewHolder holder = new ItemViewHolder(convertView);
        return holder;
    }

    @Override
    protected void fillView(ItemViewHolder itemViewHolder, int position) {
        Food food = getItem(position);
        itemViewHolder.getItemShop().setText(context.getString(R.string.shop_format, food.getShop().getName()));
        itemViewHolder.getItemName().setText(food.getName());
        itemViewHolder.getItemPrice().setText(context.getString(R.string.price_format, food.getPrice()));
    }

    protected class ItemViewHolder extends BaseViewHolder {
        private TextView itemShop;
        private TextView itemName;
        private TextView itemPrice;

        public ItemViewHolder(View view) {
            super(view);
        }

        public TextView getItemShop() {
            if (itemShop == null) {
                itemShop = (TextView) getViewById(R.id.tv_shop_name);
            }
            return itemShop;
        }

        public TextView getItemName() {
            if (itemName == null) {
                itemName = (TextView) getViewById(R.id.tv_food_name);
            }
            return itemName;
        }

        public TextView getItemPrice() {
            if (itemPrice == null) {
                itemPrice = (TextView) getViewById(R.id.tv_food_price);
            }
            return itemPrice;
        }
    }
}
