package com.polyent.hlx.ui.dynamic;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.polyent.hlx.R;

class ViewHolder {
    public ImageView animal;
    public TextView cn_word;
    public TextView en_word;
    public ImageView speaker;
}
/**
 * Created by crazysun on 16/2/29.
 */
public class AnimalListAdapter extends BaseAdapter {

    private LayoutInflater mInflater = null;
    public AnimalListAdapter(Context context){
        super();
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 50;
    }

    @Override
    public Object getItem(int position) {
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

            convertView = mInflater.inflate(R.layout.user, null);
            holder.animal = (ImageView) convertView.findViewById(R.id.animal);
            holder.cn_word = (TextView) convertView.findViewById(R.id.cn_word);
            holder.en_word = (TextView) convertView.findViewById(R.id.en_word);
            holder.speaker = (ImageView) convertView.findViewById(R.id.speaker);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.animal.setImageResource(R.drawable.ic_launcher);
        holder.cn_word.setText("xxxxx");
        holder.en_word.setText("ssssss");
        holder.speaker.setImageResource(R.drawable.app_panel_video_icon);
//        holder.speaker.setOnClickListener(new OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                System.out.println("Click on the speaker image on ListItem ");
//            }
//        });

        return convertView;
    }

}

