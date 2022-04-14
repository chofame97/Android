package com.example.cloneapp.My;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cloneapp.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<MyDTO> list;

    public MyAdapter(LayoutInflater inflater, ArrayList<MyDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_list_my,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.my_text.setText(list.get(position).getTxt());
        holder.my_img.setImageResource(list.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView my_img;
        TextView my_text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.my_img=itemView.findViewById(R.id.my_img);
            this.my_text=itemView.findViewById(R.id.my_text);

        }
    }

}
