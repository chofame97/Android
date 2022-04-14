package com.example.cloneapp.MainView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cloneapp.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    LayoutInflater inflater;
    ArrayList<MemberDTO> list;

    public HomeAdapter(LayoutInflater inflater, ArrayList<MemberDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.location.setText(list.get(position).getLocation());
        holder.price.setText(list.get(position).getPrice());
        holder.imgh.setImageResource(list.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
	// d
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,location,price;
        ImageView imgh;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.title);
            this.location = itemView.findViewById(R.id.location);
            this.price = itemView.findViewById(R.id.price);
            this.imgh = itemView.findViewById(R.id.imgh);
        }
    }

}
