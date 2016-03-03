package com.polyent.hlx.adapter.dynamic;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.polyent.hlx.R;
import com.polyent.hlx.adapter.MyBaseAdapter;
import com.polyent.hlx.ui.bean.dynamic.HomeHotInfo;
import com.polyent.hlx.ui.bean.dynamic.HotInfoBodyModel;

/**
 * Created by crazysun on 16/3/3.
 */
class DynamicFragment2AdapterViewHolder {

    public TextView pushtime;

    public ImageView imgView;
    public TextView imageViewText;

    public TextView text1;
    public ImageView img1;
    public TextView text2;
    public ImageView img2;
    public TextView text3;
    public ImageView img3;
    public TextView text4;
    public ImageView img4;
}

public class DynamicFragment2Adapter extends MyBaseAdapter {

    public DynamicFragment2Adapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DynamicFragment2AdapterViewHolder holder = null;
        if (convertView == null) {
            holder = new DynamicFragment2AdapterViewHolder();
            convertView = mInflater.inflate(R.layout.dynamic_hotnews_layout, null);

            holder.pushtime = (TextView) convertView.findViewById(R.id.pushtime);
            holder.imgView = (ImageView) convertView.findViewById(R.id.imgView);
            holder.imageViewText = (TextView) convertView.findViewById(R.id.imgText);
            holder.text1 = (TextView) convertView.findViewById(R.id.text1);
            holder.img1 = (ImageView) convertView.findViewById(R.id.img1);

            holder.text2 = (TextView) convertView.findViewById(R.id.text2);
            holder.img2 = (ImageView) convertView.findViewById(R.id.img2);

            holder.text3 = (TextView) convertView.findViewById(R.id.text3);
            holder.img3 = (ImageView) convertView.findViewById(R.id.img3);

            holder.text4 = (TextView) convertView.findViewById(R.id.text4);
            holder.img4 = (ImageView) convertView.findViewById(R.id.img4);

            convertView.setTag(holder);
        } else {
            holder = (DynamicFragment2AdapterViewHolder) convertView.getTag();
        }

        HomeHotInfo model = (HomeHotInfo) models.get(position);
        holder.pushtime.setText(model.getPushtime());
        HotInfoBodyModel header = model.getItems().getHeader();
        Glide.with(mContext)
                .load(header.getCover())
                .placeholder(R.drawable.loading)
                .crossFade()
                .into( holder.imgView);
        holder.imageViewText.setText(header.getNew_title());


        holder.text1.setText(model.getItems().getBody().get(0).getNew_title());
        Glide.with(mContext)
                .load(model.getItems().getBody().get(0).getCover())
                .placeholder(R.drawable.loading)
                .crossFade()
                .into( holder.img1);

        holder.text2.setText(model.getItems().getBody().get(1).getNew_title());
        Glide.with(mContext)
                .load(model.getItems().getBody().get(1).getCover())
                .placeholder(R.drawable.loading)
                .crossFade()
                .into( holder.img2);

        holder.text3.setText(model.getItems().getBody().get(2).getNew_title());
        Glide.with(mContext)
                .load(model.getItems().getBody().get(2).getCover())
                .placeholder(R.drawable.loading)
                .crossFade()
                .into( holder.img3);

        holder.text4.setText(model.getItems().getBody().get(3).getNew_title());
        Glide.with(mContext)
                .load(model.getItems().getBody().get(3).getCover())
                .placeholder(R.drawable.loading)
                .crossFade()
                .into( holder.img4);


        return convertView;
    }

}
