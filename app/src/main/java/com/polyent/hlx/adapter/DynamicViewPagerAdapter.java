package com.polyent.hlx.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.polyent.hlx.ui.dynamic.Fragment1;
import com.polyent.hlx.ui.dynamic.Fragment2;
import com.polyent.hlx.ui.dynamic.Fragment3;

/**
 * Created by crazysun on 16/3/2.
 */
public class DynamicViewPagerAdapter extends FragmentPagerAdapter {

    String[] title = { "关注", "热点", "活动" };
    Fragment fragment1;
    Fragment fragment2;
    Fragment fragment3;

    public DynamicViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                fragment1 = new Fragment1();
                return fragment1;
            case 1:
                fragment2 = new Fragment2();
                return fragment2;
            case 2:
                fragment3 = new Fragment3();
                return fragment3;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {

        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

}