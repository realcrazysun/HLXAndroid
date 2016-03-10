package com.polyent.hlx.adapter.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.internal.LinkedTreeMap;
import com.polyent.hlx.R;
import com.polyent.hlx.adapter.MyBaseAdapter;
import com.polyent.hlx.base.NoScrollGridView;
import com.polyent.hlx.ui.bean.chat.ChatUIModel;
import com.polyent.hlx.ui.bean.dynamic.HomeIndexInfoListItemModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by crazysun on 16/3/6.
 */

class ChatFragmentAdapterViewHolder {
    public TextView name;
    public TextView subTitle;
    public ImageView imageView;
}

public class ChatFragmentAdapter extends MyBaseAdapter{

    public ChatFragmentAdapter(Context context){
        super(context);
    }

    @Override
    public ArrayList getModels() {

        return models;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChatFragmentAdapterViewHolder holder = null;
        if (convertView == null) {
            holder = new ChatFragmentAdapterViewHolder();
            convertView = mInflater.inflate(R.layout.chat_listview_item, null);

            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.subTitle = (TextView) convertView.findViewById(R.id.subTitle);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imgView);

            convertView.setTag(holder);
        } else {
            holder = (ChatFragmentAdapterViewHolder) convertView.getTag();
        }

        ChatUIModel model = (ChatUIModel) models.get(position);

        holder.name.setText(model.getName());
        holder.subTitle.setText(model.getSubTitle());
        holder.imageView.setImageResource(model.getResId());
        return convertView;
    }
}
