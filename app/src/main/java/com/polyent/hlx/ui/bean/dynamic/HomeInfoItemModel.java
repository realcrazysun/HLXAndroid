package com.polyent.hlx.ui.bean.dynamic;

import java.util.ArrayList;

/**
 * Created by crazysun on 16/3/3.
 */
public class HomeInfoItemModel {
    HotInfoBodyModel header;
    ArrayList<HotInfoBodyModel> body;

    public HotInfoBodyModel getHeader() {
        return header;
    }

    public void setHeader(HotInfoBodyModel header) {
        this.header = header;
    }

    public ArrayList<HotInfoBodyModel> getBody() {
        return body;
    }

    public void setBody(ArrayList<HotInfoBodyModel> body) {
        this.body = body;
    }
}
