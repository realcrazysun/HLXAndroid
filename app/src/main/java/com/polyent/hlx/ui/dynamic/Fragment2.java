package com.polyent.hlx.ui.dynamic;


import android.support.v4.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.polyent.hlx.adapter.dynamic.DynamicFragment2Adapter;
import com.polyent.hlx.adapter.MyBaseAdapter;
import com.polyent.hlx.base.BaseListFragment;
import com.polyent.hlx.ui.bean.dynamic.HomeHotInfo;
import com.polyent.hlx.ui.bean.RootObject;

import java.util.List;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends BaseListFragment {

    @Override
    public MyBaseAdapter getAdapter() {

        return new DynamicFragment2Adapter(getActivity());
    }

    //获取网络API
    @Override
    public Call getCall() {
        return git.getHomeRecommend();
    }

    @Override
    public List parseRootObjToList(RootObject object){
        Gson gson = new Gson();
        System.out.println(gson.toJson(object.getData()));
        List<HomeHotInfo> models = gson.fromJson(gson.toJson(object.getData()),
                new TypeToken<List<HomeHotInfo>>() {
                }.getType() );
        return models;
    }

    @Override
    public boolean isNeedLoad(){
        return true;
    }

    @Override
    public int getDividerHeight(){
        return 0;
    }

}
