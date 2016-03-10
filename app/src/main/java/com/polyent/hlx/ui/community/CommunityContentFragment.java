package com.polyent.hlx.ui.community;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.google.gson.Gson;
import com.polyent.hlx.R;
import com.polyent.hlx.adapter.MyBaseAdapter;
import com.polyent.hlx.adapter.chat.ChatFragmentAdapter;
import com.polyent.hlx.adapter.community.CommunityContentFragmentAdapter;
import com.polyent.hlx.base.BaseListFragment;
import com.polyent.hlx.ui.bean.RootObject;
import com.polyent.hlx.ui.bean.chat.ChatUIModel;
import com.polyent.hlx.ui.bean.community.CommunityModel;
import com.polyent.hlx.ui.bean.dynamic.HomeIndexInfoModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by crazysun on 16/3/8.
 */
public class CommunityContentFragment extends BaseListFragment {

    //    private CommunityModel mCommunityModel ;
    private CommunityContentFragmentAdapter adapter;

//    //获取网络API
//    @Override
//    public Call getCall() {
//        return git.getDiscoverInfo();
//    }

    @Override
    public void sendRequest(int page, final boolean refresh) {
        super.sendRequest(page, refresh);
        if (refresh) {
            Call call = git.getForumJuhe();

            call.enqueue(new Callback<RootObject>() {
                @Override
                public void onResponse(Response<RootObject> response) {

                    RootObject model = response.body();
                    if (model == null) {
                        System.out.println("onResponse : model is null");
                    } else if (!model.getRet().equals("0")) {
                        System.out.println("onResponse : model is null" + model.getRet());
                    } else {
                        Gson gson = new Gson();
                        CommunityModel communityModel = gson.fromJson(gson.toJson(model.getData()), CommunityModel.class);
                        adapter.setmCommunityModel(communityModel);
                        adapter.notifyDataSetChanged();
                    }


                }

                @Override
                public void onFailure(Throwable t) {

                    System.out.println("failed");
                }
            });
        }
    }

    @Override
    public MyBaseAdapter getAdapter() {
         adapter = new CommunityContentFragmentAdapter(getActivity());

        if (adapter.getModels().size() == 0) {
            String[] names = {"附近的人", "点赞通知", "评论通知", "化龙巷香香"};
            String[] subTitles = {"点击查看附近的人", "点击查看点赞通知", "点击查看评论通知", "和化龙巷香香聊天吧"};
            int[] icons = {R.mipmap.icon_chat_near, R.mipmap.icon_chat_zan, R.mipmap.icon_chat_comment, R.mipmap.xianmudujihen};
            List<ChatUIModel> models = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                ChatUIModel model = new ChatUIModel();
                model.setName(names[i]);
                model.setSubTitle(subTitles[i]);
                model.setResId(icons[i]);
                models.add(model);
            }
            adapter.addModels(models);
        }
        return adapter;
    }


    @Override
    public boolean isNeedLoad() {
        return false;
    }


}
