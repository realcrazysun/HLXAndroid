package com.polyent.hlx.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.internal.LinkedTreeMap;
import com.polyent.hlx.R;
import com.polyent.hlx.ui.bean.HomeIndexInfoListItemModel;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by crazysun on 16/3/2.
 */
class DynamicFragment1AdapterViewHolder {
    public TextView title;
    public TextView name;
    public TextView read;
    public ImageView imageView;
}

public class DynamicFragment1Adapter extends MyBaseAdapter {

    public DynamicFragment1Adapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DynamicFragment1AdapterViewHolder holder = null;
        if (convertView == null) {
            holder = new DynamicFragment1AdapterViewHolder();
            convertView = mInflater.inflate(R.layout.dynamic_listview_item_one_pic, null);

            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.read = (TextView) convertView.findViewById(R.id.read);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imgView);

            convertView.setTag(holder);
        } else {
            holder = (DynamicFragment1AdapterViewHolder) convertView.getTag();
        }

        HomeIndexInfoListItemModel model = (HomeIndexInfoListItemModel) models.get(position);
        holder.title.setText(model.getTitle());
        holder.name.setText(model.getAuthor());
        holder.read.setText(model.getViews_num());
        if(model.getAttaches()!=null && model.getAttaches().size()>0){
            LinkedTreeMap<String,String> obj = (LinkedTreeMap<String,String>)model.getAttaches().get(0);
            Glide.with(mContext)
                    .load(obj.get("attachurl"))
                    .placeholder(R.drawable.loading)
                    .crossFade()
                    .into(holder.imageView);
        }


        return convertView;
    }

}
