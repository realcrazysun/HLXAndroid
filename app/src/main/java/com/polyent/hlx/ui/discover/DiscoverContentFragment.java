package com.polyent.hlx.ui.discover;


import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.gson.Gson;

import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.polyent.hlx.R;
import com.polyent.hlx.adapter.DiscoverListViewAdapter;
import com.polyent.hlx.adapter.MyBaseAdapter;
import com.polyent.hlx.base.BaseListFragment;
import com.polyent.hlx.ui.bean.DiscoverItemModel;
import com.polyent.hlx.ui.bean.ItemModel;
import com.polyent.hlx.ui.bean.RootObject;
import com.polyent.hlx.ui.dynamic.AnimalListAdapter;


import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
