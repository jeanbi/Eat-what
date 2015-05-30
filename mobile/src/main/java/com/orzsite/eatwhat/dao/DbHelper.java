package com.orzsite.eatwhat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.orzsite.eatwhat.bean.Food;
import com.orzsite.eatwhat.bean.Shop;

import java.util.ArrayList;
import java.util.List;

/**
 * copyright: Copyright(c) Jimmy Xue(jeanbi@gmail.com). All rights reserved.
 * license: GNU General Public License 2.0
 * Created by Jimmy on 15/5/30.
 */
public class DbHelper {

    public final static int INSERT_ERROR = -1;

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

        Cursor c = db.query(ShopTable.TABLE, null, null, null, null, null, null);
        if (c != null) {
            int count = c.getCount();
            if (count > 0) {
                c.moveToFirst();
                Shop shop = null;

                for (int i = 0; i < count; i++) {
                    shop = new Shop();
                    shop.setId(c.getLong(c.getColumnIndex(ShopTable.SHOP_ID)));
                    shop.setName(c.getString(c.getColumnIndex(ShopTable.SHOP_NAME)));
                    shops.add(shop);

                    c.moveToNext();
                }
            }
        }

        c.close();
        db.close();
        return shops;
    }

    /**
     * Create SQL for query food list
     *
     * @return
     */
    private String generateFoodListSql() {
//        String[] columns = new String[]{FoodTable.FOOD_ID, FoodTable.FOOD_NAME, FoodTable.FOOD_PRICE, ShopTable.SHOP_ID, ShopTable.SHOP_NAME};
//        StringBuilder builder = new StringBuilder();
//        builder.append("SELECT ");
//        for (int i = 0; i < columns.length; i++) {
//            builder.append(FoodTable.TABLE);
//            builder.append(".");
//            builder.append(columns[i]);
//            if (i < columns.length - 1) {
//                builder.append(", ");
//            }
//        }
//        builder.append(" FROM ");
//        builder.append(FoodTable.TABLE);
//        builder.append(" LEFT JOIN ");
//        builder.append(ShopTable.TABLE);
//        builder.append(".");
//        builder.append(ShopTable.SHOP_ID);
//        builder.append(" ON ");
//        builder.append(FoodTable.SHOP_ID);
//        builder.append(" = ");
//        builder.append(ShopTable.TABLE);
//        return builder.toString();

        String queryFoodListSql = "SELECT food.food_id, food.food_name, food.food_price, shop.shop_id, shop.shop_name FROM food LEFT JOIN shop ON food.shop_id = shop.shop_id";
        return queryFoodListSql;
    }

    /**
     * 列出所有的食品信息，包括食品所属的商店信息
     *
     * @return
     */
    public List<Food> queryFoodList() {

        List<Food> foods = new ArrayList<>();
        SQLiteDatabase db = utils.getWritableDatabase();

        String queryFoodSql = generateFoodListSql();

        Cursor c = db.rawQuery(queryFoodSql, null);
        Food food = null;
        if (c != null) {
            int count = c.getCount();
            if (count > 0) {
                c.moveToFirst();

                for (int i = 0; i < count; i++) {
                    food = new Food();
                    food.setId(c.getLong(c.getColumnIndex(FoodTable.FOOD_ID)));
                    food.setName(c.getString(c.getColumnIndex(FoodTable.FOOD_NAME)));
                    food.setPrice(c.getDouble(c.getColumnIndex(FoodTable.FOOD_PRICE)));
                    Shop shop = new Shop();
                    shop.setId(c.getLong(c.getColumnIndex(ShopTable.SHOP_ID)));
                    shop.setName(c.getString(c.getColumnIndex(ShopTable.SHOP_NAME)));
                    food.setShop(shop);
                    foods.add(food);

                    c.moveToNext();
                }
            }

        }
        c.close();
        db.close();
        return foods;
    }

    /**
     * 根据商店ID显示出与之相关的食品列表
     * TIPS: 暂时先用这种性能不高的方式。
     *
     * @param shopId
     * @return
     */
    public List<Food> queryFoodList(int shopId) {
        List<Food> queryFoods = queryFoodList();
        List<Food> foods = new ArrayList<>();
        for (Food food : queryFoods) {
            if (food.getShop().getId() == shopId) {
                foods.add(food);
            }
        }
        return foods;
    }

    /**
     * 保存食品信息
     *
     * @param food
     * @return
     */
    public Food saveFood(Food food) {
        SQLiteDatabase db = utils.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FoodTable.FOOD_NAME, food.getName());
        values.put(FoodTable.FOOD_PRICE, food.getPrice());
        values.put(FoodTable.SHOP_ID, food.getShop().getId());

        long foodId = db.insert(FoodTable.TABLE, null, values);
        db.close();

        Food newFood = null;
        if (foodId != INSERT_ERROR) {
            newFood = new Food();
            newFood.setId(foodId);
            newFood.setName(food.getName());
            newFood.setPrice(food.getPrice());
            newFood.setShop(food.getShop());
        }
        return newFood;
    }

    /**
     * 保存商店信息
     *
     * @param shop
     * @return
     */
    public Shop saveShop(Shop shop) {
        SQLiteDatabase db = utils.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ShopTable.SHOP_NAME, shop.getName());
        long insertedId = db.insert(ShopTable.TABLE, null, values);
        db.close();

        Shop newShop = null;
        if (insertedId != INSERT_ERROR) {
            newShop = new Shop();
            newShop.setId(insertedId);
            newShop.setName(shop.getName());
        }

        return newShop;
    }

    /**
     * Delete selected shop
     * It will delete foods equal shop_id too.
     *
     * @param shopId
     */
    public void deleteShop(int shopId) {
        SQLiteDatabase db = utils.getWritableDatabase();
        String deleteShopSql = "delete from" + ShopTable.TABLE + " where " + ShopTable.SHOP_ID + " = " + shopId;
        db.execSQL(deleteShopSql);
        db.close();
    }

    /**
     * Delete selected ids.
     * It supports multi-selection.
     *
     * @param foodIds
     */
    public void deleteFoods(int[] foodIds) {
        SQLiteDatabase db = utils.getWritableDatabase();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < foodIds.length; i++) {
            builder.append(foodIds[i]);
            if (i < foodIds.length - 1) {
                builder.append(", ");
            }
        }
        String deleteFoodsSql = "delete from " + FoodTable.TABLE + " where " + FoodTable.FOOD_ID + "in(" + builder.toString() + ")";
        db.execSQL(deleteFoodsSql);
    }

}
