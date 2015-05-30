package com.orzsite.eatwhat.bean;

/**
 * Created by Jimmy on 15/5/29.
 */
public class Food extends BaseBean {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private Shop shop;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    private int skipTimes;

    public int getSkipTimes() {
        return skipTimes;
    }

    public void setSkipTimes(int skipTimes) {
        this.skipTimes = skipTimes;
    }
}
