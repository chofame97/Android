package com.example.android_project.Login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_project.MainMenu.MenuAdapter1;
import com.example.android_project.R;

import org.w3c.dom.Text;

public class LoginGiupAdapter extends RecyclerView.Adapter<LoginGiupAdapter.ViewHolder> {
    LayoutInflater inflater;
    public LoginGiupAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    // 기업 로그인만 가져다 붙임
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LoginGiupAdapter.ViewHolder(inflater.inflate(R.layout.btn_giup_login, parent , false));
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



