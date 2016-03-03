package com.polyent.hlx.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.polyent.hlx.R;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitleFragment extends Fragment {


    @Bind(R.id.titlebar_iv_left)
    ImageView titlebarIvLeft;

    @Bind(R.id.titlebar_iv_right)
    ImageView titlebarIvRight;
    @Bind(R.id.title)
    TextView title;

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
        ResideMenuItem itemHome = new ResideMenuItem(getActivity(), R.mipmap.icon_fans, "Home");
        ResideMenuItem itemProfile = new ResideMenuItem(getActivity(), R.mipmap.icon_following, "Profile");


        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemProfile, ResideMenu.DIRECTION_LEFT);

        // You can disable a direction by setting ->
        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);
        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_LEFT);

        titlebarIvLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });

//        findViewById(R.id.title_bar_right_menu).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
//            }
//        });
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
}
