package com.polyent.hlx.ui;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.polyent.hlx.R;
import com.polyent.hlx.config.LoginActivity;
import com.polyent.hlx.ui.chat.ContactActivity;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitleFragment extends Fragment implements View.OnClickListener{


    @Bind(R.id.titlebar_iv_left)
    ImageView titlebarIvLeft;

    @Bind(R.id.titlebar_iv_right)
    ImageView titlebarIvRight;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.pager_tabstrip)
    PagerSlidingTabStrip pagerTabstrip;

    private ResideMenu resideMenu;

    public TitleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_base, container, false);
        ButterKnife.bind(this, view);

        setUpMenu();

        titlebarIvLeft.setImageResource(R.mipmap.icon_avatar_nologin);
        titlebarIvLeft.setVisibility(View.VISIBLE);
        return view;

    }

    private void setUpMenu() {

        // attach to current activity;
        resideMenu = new ResideMenu(getActivity());

//        resideMenu.setUse3D(true);
        resideMenu.setBackground(R.mipmap.bg);
        resideMenu.attachToActivity(getActivity());

        resideMenu.setScaleValue(0.6f);

        // create menu items;
        ResideMenuItem itemLogin = new ResideMenuItem(getActivity(), R.mipmap.btn_qq_unpressed, "Login");
        ResideMenuItem itemHome = new ResideMenuItem(getActivity(), R.mipmap.icon_fans, "Home");
        ResideMenuItem itemProfile = new ResideMenuItem(getActivity(), R.mipmap.icon_following, "Profile");
        itemLogin.setOnClickListener(this);

        resideMenu.addMenuItem(itemLogin, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemProfile, ResideMenu.DIRECTION_LEFT);

        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);
        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_LEFT);

        titlebarIvLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });

    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void setTitlebarIvRightImg(int resId) {
        titlebarIvRight.setImageResource(resId);
        titlebarIvRight.setVisibility(View.VISIBLE);
    }

    public void setTitle(String text) {
        title.setText(text);
        title.setVisibility(View.VISIBLE);
    }

    public void setViewPager(ViewPager viewPager) {
        pagerTabstrip.setVisibility(View.VISIBLE);
        pagerTabstrip.setViewPager(viewPager);
    }

    public void setRightImgClickEvent(View.OnClickListener listener) {
        titlebarIvRight.setOnClickListener(listener);
    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(getActivity(), LoginActivity.class);
//                intent.putExtra(ContactActivity.DATA_FRESH_NEWS, mFreshNews);
//                intent.putExtra(ContactActivity.DATA_POSITION, position);
        getActivity().startActivity(intent);

    }
}
