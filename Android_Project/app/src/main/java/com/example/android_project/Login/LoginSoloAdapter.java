package com.example.android_project.Login;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_project.DTO;
import com.example.android_project.MainActivity;
import com.example.android_project.MainMenu.MenuAdapter1;
import com.example.android_project.R;

public class LoginSoloAdapter extends RecyclerView.Adapter<LoginSoloAdapter.ViewHolder> {
    LayoutInflater inflater;
    public LoginSoloAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LoginSoloAdapter.ViewHolder(inflater.inflate(R.layout.btn_solo_login, parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button test;
        EditText test_id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.test=itemView.findViewById(R.id.test_btn);
            this.test_id=itemView.findViewById(R.id.test_id);

            test.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("아이디: ", ""+test_id.getText().toString());
                    Intent intent = new Intent(v.getContext(),MainActivity.class);
                    intent.putExtra("아이디",test_id.getText().toString());
                    intent.putExtra("num","1");
                    v.getContext().startActivity(intent);
                }
            });


        }
    }

}
