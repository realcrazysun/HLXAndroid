package com.polyent.hlx.ui.bean.dynamic;

/**
 * Created by crazysun on 16/3/3.
 */
public class HomeHotInfo {
    String pushtime;
    HomeInfoItemModel items;

    public HomeInfoItemModel getItems() {
        return items;
    }

    public void setItems(HomeInfoItemModel items) {
        this.items = items;
    }

    public String getPushtime() {
        return pushtime;
    }

    public void setPushtime(String pushtime) {
        this.pushtime = pushtime;
    }


}
