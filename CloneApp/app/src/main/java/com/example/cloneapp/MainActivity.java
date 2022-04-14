package com.example.cloneapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cloneapp.MainView.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.zip.Inflater;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottom_navi;
    ListView listView;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottom_navi=findViewById(R.id.bottom_navi);
        bottom_navi.setItemIconTintList(null);
        actionBar=getSupportActionBar();
        actionBar.setTitle("농성동∨ㅇ");

        MainActivity main = new MainActivity();
        changeFragment(new HomeFragment());

        bottom_navi=findViewById(R.id.bottom_navi);
        bottom_navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.tab1){
                    main.iconchange(item);
                    changeFragment(new HomeFragment());
                }else if(item.getItemId() == R.id.tab2){
                    main.iconchange(item);

                  //  changeFragment(new LifeFragment());
                }else if(item.getItemId() == R.id.tab3){
                    main.iconchange(item);
                    changeFragment(new HomeFragment());
                }else if(item.getItemId() == R.id.tab4){
                    main.iconchange(item);
                    changeFragment(new HomeFragment());
                }else if(item.getItemId() == R.id.tab5){
                    main.iconchange(item);
                    changeFragment(new HomeFragment());
                }else {

                    return false;
                }
                return true;
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //어떤 아이템이 선택 되었는지 또 구분할수가있음.
        //각각의 메뉴가 눌리면 logd를 이용해서 찍어보기 진행.
        //+토스트창도 띄우기(뮤직<=)
        if(item.getItemId() == R.id.menu_music){
            Log.d("TAG", " 옵션 메뉴 이용 음악 클릭");
            Toast.makeText(this, "음악 클릭 됨", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    public void  changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }
    public void iconchange(MenuItem item){

        if(item.getItemId() == R.id.tab1){
            item.setIcon(R.drawable.home_s);

            item.setIcon(R.drawable.life);
            item.setIcon(R.drawable.gps);
            item.setIcon(R.drawable.chat);
            item.setIcon(R.drawable.my);
        }else if(item.getItemId() == R.id.tab2) {
            item.setIcon(R.drawable.home);
            item.setIcon(R.drawable.life_s);
            item.setIcon(R.drawable.gps);
            item.setIcon(R.drawable.chat);
            item.setIcon(R.drawable.my);
        }else if(item.getItemId() == R.id.tab3) {
            item.setIcon(R.drawable.home);
            item.setIcon(R.drawable.life);
            item.setIcon(R.drawable.gps_s);
            item.setIcon(R.drawable.chat);
            item.setIcon(R.drawable.my);
        }else if(item.getItemId() == R.id.tab4) {
            item.setIcon(R.drawable.home);
            item.setIcon(R.drawable.life);
            item.setIcon(R.drawable.gps);
            item.setIcon(R.drawable.chat_s);
            item.setIcon(R.drawable.my);
        }else if(item.getItemId() == R.id.tab5) {
            item.setIcon(R.drawable.home);
            item.setIcon(R.drawable.life);
            item.setIcon(R.drawable.gps);
            item.setIcon(R.drawable.chat);
            item.setIcon(R.drawable.my_s);
        }
    }
}