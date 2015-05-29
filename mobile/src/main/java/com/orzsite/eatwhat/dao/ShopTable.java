package com.orzsite.eatwhat.dao;

import android.database.Cursor;

import com.orzsite.eatwhat.bean.Shop;

/**
 * Created by Jimmy on 15/5/30.
 */
public class ShopTable {
    public static final String TABLE = "shop";
    public static final String SHOP_ID = "shop_id";
    public static final String SHOP_NAME = "shop_name";

    public static Shop cursorToShop(Cursor c) {
        Shop shop = new Shop();

        return shop;
    }
}
