package com.polyent.hlx.ui.dynamic;

import android.support.v4.app.FragmentPagerAdapter;

import com.polyent.hlx.adapter.dynamic.DynamicViewPagerAdapter;
import com.polyent.hlx.base.BaseViewPagerFragment;

/**
 * Created by crazysun on 16/3/2.
 */
public class DynamicViewPagerFragment extends BaseViewPagerFragment{

    public FragmentPagerAdapter getAdapter(){
        return new DynamicViewPagerAdapter(getFragmentManager());
    }
}
