package com.polyent.hlx.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.internal.LinkedTreeMap;
import com.polyent.hlx.R;
import com.polyent.hlx.ui.bean.HomeActivity;
import com.polyent.hlx.ui.bean.HomeIndexInfoListItemModel;

/**
 * Created by crazysun on 16/3/3.
 */
//// TODO: 16/3/3  右上角表示活动状态的图标不能正确显示 考虑BadgeView 或 正确布局
class DynamicFragment3AdapterViewHolder {
    public TextView title;
    public ImageView imgView;
    public ImageView imgStateView;
    public TextView time;
}

public class DynamicFragment3Adapter extends MyBaseAdapter {

    public DynamicFragment3Adapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DynamicFragment3AdapterViewHolder holder = null;
        if (convertView == null) {
            holder = new DynamicFragment3AdapterViewHolder();
            convertView = mInflater.inflate(R.layout.dynamic_activity_layout, null);

            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.imgView = (ImageView) convertView.findViewById(R.id.imgView);
            holder.imgStateView = (ImageView) convertView.findViewById(R.id.imgstate);
            holder.time = (TextView) convertView.findViewById(R.id.time);

            convertView.setTag(holder);
        } else {
            holder = (DynamicFragment3AdapterViewHolder) convertView.getTag();
        }

        HomeActivity model = (HomeActivity) models.get(position);
        holder.title.setText(model.getName());


        Glide.with(mContext)
                .load(model.getCover())
                .placeholder(R.drawable.loading)
                .crossFade()
                .into(holder.imgView);
        holder.time.setText("    " + model.getStart_time() + " - " + model.getEnd_time());
        holder.imgStateView.setImageResource(R.mipmap.ic_activity_ing);

        return convertView;
    }

}
