package com.polyent.hlx.ui.dynamic;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.polyent.hlx.adapter.dynamic.DynamicFragment3Adapter;
import com.polyent.hlx.adapter.MyBaseAdapter;
import com.polyent.hlx.base.BaseListFragment;
import com.polyent.hlx.ui.bean.dynamic.HomeActivity;
import com.polyent.hlx.ui.bean.RootObject;

import java.util.List;

import retrofit2.Call;

/**
 * Created by crazysun on 16/3/3.
 */

public class Fragment3 extends BaseListFragment {

    @Override
    public MyBaseAdapter getAdapter() {

        return new DynamicFragment3Adapter(getActivity());
    }

    //获取网络API
    @Override
    public Call getCall() {
        return git.getHomeActivities();
    }

    @Override
    public List parseRootObjToList(RootObject object){
        Gson gson = new Gson();
        List<HomeActivity> models = gson.fromJson(gson.toJson(object.getData()),
                new TypeToken<List<HomeActivity>>() {
                }.getType() );

        return models;
    }

    @Override
    public boolean isNeedLoad(){
        return true;
    }

}
