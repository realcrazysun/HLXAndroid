package com.polyent.hlx.ui.bean.chat;

import java.util.ArrayList;

/**
 * Created by crazysun on 16/3/15.
 */
public class ContactModel {
    private ArrayList<ContactFixedItemInfo> fixed;
    private ArrayList<ContactUserListItemInfo> list;

    public ArrayList<ContactFixedItemInfo> getFixed() {
        return fixed;
    }

    public void setFixed(ArrayList<ContactFixedItemInfo> fixed) {
        this.fixed = fixed;
    }

    public ArrayList<ContactUserListItemInfo> getList() {
        return list;
    }

    public void setList(ArrayList<ContactUserListItemInfo> list) {
        this.list = list;
    }
}
