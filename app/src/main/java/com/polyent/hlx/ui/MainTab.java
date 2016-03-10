package com.polyent.hlx.ui;

/**
 * Created by crazysun on 16/2/23.
 */

import android.support.v4.app.Fragment;

import com.polyent.hlx.ui.chat.ChatFragment;
import com.polyent.hlx.ui.community.CommunityFragment;
import com.polyent.hlx.ui.discover.DiscoverFragment;
import com.polyent.hlx.ui.dynamic.DynamicFragment;
import com.polyent.hlx.R;
import com.polyent.hlx.ui.localcircle.LocalCircleFragment;

public enum MainTab {
    Tab1(0, R.string.main_tab_1, R.drawable.tab_icon_1,
            DynamicFragment.class),
    Tab2(1, R.string.main_tab_2, R.drawable.tab_icon_2,
            CommunityFragment.class),

    Tab3(2, R.string.main_tab_3, R.drawable.tab_icon_3,
            Fragment.class),

    Tab4(3, R.string.main_tab_4, R.drawable.tab_icon_4,
            ChatFragment.class),

    Tab5(4, R.string.main_tab_5, R.drawable.tab_icon_5,
            DiscoverFragment.class);

    private int idx;
    private int resName;
    private int resIcon;
    private Class<?> clz;

    private MainTab(int idx, int resName, int resIcon, Class<?> clz) {
        this.idx = idx;
        this.resName = resName;
        this.resIcon = resIcon;
        this.clz = clz;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getResName() {
        return resName;
    }

    public void setResName(int resName) {
        this.resName = resName;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }


}
