package com.polyent.hlx.ui.chat;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.polyent.hlx.R;
import com.polyent.hlx.adapter.MyBaseAdapter;
import com.polyent.hlx.adapter.chat.ChatFragmentAdapter;
import com.polyent.hlx.adapter.discover.DiscoverListViewAdapter;
import com.polyent.hlx.base.BaseListFragment;
import com.polyent.hlx.ui.TitleFragment;
import com.polyent.hlx.ui.bean.RootObject;
import com.polyent.hlx.ui.bean.discover.DiscoverItemModel;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {



    private View rootView;

    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_chat, null);
            ButterKnife.bind(this, rootView);
            TitleFragment titleFragment =  (TitleFragment)getChildFragmentManager().findFragmentById(R.id.titlefragment);
            titleFragment.setTitle("聊天");
            titleFragment.setTitlebarIvRightImg(R.mipmap.icon_contacts);

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
