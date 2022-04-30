package com.example.android_project.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_project.R;

public class SignUpSelectActivity extends AppCompatActivity {
    Button goSelectSignUp,SignUpSolo,SignUpGiup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_select);


        // 회원가입(개인, 기업 선택)화면 - 맨위 버튼 누르면 뒤로가기 버튼과 동일한 기능
        goSelectSignUp=findViewById(R.id.goSelectSignUp);
        goSelectSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // 개인회원 가입이동
        SignUpSolo = findViewById(R.id.SignUpSolo);
        SignUpSolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goIntent(1);
            }
        });

        // 기업회원 가입이동
        SignUpGiup = findViewById(R.id.SingUpGiup);
        SignUpGiup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goIntent(2);
            }
        });


    }

    // 화면전환 처리
    public void goIntent(int number){
        switch (number){
            case 1:
                startActivity(new Intent(SignUpSelectActivity.this,SignupSoloActivity.class));
                break;
            case 2:
                startActivity(new Intent(SignUpSelectActivity.this,SignupGiupActivity.class));
                break;
            default: break;
        }

    }


}