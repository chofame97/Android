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

public class LifeAdapter extends RecyclerView.Adapter<LifeAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<LifeDTO> list;

    public LifeAdapter(LayoutInflater inflater, ArrayList<LifeDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return  new ViewHolder(inflater.inflate(R.layout.item_list_life2,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.top_subtitle.setText(list.get(position).getTop_subtitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView top_subtitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.top_subtitle=itemView.findViewById(R.id.top_subtitle);

        }
    }

}
