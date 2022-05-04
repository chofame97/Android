package com.example.android_project.Login;

import android.app.Activity;
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

import com.example.android_project.MainActivity;
import com.example.android_project.R;

public class LoginSoloAdapter extends RecyclerView.Adapter<LoginSoloAdapter.ViewHolder> {
    EditText test_id, test_pw;
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


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.test=itemView.findViewById(R.id.test_btn);
            test_id=itemView.findViewById(R.id.test_id);
            test_pw=itemView.findViewById(R.id.test_pw);
            test.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MemberDAO dao = new MemberDAO(LoginSoloAdapter.this);
                    Log.d("아이디: ", ""+test_id.getText().toString());
                    Intent intent = new Intent(v.getContext(),MainActivity.class);
                    intent.putExtra("아이디",test_id.getText().toString());
                    intent.putExtra("num","1");
                    dao.isMemberLogin();
                    v.getContext().startActivity(intent);
                }
            });


        }
    }

}
