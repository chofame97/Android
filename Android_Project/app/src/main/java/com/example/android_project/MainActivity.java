package com.example.android_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;


import com.example.android_project.Login.LoginGiupFragment;

import com.example.android_project.Chat.ChatFragment;

import com.example.android_project.Login.LoginSelectActivity;
import com.example.android_project.MainMenu.MenuFragment;
import com.example.android_project.SignUp.SignUpSelectActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout mainPage;

    BottomNavigationView btm_nav;

    Button goSign,goLogin;

    ViewFlipper v_fllipper;


    Button btn_login,btn_logout;
    NavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 메인 사진슬라이드
        v_fllipper = findViewById(R.id.mainMidMenu);

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
        goSign = findViewById(R.id.goSign);
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
        slidePic();

        // 메인 화면 (아래 메뉴버튼 클릭시 이동)
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new MenuFragment()).commit();
        btm_nav = findViewById(R.id.btm_nav);
        btm_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.talk){
                   changeFragment(new ChatFragment());
                   // 사진슬라이드 숨기기
                    v_fllipper.setVisibility(View.GONE);
                }else if (item.getItemId() == R.id.refresh){
                    changeFragment(new LoginGiupFragment());
                    v_fllipper.setVisibility(View.GONE);
                }else if (item.getItemId() == R.id.main){
                    // 사진슬라이드 보이기
                    v_fllipper.setVisibility(View.VISIBLE);
                    changeFragment(new MenuFragment());
                }
                return true;
            }
        });

        // 왼쪽 사이드 메뉴
        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_login){
                    Intent intent = new Intent(MainActivity.this, LoginSelectActivity.class);
                    startActivity(intent);

                }else if(id == R.id.nav_signup){
                    Intent intent = new Intent(MainActivity.this, SignUpSelectActivity.class);
                    startActivity(intent);
                }

                return true;
            }
        });

        btn_login = findViewById(R.id.hide);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              hideItem();
            }
        });
        btn_logout = findViewById(R.id.watch);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showItem();
            }
        });
        nav = findViewById(R.id.nav_view);
    }

    // 사이드 메뉴 숨김 (로그인)
    private void hideItem()
    {
        Menu nav_Menu = nav.getMenu();
        nav_Menu.findItem(R.id.nav_side_login).setVisible(false);
        nav_Menu.findItem(R.id.nav_side_notLogin).setVisible(true);
        nav_Menu.findItem(R.id.nav_side_menu2).setTitle("로그인 상태");
    }
    // 사이드 메뉴 보임 (로그아웃)
    private void showItem()
    {
        Menu nav_Menu = nav.getMenu();
        nav_Menu.findItem(R.id.nav_side_login).setVisible(true);
        nav_Menu.findItem(R.id.nav_side_notLogin).setVisible(false);
        nav_Menu.findItem(R.id.nav_side_menu2).setTitle("로그아웃 상태");
    }

    // 사진 슬라이드 사진 추가
    public void slidePic(){
        int[] images = {
                R.drawable.slide_pic1,
                R.drawable.slide_pic2,
                R.drawable.slide_pic3
        };
        for(int image : images) {
            fllipperImages(image);
        }
    }

    // 사진 슬라이드 구동
    private void fllipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_fllipper.addView(imageView);
        v_fllipper.setFlipInterval(4000);
        v_fllipper.setAutoStart(true);

        v_fllipper.setInAnimation(this,R.anim.slide_in_right);
        v_fllipper.setOutAnimation(this,R.anim.slide_out_left);
    }

    // 플래그먼트 이동
    public void  changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }


}