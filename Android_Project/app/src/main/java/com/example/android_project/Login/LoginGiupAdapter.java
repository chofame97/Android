package com.example.android_project.Login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_project.R;

public class LoginGiupAdapter extends RecyclerView.Adapter<LoginGiupAdapter.ViewHolder> {
    LayoutInflater inflater;

    public LoginGiupAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }



    // 기업 로그인만 가져다 붙임
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.btn_giup_login, parent , false);
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



