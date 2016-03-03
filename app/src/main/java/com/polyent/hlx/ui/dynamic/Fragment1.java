package com.polyent.hlx.ui.dynamic;

import java.util.List;

import com.google.gson.Gson;
import com.polyent.hlx.adapter.dynamic.DynamicFragment1Adapter;
import com.polyent.hlx.adapter.MyBaseAdapter;
import com.polyent.hlx.base.BaseListFragment;
import com.polyent.hlx.ui.bean.dynamic.HomeIndexInfoModel;
import com.polyent.hlx.ui.bean.RootObject;

import retrofit2.Call;

/**
 * @描述 在Fragment中要使用ListView，就要用ListFragment 
 * */
public class Fragment1 extends BaseListFragment {

    @Override
    public MyBaseAdapter getAdapter() {

        return new DynamicFragment1Adapter(getActivity());
    }

    //获取网络API
    @Override
    public Call getCall() {
        return git.getHomeIndex();
    }

    @Override
    public List parseRootObjToList(RootObject object){
        Gson gson = new Gson();
        HomeIndexInfoModel model = gson.fromJson(gson.toJson(object.getData()),HomeIndexInfoModel.class);
        return model.getList();
    }

    @Override
    public boolean isNeedLoad(){
        return true;
    }

}  