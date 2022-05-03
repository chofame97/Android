package com.example.android_project.Login;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;



import com.example.android_project.R;

public class LoginSelectActivity extends AppCompatActivity {
    Button btn_loginSolo,btn_loginGiup,goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_select);


        // 시작하면 개인로그인 플래그먼트 띄움
        getSupportFragmentManager().beginTransaction().replace(R.id.btn_loginChange,new LoginSoloFragment()).commit();

        btn_loginSolo = findViewById(R.id.btn_loginSolo);
        // 개인 로그인 창으로 전환
        btn_loginSolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.btn_loginChange,new LoginSoloFragment()).commit();
            }
        });

        // 기업 로그인 창으로 전환
        btn_loginGiup = findViewById(R.id.btn_loginGiup);
        btn_loginGiup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.btn_loginChange,new LoginGiupFragment()).commit();
            }
        });

        // 상단 뒤로가기 버튼
        goBack = findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }
}