package com.example.android_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_project.Login.LoginSelectActivity;
import com.example.android_project.SignUp.SignUpSelectActivity;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout mainPage;

    Button goSign,goLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Action bar 관련
        toolbar = findViewById(R.id.toolbar);
        mainPage = findViewById(R.id.mainPage);
        setSupportActionBar(toolbar);

        // 버튼 누르면 사이드 메뉴 나오고 사라짐
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mainPage, toolbar, R.string.navigation_mainPage_open, R.string.navigation_mainPage_close);
        mainPage.addDrawerListener(toggle);
        toggle.syncState();

        // 사이드 메뉴 아이콘
        toolbar.setNavigationIcon(R.drawable.nav_logo);

        // 회원가입 (테스트 버튼)
        goSign=findViewById(R.id.goSign);
        goSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpSelectActivity.class);
                startActivity(intent);
            }
        });

        // 로그인 (테스트 버튼)
        goLogin = findViewById(R.id.goLogin);
        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginSelectActivity.class);
                startActivity(intent);
            }
        });

    }
}