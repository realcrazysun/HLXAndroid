package com.polyent.hlx.ui.discover;


import android.support.v4.app.Fragment;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import com.polyent.hlx.adapter.discover.DiscoverListViewAdapter;
import com.polyent.hlx.adapter.MyBaseAdapter;
import com.polyent.hlx.base.BaseListFragment;
import com.polyent.hlx.ui.bean.discover.DiscoverItemModel;
import com.polyent.hlx.ui.bean.RootObject;


import java.util.List;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverContentFragment extends BaseListFragment {


    @Override
    public MyBaseAdapter getAdapter() {

        return new DiscoverListViewAdapter(getActivity());
    }
    //获取网络API
    @Override
    public Call getCall() {
        return git.getDiscoverInfo();
    }
    @Override
    public List parseRootObjToList(RootObject object){
        Gson gson = new Gson();
        List<DiscoverItemModel> discoverItemModels = gson.fromJson(gson.toJson(object.getData()),
                new TypeToken<List<DiscoverItemModel>>() {
                }.getType() );
        return discoverItemModels;
    }
    @Override
    public boolean isNeedLoad(){
        return false;
    }
}
