package com.example.cloneapp.Life;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cloneapp.R;

import java.util.ArrayList;

public class LifeAdapter2 extends RecyclerView.Adapter<LifeAdapter2.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<LifeDTO> list;

    public LifeAdapter2(LayoutInflater inflater, ArrayList<LifeDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return  new ViewHolder(inflater.inflate(R.layout.item_list_life,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.life_top1.setText(list.get(position).getLife_top1());
        holder.life_top2.setText(list.get(position).getLife_top2());
        holder.life_top3.setText(list.get(position).getLife_top3());
        holder.life_top4.setText(list.get(position).getLife_top4());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView life_top1,life_top2,life_top3,life_top4;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.life_top1=itemView.findViewById(R.id.life_top1);
            this.life_top2=itemView.findViewById(R.id.life_top2);
            this.life_top3=itemView.findViewById(R.id.life_top3);
            this.life_top4=itemView.findViewById(R.id.life_top4);

        }
    }

}
