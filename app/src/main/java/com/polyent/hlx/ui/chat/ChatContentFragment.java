package com.polyent.hlx.ui.chat;

import android.view.View;

import com.polyent.hlx.R;
import com.polyent.hlx.adapter.MyBaseAdapter;
import com.polyent.hlx.adapter.chat.ChatFragmentAdapter;
import com.polyent.hlx.base.BaseListFragment;
import com.polyent.hlx.ui.bean.chat.ChatUIModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crazysun on 16/3/7.
 */
public class ChatContentFragment extends BaseListFragment {

    @Override
    public MyBaseAdapter getAdapter() {
        ChatFragmentAdapter adapter = new ChatFragmentAdapter(getActivity());

        if (adapter.getModels().size()==0) {
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
    public boolean isNeedLoad(){
        return false;
    }

    @Override
    public boolean isNeedRefresh() {
        return false;
    }


}
