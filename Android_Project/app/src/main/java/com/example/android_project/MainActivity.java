package com.example.android_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.android_project.Chat.ChatFragment;

import com.example.android_project.Login.LoginSelectActivity;
import com.example.android_project.MainMenu.MenuFragment;
import com.example.android_project.SignUp.SignUpSelectActivity;

import com.example.android_project.community.CommunityFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{
    Toolbar toolbar;
    DrawerLayout mainPage;
    BottomNavigationView btm_nav;

    Button goSign,goLogin;

    ViewFlipper pic_Slid; // 사진슬라이드

    Button btn_login,btn_logout;

    NavigationView nav;
    LinearLayout btn_top;

    LinearLayout loginHeader;
    LinearLayout logoutHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 로그인에 따라 사이드 헤더 바뀜
        logoutHeader = findViewById(R.id.logouth);
        loginHeader = findViewById(R.id.loginh);

        // 임시로 만든 버튼
        btn_top = findViewById(R.id.btn_top);

        // 메인 사진슬라이드
        pic_Slid = findViewById(R.id.mainMidMenu);

        // Action bar 관련
        toolbar = findViewById(R.id.toolbar);
        mainPage = findViewById(R.id.mainPage);
        setSupportActionBar(toolbar);

        // 버튼 누르면 사이드 메뉴 나오고 사라짐
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mainPage, toolbar, R.string.navigation_mainPage_open, R.string.navigation_mainPage_close);
        mainPage.addDrawerListener(toggle);
        toggle.syncState();

        // 사이드 메뉴 아이콘
        // toolbar.setNavigationIcon(R.drawable.nav_logo);

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
                    pic_Slid.setVisibility(View.GONE);
                    // 임시로 만든 버튼 숨기기
                    btn_top.setVisibility(View.GONE);
                }else if (item.getItemId() == R.id.community){
                    changeFragment(new CommunityFragment());
                    pic_Slid.setVisibility(View.VISIBLE);
                    btn_top.setVisibility(View.GONE);
                }else if (item.getItemId() == R.id.main){
                    // 사진슬라이드 보이기
                    pic_Slid.setVisibility(View.VISIBLE);
                    btn_top.setVisibility(View.VISIBLE);
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
                return false;
            }
        });


        // 메인에 로그인 처리하는 버튼
        btn_login = findViewById(R.id.hide);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              loginItem();
            }
        });

        // 로그아웃 처리하는 버튼
        btn_logout = findViewById(R.id.watch);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutItem();
                Toast.makeText(MainActivity.this, "로그아웃됨", Toast.LENGTH_SHORT).show();
            }
        });

        // 사이드 메뉴 숨김(사이드 메뉴)
        nav=findViewById(R.id.nav_view);

        // 시작시 로그아웃상태 (로그인 구현하면 조건 넣고 실행하면됨)
        Menu nav_Menu = nav.getMenu();
       nav_Menu.findItem(R.id.nav_side_login).setVisible(false);
        nav_Menu.findItem(R.id.nav_side_notLogin).setVisible(true);


    }// onCreate();

    

    // 사이드 메뉴 숨김 (로그아웃)
    private void logoutItem()
    {
        logoutHeader = findViewById(R.id.logouth);
        logoutHeader.setVisibility(View.VISIBLE);
        loginHeader = findViewById(R.id.loginh);
        loginHeader.setVisibility(View.GONE);
        Menu nav_Menu = nav.getMenu();
        nav_Menu.findItem(R.id.nav_side_login).setVisible(false);
        nav_Menu.findItem(R.id.nav_side_notLogin).setVisible(true);
    }

    // 사이드 메뉴 보임 (로그인)
    private void loginItem()
    {
       logoutHeader = findViewById(R.id.logouth);
        logoutHeader.setVisibility(View.GONE);
        loginHeader = findViewById(R.id.loginh);
        loginHeader.setVisibility(View.VISIBLE);
        Menu nav_Menu = nav.getMenu();
        nav_Menu.findItem(R.id.nav_side_login).setVisible(true);
        nav_Menu.findItem(R.id.nav_side_notLogin).setVisible(false);
        nav_Menu.findItem(R.id.nav_side_menu2).setTitle("로그인 상태");
        Toast.makeText(MainActivity.this, "로그인됨", Toast.LENGTH_SHORT).show();
    }

    // 사진 슬라이드 사진 추가
    public void slidePic(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.slide_pic1);
        list.add(R.drawable.slide_pic2);
        list.add(R.drawable.slide_pic3);

        for(int image : list) {
            fllipperImages(image);
        }
    }

    // 사진 슬라이드 구동
    private void fllipperImages(int image) {
        ImageView imageView = new ImageView(this);

        // 가져온 사진 채움
        imageView.setBackgroundResource(image);

        pic_Slid.addView(imageView);

        // 사진 넘어가는 시간
        pic_Slid.setFlipInterval(4000);

        // 자동으로 계속 넘어감
        pic_Slid.setAutoStart(true);

        // 오른쪽에서 왼쪽으로
        pic_Slid.setInAnimation(this,R.anim.slide_in_right);
        pic_Slid.setOutAnimation(this,R.anim.slide_out_left);
    }

    // 플래그먼트 이동
    public void  changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }

    //뒤로가기 했을 때
    @Override
    public void onBackPressed() {
        if (mainPage.isDrawerOpen(GravityCompat.START)) {
            mainPage.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}