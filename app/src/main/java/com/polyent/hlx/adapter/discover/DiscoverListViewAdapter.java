package com.polyent.hlx.adapter.discover;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.polyent.hlx.R;
import com.polyent.hlx.adapter.MyBaseAdapter;
import com.polyent.hlx.base.NoScrollGridView;
import com.polyent.hlx.ui.bean.discover.DiscoverItemModel;
import com.polyent.hlx.ui.bean.discover.ItemModel;
import com.polyent.hlx.ui.webView.WebViewDetailActivity;

import java.util.List;


/**
 * Created by crazysun on 16/3/1.
 */

class ViewHolder {
    public TextView title;
    public NoScrollGridView gridview;
}

class ViewHolder2 {
    public ImageView imgView;
    public TextView title;
}

/**
 * Created by crazysun on 16/2/29.
 */
public class DiscoverListViewAdapter extends MyBaseAdapter {

    public DiscoverListViewAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.discover_content_listview_item, null);
            holder.title = (TextView) convertView.findViewById(R.id.textView);
            holder.gridview = (NoScrollGridView) convertView.findViewById(R.id.gridview);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        DiscoverItemModel model = (DiscoverItemModel) models.get(position);
        holder.title.setText("   " + model.getTitle());

        final List<ItemModel> item = model.getVal();

        if (holder.gridview != null) {

            holder.gridview.setAdapter(new BaseAdapter() {
                @Override
                public int getCount() {
                    return item.size();
                }

                @Override
                public Object getItem(int position) {
                    return item.get(position);
                }

                @Override
                public long getItemId(int position) {
                    return position;
                }

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    ViewHolder2 holder = null;
                    if (convertView == null) {
                        holder = new ViewHolder2();
                        convertView =
                                mInflater.inflate(R.layout.gridview_item, null, false);
                        holder.title = (TextView) convertView.findViewById(R.id.textView);
                        holder.imgView = (ImageView) convertView.findViewById(R.id.imgView);

                        convertView.setTag(holder);

                    } else {
                        holder = (ViewHolder2) convertView.getTag();
                    }
                    final ItemModel itemModel = item.get(position);
                    holder.title.setText(itemModel.getName());
                    Glide.with(mContext)
                            .load(itemModel.getCover())
                            .placeholder(R.drawable.loading)
                            .crossFade()
                            .into(holder.imgView);

                    convertView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(mContext, WebViewDetailActivity.class);
                            intent.putExtra("url",itemModel.getUrl());
                            mContext.startActivity(intent);
                        }
                    });
                    return convertView;
                }
            });
        }
        return convertView;
    }

}