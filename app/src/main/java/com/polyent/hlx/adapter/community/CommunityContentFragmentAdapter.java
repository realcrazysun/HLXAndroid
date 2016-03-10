package com.polyent.hlx.adapter.community;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.polyent.hlx.R;
import com.polyent.hlx.adapter.MyBaseAdapter;
import com.polyent.hlx.adapter.chat.ChatFragmentAdapter;
import com.polyent.hlx.base.NoScrollGridView;
import com.polyent.hlx.ui.bean.chat.ChatUIModel;
import com.polyent.hlx.ui.bean.community.CommuityBlockModel;
import com.polyent.hlx.ui.bean.community.CommunityModel;
import com.polyent.hlx.ui.bean.discover.ItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crazysun on 16/3/9.
 */
public class CommunityContentFragmentAdapter extends MyBaseAdapter

{
    private CommunityModel mCommunityModel;
    private GridView gridView;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_CONTENT = 1;
    public static final int TYPE_COUNT = 2;

    private Context mContext;

    public CommunityContentFragmentAdapter(Context context) {

        super(context);
        mContext = context;
    }


    @Override
    public int getCount() {

        return models.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return TYPE_HEADER;
        } else {
            return TYPE_CONTENT;
        }
    }

    @Override
    public int getViewTypeCount() {

        return TYPE_COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int type = getItemViewType(position);
        switch (type) {
            case TYPE_HEADER: {
                HeaderView holder = null;
                if (convertView == null) {
                    holder = new HeaderView();
                    convertView = mInflater.inflate(R.layout.community_header_view, null);
                    holder.viewPager = (ViewPager) convertView.findViewById(R.id.viewPager);
                    convertView.setTag(holder);
                } else {
                    holder = (HeaderView) convertView.getTag();
                }
                if (mCommunityModel == null) {
                    break;
                }


                List listViews = new ArrayList<View>();
                int pages = mCommunityModel.getRecommend().size() / 8 + (mCommunityModel.getRecommend().size() % 8 == 0?0:1);
                for (int i = 0; i < pages; i++) {

                    View view = LayoutInflater.from(mContext).inflate(
                            R.layout.community_header_view_viewpager, null);

                    holder.gridview = (NoScrollGridView) view.findViewById(R.id.gridview);
                    gridView = holder.gridview;
                    final List<CommuityBlockModel> item = mCommunityModel.getRecommend().subList(i * 8, (i + 1) * 8);
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
                                GridViewItem holder = null;
                                if (convertView == null) {
                                    holder = new GridViewItem();
                                    convertView =
                                            mInflater.inflate(R.layout.gridview_item, null, false);
                                    holder.name = (TextView) convertView.findViewById(R.id.textView);
                                    holder.imageView = (ImageView) convertView.findViewById(R.id.imgView);
                                    convertView.setTag(holder);

                                } else {
                                    holder = (GridViewItem) convertView.getTag();
                                }
                                CommuityBlockModel itemModel = item.get(position);
                                holder.name.setText(itemModel.getName());
                                Glide.with(mContext)
                                        .load(itemModel.getLogo())
                                        .placeholder(R.drawable.loading)
                                        .crossFade()
                                        .into(holder.imageView);
                                return convertView;
                            }
                        });
                    }

                    listViews.add(view);
                    holder.viewPager.setAdapter(new CommunityHeaderViewPagerAdapter(listViews));
                }
                break;
            }
            case TYPE_CONTENT: {

                ContentView holder = null;
                if (convertView == null) {
                    holder = new ContentView();
                    convertView = mInflater.inflate(R.layout.chat_listview_item, null);
                    holder.name = (TextView) convertView.findViewById(R.id.name);
                    holder.subTitle = (TextView) convertView.findViewById(R.id.subTitle);
                    holder.imageView = (ImageView) convertView.findViewById(R.id.imgView);
                    convertView.setTag(holder);
                } else {
                    holder = (ContentView) convertView.getTag();
                }
                ChatUIModel model = (ChatUIModel) models.get(position - 1);

                holder.name.setText(model.getName());
                holder.subTitle.setText(model.getSubTitle());
                holder.imageView.setImageResource(model.getResId());
            }
            break;
        }

        return convertView;
    }

    public class HeaderView {

        public ViewPager viewPager;
        public NoScrollGridView gridview;
    }

    public class ContentView {

        public TextView name;
        public TextView subTitle;
        public ImageView imageView;
    }

    public class GridViewItem {

        public TextView name;
        public ImageView imageView;
    }

    public CommunityModel getmCommunityModel() {
        return mCommunityModel;
    }

    public void setmCommunityModel(CommunityModel mCommunityModel) {
        this.mCommunityModel = mCommunityModel;
    }

    public void notifyGridViewAdapterChange() {
//        gridView.getAdapter().
    }
}
