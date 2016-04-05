/*
 * Copyright (c) 2015 张涛.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.polyent.hlx.adapter.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.polyent.hlx.R;
import com.polyent.hlx.ui.bean.chat.ContactFixedItemInfo;
import com.polyent.hlx.ui.bean.chat.ContactModel;
import com.polyent.hlx.ui.bean.chat.ContactUserItemInfo;
import com.polyent.hlx.ui.bean.chat.ContactUserListItemInfo;

/**
 * 列表适配器
 *
 * @author kymjs (http://www.kymjs.com/) on 9/16/15.
 */
public class ContactAdapter extends BaseAdapter {

    private ContactModel model;
    private LayoutInflater mInflater = null;
    private Context mContext;


    public ContactModel getModel() {
        return model;
    }

    public void setModel(ContactModel model) {
        this.model = model;
    }


    public ContactAdapter() {

    }

    public ContactAdapter(Context context) {
        super();
        mContext = context;
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        int ret = model.getFixed().size();
        for (ContactUserListItemInfo contactUserListItemInfo : model.getList()) {
            ret += contactUserListItemInfo.getList().size();
        }
        return ret;
    }

    @Override
    public Object getItem(int position) {
        if (position < model.getFixed().size()) {
            return model.getFixed().get(position);
        } else {
            int tmp = model.getFixed().size();
            int i = 0;
            while (tmp <= position) {

                if ((tmp + model.getList().get(i).getList().size()) > position) {
                    return model.getList().get(i).getList().get(position - tmp);
                }
                tmp += model.getList().get(i).getList().size();
                i++;
            }
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_list_contact, null);
            holder.contactCatalog = (TextView) convertView.findViewById(R.id.contact_catalog);
            holder.contactHead = (ImageView) convertView.findViewById(R.id.contact_head);
            holder.contactTitle = (TextView) convertView.findViewById(R.id.contact_title);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String category = getSectionForPosition(position);
        if (category != null) {
            holder.contactCatalog.setText(category);
        } else {
            holder.contactCatalog.setVisibility(View.GONE);
        }

        if (position < model.getFixed().size()) {
            ContactFixedItemInfo info = (ContactFixedItemInfo) getItem(position);
            holder.contactTitle.setText(info.getNickname());
            Glide.with(mContext)
                    .load(info.getAvatar())
                    .placeholder(R.drawable.loading)
                    .crossFade()
                    .into(holder.contactHead);
        }else{
            ContactUserItemInfo info = (ContactUserItemInfo) getItem(position);
            holder.contactTitle.setText(info.getNickname());
            Glide.with(mContext)
                    .load(info.getAvatar())
                    .placeholder(R.drawable.loading)
                    .crossFade()
                    .into(holder.contactHead);
        }
        return convertView;
    }


    /**
     * 根据ListView的当前位置获取分类的首字母
     */
    public String getSectionForPosition(int position) {
        if (position < model.getFixed().size()) {
            return null;
        }
        int tmp = model.getFixed().size();
        int i = 0;
        while (tmp <= position) {
            if (tmp == position) {
                return model.getList().get(i).getLetter();
            }
            tmp += model.getList().get(i).getList().size();
            i++;
        }
        return null;
    }


    ////
//    /**
//     * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
//     */
//    public int getPositionForSection(int section) {
//        for (int i = 0; i < getCount(); i++) {
//            char firstChar = datas.get(i).getFirstChar();
//            if (firstChar == section) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    @Override
//    public Object[] getSections() {
//        return null;
//    }
    class ViewHolder {
        public TextView contactCatalog;
        public TextView contactTitle;
        public ImageView contactHead;
    }
}
