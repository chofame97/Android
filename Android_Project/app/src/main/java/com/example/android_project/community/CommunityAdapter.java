package com.example.android_project.community;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_project.R;

import java.util.ArrayList;

public class CommunityAdapter extends BaseAdapter {

    ArrayList<CommunityDTO> list;
    LayoutInflater inflater;

    public CommunityAdapter(ArrayList<CommunityDTO> list, LayoutInflater inflater) {
        this.list = list;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_community,parent,false);

        ImageView img_community_like = convertView.findViewById(R.id.img_community_like);
        //ImageView img_community_comments = convertView.findViewById(R.id.img_community_comments);
        //ImageView img_community_cnt = convertView.findViewById(R.id.img_community_cnt);
//
        img_community_like.setImageResource(list.get(position).getImg_url());
        //img_community_comments.setImageResource(list.get(position).getImg_url());
        //img_community_cnt.setImageResource(list.get(position).getImg_url());

        TextView tv_community_category = convertView.findViewById(R.id.tv_community_category);
        TextView tv_community_content = convertView.findViewById(R.id.tv_community_content);
        TextView tv_community_name = convertView.findViewById(R.id.tv_community_name);
        TextView tv_community_location = convertView.findViewById(R.id.tv_community_location);
        TextView tv_community_time = convertView.findViewById(R.id.tv_community_time);
        TextView tv_community_like = convertView.findViewById(R.id.tv_community_like);
        TextView tv_community_comments = convertView.findViewById(R.id.tv_community_comments);
        TextView tv_community_cnt = convertView.findViewById(R.id.tv_community_cnt);

        tv_community_category.setText(list.get(position).getCategory());
        tv_community_content.setText(list.get(position).getContent());
        tv_community_name.setText(list.get(position).getName());
        tv_community_location.setText(list.get(position).getLocation());
        tv_community_time.setText(list.get(position).getTime());
        tv_community_like.setText(list.get(position).getLike());
        tv_community_comments.setText(list.get(position).getComments());
        tv_community_cnt.setText(list.get(position).getCnt());









        return convertView;
    }
}
