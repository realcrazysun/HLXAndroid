package com.polyent.hlx.ui.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.polyent.hlx.R;
import com.polyent.hlx.adapter.DiscoverListViewAdapter;
import com.polyent.hlx.adapter.DynamicFragment1Adapter;
import com.polyent.hlx.adapter.MyBaseAdapter;
import com.polyent.hlx.base.BaseListFragment;
import com.polyent.hlx.ui.bean.DiscoverItemModel;
import com.polyent.hlx.ui.bean.HomeIndexInfoModel;
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