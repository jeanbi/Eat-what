package com.orzsite.eatwhat.dao;

/**
 * copyright: Copyright(c) Jimmy Xue(jeanbi@gmail.com). All rights reserved.
 * license: GNU General Public License 2.0
 * Created by Jimmy on 15/5/30.
 */
public class FoodTable {
    public static final String TABLE = "food";

    public static final String FOOD_ID = "food_id";
    public static final String FOOD_NAME = "food_name";
    public static final String FOOD_PRICE = "food_price";
    public static final String SHOP_ID = "shop_id";
    /**
     * 如果点击了重新选择，则该字段会自动+1
     * tip: 这个字段的主要目的是，达到一定数值之后，摇的时候就不出现在推荐里，实现自动过滤的功能。
     */
    public static final String SKIP_TIMES = "skip_times";
}
