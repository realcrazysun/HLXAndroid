package com.polyent.hlx.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.polyent.hlx.R;
import com.polyent.hlx.ui.dynamic.Fragment1;
import com.polyent.hlx.ui.dynamic.Fragment2;
import com.polyent.hlx.ui.empty.EmptyLayout;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 带有导航条的基类
 *
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年11月6日 下午4:59:50
 */
public class BaseViewPagerFragment extends BaseFragment {

    @Bind(R.id.pager_tabstrip)
    PagerSlidingTabStrip pagerTabstrip;

    @Bind(R.id.pager)
    ViewPager pager;

    public BaseViewPagerFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_viewpage_fragment, container, false);
        ButterKnife.bind(this, view);
        pager.setAdapter(getAdapter());
        pagerTabstrip.setViewPager(pager);

        return view;
    }


    protected void setScreenPageLimit() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public FragmentPagerAdapter getAdapter(){
        return null;
    }
}


