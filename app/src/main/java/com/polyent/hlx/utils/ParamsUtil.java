package com.polyent.hlx.utils;

import com.google.gson.JsonObject;
import com.polyent.hlx.config.AppContext;
import com.polyent.hlx.ui.bean.User;

import java.util.HashMap;

/**
 * Created by crazysun on 16/3/15.
 */
public class ParamsUtil {
    public static HashMap<String, String> defaultParams() {

        HashMap<String, String> ret = new HashMap<>();

        ret.put("access_token", "8a7c2136f86a95e256b67e73de4c1544");
        JsonObject data = new JsonObject();
        JsonObject params = new JsonObject();
//        params.addProperty("weiboType", "qq");
//        params.addProperty("openId", "3D30D2BF01AD011252695BCE71B89AFC");

        data.add("params", params);
        ret.put("data", data.toString());

        User user = AppContext.getInstance().getLoginUser();
        if (user != null) {
            ret.put("login_token", user.getLogin_token());
            ret.put("user_id", String.valueOf(user.getUid()));
        }

        ret.put("device", "E542B165-08ED-4529-AF7C-B15F8DE0B199");
        ret.put("platform", "iPhone 5");
        ret.put("network", "1");
        ret.put("screen_height", "568.000000");
        ret.put("screen_width", "320.000000");
        ret.put("system", "1");
        ret.put("system_version", "9.2");
        ret.put("version", "4.4.0");

        return ret;
    }
}
