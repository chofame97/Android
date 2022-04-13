package com.example.cloneapp.mainview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cloneapp.MemberDTO;
import com.example.cloneapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.Holderk> {
    LayoutInflater inflater;//<=화면을 붙이기 위한 객체가 필요함. ※
    ArrayList<String> list;

    public MainListAdapter(LayoutInflater inflater, ArrayList<String> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public Holderk onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_list,parent,false);
        return new Holderk(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holderk holder, int position) {
        holder.text_price.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holderk extends RecyclerView.ViewHolder{
        TextView text_title;
        TextView text_location;
        TextView text_price;
        public Holderk(@NonNull View itemView) {
            super(itemView);
            text_title=itemView.findViewById(R.id.text_title);
            text_location=itemView.findViewById(R.id.text_location);
            text_price=itemView.findViewById(R.id.text_price);
        }
    }
}
