package com.example.android_project.MainMenu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_project.R;

public class MenuAdapter1 extends RecyclerView.Adapter<MenuAdapter1.ViewHolder>{
    LayoutInflater inflater;

    public MenuAdapter1(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    // 메인 화면 중앙 메뉴 1번
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_main_menu1,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
