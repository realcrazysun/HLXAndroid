package com.polyent.hlx.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.polyent.hlx.R;
import com.polyent.hlx.adapter.DiscoverListViewAdapter;
import com.polyent.hlx.adapter.MyBaseAdapter;
import com.polyent.hlx.api.HLXAPIService;
import com.polyent.hlx.net.ServiceGenerator;
import com.polyent.hlx.ui.bean.DiscoverItemModel;
import com.polyent.hlx.ui.bean.RootObject;
import com.polyent.hlx.ui.dynamic.AnimalListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @描述 在Fragment中要使用ListView，就要用ListFragment
 */
public class BaseListFragment extends ListFragment {

    protected HLXAPIService git;//通信

    @Bind(android.R.id.list)
    ListView listView;

    @Bind(R.id.swipe_container)
    RefreshLayout swipeContainer;

    protected MyBaseAdapter adapter;

    protected int curPage = 1;

    private View rootView;
    /**
     * @描述 在onCreateView中加载布局
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //避免重复加载
        if(rootView!=null){
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
            return rootView;
        }

        View view = inflater.inflate(R.layout.fragment_baselist, container, false);
        ButterKnife.bind(this, view);

        //设置刷新时动画的颜色，可以设置4个
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);

        OnRefreshListener listener = new OnRefreshListener() {
            @Override
            public void onRefresh() {
                sendRequest(1, true);
            }
        };
        swipeContainer.setOnRefreshListener(listener);
        swipeContainer.post(new Runnable() {
            @Override
            public void run() {
                swipeContainer.setRefreshing(true);
            }
        });
        listener.onRefresh();

        if (isNeedLoad()) {
            swipeContainer.setOnLoadListener(new RefreshLayout.OnLoadListener() {
                @Override
                public void onLoad() {
                    sendRequest(curPage, false);
                }
            });
        }
        rootView = view;
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.git = ServiceGenerator.createService(HLXAPIService.class);
        adapter = getAdapter();
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

    }

    //发送网络请求
    public void sendRequest(int page, final boolean refresh) {
        Call call = getCall();
        call.enqueue(new Callback<RootObject>() {
            @Override
            public void onResponse(Response<RootObject> response) {

                RootObject model = response.body();
                if (model == null) {
                    System.out.println("onResponse : model is null");
                } else if (!model.getRet().equals("0")) {
                    System.out.println("onResponse : model is null" + model.getRet());
                } else {
                    if (refresh) {
                        adapter.clearModels();
                    }
                    List list = parseRootObjToList(model);
                    //// TODO: 16/3/2  判断是否加入列表
                    for (Object obj : list) {
                        for (Object objCompare : adapter.getModels()) {
                            if (obj.equals(objCompare)) {
                                list.remove(obj);
                                break;
                            }
                        }
                    }
                    if (list.size() > 0) {
                        adapter.addModels(list);
                        adapter.notifyDataSetChanged();
                        curPage++;
                    } else {
                        swipeContainer.setOnClickListener(null);
                    }
                }
                //warning 这里经常抛出异常 应该找到原因
                try {
                    swipeContainer.setRefreshing(false);
                    swipeContainer.setLoading(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Throwable t) {
                swipeContainer.setRefreshing(false);
                swipeContainer.setLoading(false);
                System.out.println("failed");
            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public boolean isNeedLoad() {
        return true;
    }

    //获取适配器
    public MyBaseAdapter getAdapter() {
        return null;
    }

    //获取网络API
    public Call getCall() {
        return null;
    }

    public List parseRootObjToList(RootObject object) {
        return null;
    }
}