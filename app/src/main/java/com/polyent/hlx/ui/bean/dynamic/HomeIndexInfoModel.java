package com.polyent.hlx.ui.bean.dynamic;

import java.util.ArrayList;

/**
 * Created by crazysun on 16/3/2.
 */

public class HomeIndexInfoModel {
    String last_side_id;
    String last_post_id;
    String update_num;
    String has_unread_hot;
    ArrayList<HomeIndexInfoListItemModel> list;

    public String getLast_side_id() {
        return last_side_id;
    }

    public void setLast_side_id(String last_side_id) {
        this.last_side_id = last_side_id;
    }

    public String getLast_post_id() {
        return last_post_id;
    }

    public void setLast_post_id(String last_post_id) {
        this.last_post_id = last_post_id;
    }

    public String getUpdate_num() {
        return update_num;
    }

    public void setUpdate_num(String update_num) {
        this.update_num = update_num;
    }

    public String getHas_unread_hot() {
        return has_unread_hot;
    }

    public void setHas_unread_hot(String has_unread_hot) {
        this.has_unread_hot = has_unread_hot;
    }

    public ArrayList<HomeIndexInfoListItemModel> getList() {
        return list;
    }

    public void setList(ArrayList<HomeIndexInfoListItemModel> list) {
        this.list = list;
    }


}
