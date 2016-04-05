package com.polyent.hlx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crazysun on 16/3/1.
 */
public abstract class MyBaseAdapter extends BaseAdapter{
    protected ArrayList models = new ArrayList();
    protected LayoutInflater mInflater = null;
    protected Context mContext;
    public MyBaseAdapter(){

    }
    public MyBaseAdapter(Context context){
        super();
        mContext = context;
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public ArrayList getModels() {
        return models;
    }

    public void setModels(ArrayList models) {
        this.models = models;
    }



    public void addModels(List arr){
        models.addAll(arr);
    }

    public void clearModels(){
        models.clear();
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {

        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
