package com.example.cloneapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.cloneapp.mainview.MainFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottom_navi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottom_navi=findViewById(R.id.bottom_navi);
        bottom_navi.setItemIconTintList(null);



        bottom_navi=findViewById(R.id.bottom_navi);
        bottom_navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.tab1){

                    changeFragment(new MainFragment());
                }else if(item.getItemId() == R.id.tab2){

                    changeFragment(new MainFragment());
                }else if(item.getItemId() == R.id.tab3){

                    changeFragment(new MainFragment());
                }else if(item.getItemId() == R.id.tab4){

                    changeFragment(new MainFragment());
                }else if(item.getItemId() == R.id.tab5){

                    changeFragment(new MainFragment());
                }else {

                    return false;
                }
                return true;
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);//제발 외우지 마세요. 가져다가 쓰는부분
        //LayoutInflater<=레이아웃 붙이기 요거만 외우세요.
        return true;
    }

    public void  changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }

}