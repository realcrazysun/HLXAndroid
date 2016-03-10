package com.polyent.hlx.ui.bean.community;

import java.util.ArrayList;

/**
 * Created by crazysun on 16/3/10.
 */
public class CommunityModel {

    ArrayList<CommuityBlockModel> attention;
    ArrayList<CommuityBlockModel> recommend;

    public ArrayList<CommuityBlockModel> getAttention() {
        return attention;
    }

    public void setAttention(ArrayList<CommuityBlockModel> attention) {
        this.attention = attention;
    }

    public ArrayList<CommuityBlockModel> getRecommend() {
        return recommend;
    }

    public void setRecommend(ArrayList<CommuityBlockModel> recommend) {
        this.recommend = recommend;
    }
}
