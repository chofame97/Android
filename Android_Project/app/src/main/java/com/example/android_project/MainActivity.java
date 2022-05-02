package com.example.android_project;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.android_project.Login.LoginGiupFragment;
import com.example.android_project.Login.LoginSelectActivity;
import com.example.android_project.MainMenu.MenuFragment;
import com.example.android_project.SignUp.SignUpSelectActivity;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout mainPage;
    Button goSign,goLogin;

    ViewFlipper v_fllipper;

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

        // 사진 슬라이드
        int[] images = {
                R.drawable.slide_pic1,
                R.drawable.slide_pic2,
                R.drawable.slide_pic3
        };
        v_fllipper = findViewById(R.id.mainMidMenu);

        for(int image : images) {
            fllipperImages(image);
        }


        // 메뉴1
        getSupportFragmentManager().beginTransaction().replace(R.id.mainMenu1,new MenuFragment()).commit();
    }

    // 사진 슬라이드 구동동
    private void fllipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_fllipper.addView(imageView);
        v_fllipper.setFlipInterval(4000);
        v_fllipper.setAutoStart(true);

        v_fllipper.setInAnimation(this,R.anim.slide_in_right);
        v_fllipper.setOutAnimation(this,R.anim.slide_out_left);

    }
}