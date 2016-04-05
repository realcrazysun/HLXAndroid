package com.polyent.hlx.ui.localcircle;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.polyent.hlx.R;
import com.polyent.hlx.adapter.dynamic.DynamicViewPagerAdapter;
import com.polyent.hlx.ui.TitleFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocalCircleFragment extends Fragment {


    @Bind(R.id.pager)
    ViewPager pager;
    private View rootView;

    public LocalCircleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_localcircle, null);
            ButterKnife.bind(this, rootView);
            TitleFragment titleFragment = (TitleFragment) getChildFragmentManager().findFragmentById(R.id.titlefragment);
            titleFragment.setTitlebarIvRightImg(R.mipmap.icon_pai_publish);
            pager.setAdapter(new DynamicViewPagerAdapter(getFragmentManager()));
            titleFragment.setViewPager(pager);
        }
        //缓存的rootView需要判断是否已经被加过parent， 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }

        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
