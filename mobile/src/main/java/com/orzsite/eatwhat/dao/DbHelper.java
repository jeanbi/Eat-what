package com.orzsite.eatwhat.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.orzsite.eatwhat.bean.Food;
import com.orzsite.eatwhat.bean.Shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jimmy on 15/5/30.
 */
public class DbHelper {

    private Context context;
    private DatabaseUtils utils = null;
    public DbHelper(Context context) {
        this.context = context;
        utils = new DatabaseUtils(context);
    }

    /**
     * 列出所有的商店
     * 
     * @return
     */
    public List<Shop> queryShopList() {
        List<Shop> shops = new ArrayList<>();

        SQLiteDatabase db = utils.getWritableDatabase();

        return shops;
    }

    /**
     * 列出所有的食品
     *
     * @return
     */
    public List<Food> queryFoodList() {
        List<Food> foods = new ArrayList<>();
        return foods;
    }

    /**
     * 根据商店ID显示出与之相关的食品列表
     *
     * @param shopId
     * @return
     */
    public List<Food> queryFoodList(int shopId) {
        List<Food> foods = new ArrayList<>();
        return foods;
    }

    /**
     * 保存食品信息
     * @param food
     */
    public void saveFood(Food food) {

    }

    /**
     * 保存商店信息
     * @param shop
     */
    public void saveShop(Shop shop) {

    }

}
