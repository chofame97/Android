package com.example.project02_cloneapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_cloneapp.R;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder>{

    LayoutInflater inflater;
    ArrayList<ViewDTO> list ;

    public ViewAdapter(LayoutInflater inflater, ArrayList<ViewDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    public ViewAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = inflater.inflate(R.layout.item_view , parent , false);
//        ViewHolder viewHolder = new ViewHolder(v);
//        return viewHolder;
        //
        return new ViewHolder(inflater.inflate(R.layout.item_view , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.img1.setImageResource(list.get(i).getImg1());
        holder.img2.setImageResource(list.get(i).getImg2());
        holder.tv_title.setText(list.get(i).getTitle());
        holder.tv_news_title1.setText(list.get(i).getNews_title1());
        holder.tv_news_title1.setText(list.get(i).getNews_title2());
    }

    @Override
    public int getItemCount() {
        //list.size != null.size <= nullPointerException
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img1 , img2 ;
        TextView tv_title , tv_news_title1 , tv_news_title2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img1 = itemView.findViewById(R.id.imgv1);
            img2 = itemView.findViewById(R.id.imgv2);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_news_title1 = itemView.findViewById(R.id.tv_news_title1);
            tv_news_title2 = itemView.findViewById(R.id.tv_news_title2);
        }
    }
}
