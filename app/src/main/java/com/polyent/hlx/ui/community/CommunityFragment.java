package com.polyent.hlx.ui.community;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.polyent.hlx.R;
import com.polyent.hlx.ui.TitleFragment;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends Fragment {



    private View rootView;

    public CommunityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_community, null);
            ButterKnife.bind(this, rootView);
            TitleFragment titleFragment =  (TitleFragment)getChildFragmentManager().findFragmentById(R.id.titlefragment);
            titleFragment.setTitle("社区");
            titleFragment.setTitlebarIvRightImg(R.mipmap.icon_forum_publish);

        }
        //缓存的rootView需要判断是否已经被加过parent， 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }




}
