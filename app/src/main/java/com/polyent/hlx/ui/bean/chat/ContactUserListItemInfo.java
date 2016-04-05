package com.polyent.hlx.ui.bean.chat;

import java.util.ArrayList;

/**
 * Created by crazysun on 16/3/15.
 */
public class ContactUserListItemInfo {
//    "letter": "D",
//            "list": [{
//        "user_id": 2350934,
//                "avatar": "http://pic.hualongxiang.com/images/face/none.gif",
//                "nickname": "大孟子",
//                "sign": "",
//                "is_friend": 0
//    }]
    private String letter;
    private ArrayList<ContactUserItemInfo> list;

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public ArrayList<ContactUserItemInfo> getList() {
        return list;
    }

    public void setList(ArrayList<ContactUserItemInfo> list) {
        this.list = list;
    }
}
