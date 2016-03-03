package com.polyent.hlx.ui.bean;

import java.util.ArrayList;

/**
 * Created by crazysun on 16/3/1.
 */
public class DiscoverItemModel {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<ItemModel> getVal() {
        return val;
    }

    public void setVal(ArrayList<ItemModel> val) {
        this.val = val;
    }

    private String title;
    private String type;
    private ArrayList<ItemModel> val;
}
