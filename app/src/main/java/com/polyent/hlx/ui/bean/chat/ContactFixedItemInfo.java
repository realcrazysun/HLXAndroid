package com.polyent.hlx.ui.bean.chat;

/**
 * Created by crazysun on 16/3/15.
 */
public class ContactFixedItemInfo {
    //    "avatar": "http://pic.hualongxiang.com/attachment/upload/00/1025000_1450928498.jpg",
//            "nickname": "化龙巷香香",
//            "target_val": "1025000",
//            "target_type": 0
    private String avatar;
    private String nickname;
    private String target_val;
    private int target_type;


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTarget_val() {
        return target_val;
    }

    public void setTarget_val(String target_val) {
        this.target_val = target_val;
    }

    public int getTarget_type() {
        return target_type;
    }

    public void setTarget_type(int target_type) {
        this.target_type = target_type;
    }
}
