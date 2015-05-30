package com.orzsite.eatwhat.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * copyright: Copyright(c) Jimmy Xue(jeanbi@gmail.com). All rights reserved.
 * license: GNU General Public License 2.0
 * Created by Jimmy on 15/5/29.
 */
public class DatabaseUtils extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DATABASE_NAME = "eat_what";

    public DatabaseUtils(Context context) {
        this(context, DB_VERSION);
    }

    public DatabaseUtils(Context context, int version) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Create shop table
        String CREATE_SHOP_SQL = generateShopTable();
        db.execSQL(CREATE_SHOP_SQL);

        //Create food table
        String CREATE_FOOD_SQL = generateFoodTable();
        db.execSQL(CREATE_FOOD_SQL);
    }

    private String generateShopTable() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE IF NOT EXISTS ");
        builder.append(ShopTable.TABLE);
        builder.append(" (");
        builder.append(ShopTable.SHOP_ID);
        builder.append(" integer primary key autoincrement,");
        builder.append(ShopTable.SHOP_NAME);
        builder.append(" text)");

        return builder.toString();
    }

    private String generateFoodTable() {
        StringBuilder builder =new StringBuilder();
        builder.append("CREATE TABLE IF NOT EXISTS ");
        builder.append(FoodTable.TABLE);
        builder.append(" (");
        builder.append(FoodTable.FOOD_ID);
        builder.append(" integer primary key autoincrement,");
        builder.append(FoodTable.FOOD_NAME);
        builder.append(" text,");
        builder.append(FoodTable.FOOD_PRICE);
        builder.append(" real,");
        builder.append(FoodTable.SHOP_ID);
        builder.append(" integer,");
        builder.append("FOREIGN KEY (");
        builder.append(FoodTable.SHOP_ID);
        builder.append(") REFERENCES ");
        builder.append(ShopTable.TABLE);
        builder.append("(");
        builder.append(ShopTable.SHOP_ID);
        builder.append("))");

        return builder.toString();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
