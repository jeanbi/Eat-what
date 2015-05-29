package com.orzsite.eatwhat.bean;

import java.io.Serializable;

/**
 * Created by Jimmy on 15/5/29.
 */
public class BaseBean implements Serializable {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
