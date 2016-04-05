package com.polyent.hlx.ui.bean.chat;

/**
 * Created by crazysun on 16/3/15.
 */
public class ContactUserItemInfo {
    private int user_id;
    private String avatar;
    private String nickname;
    private String sign;
    private int is_friend;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public int getIs_friend() {
        return is_friend;
    }

    public void setIs_friend(int is_friend) {
        this.is_friend = is_friend;
    }
    //    "user_id": 2350934,
//                "avatar": "http://pic.hualongxiang.com/images/face/none.gif",
//                "nickname": "大孟子",
//                "sign": "",
//                "is_friend": 0
}
