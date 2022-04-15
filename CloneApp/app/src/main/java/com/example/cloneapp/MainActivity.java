package com.example.cloneapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cloneapp.Activity.SplashActivity;
import com.example.cloneapp.Chat.ChatFragment;
import com.example.cloneapp.Life.LifeFragment;
import com.example.cloneapp.MainView.HomeFragment;
import com.example.cloneapp.My.MyFragment;
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
      //  startActivity(new Intent(this, SplashActivity.class));

        bottom_navi=findViewById(R.id.bottom_navi);
        bottom_navi.setItemIconTintList(null);
        actionBar=getSupportActionBar();
        actionBar.setTitle("농성동∨");

        MainActivity main = new MainActivity();
        changeFragment(new HomeFragment());

        MenuItem actionitem;
        actionitem=findViewById(R.id.menu_music);


        bottom_navi=findViewById(R.id.bottom_navi);
        bottom_navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.tab1){
                    actionBar.setTitle("농성동∨");
                    changeFragment(new HomeFragment());
                }else if(item.getItemId() == R.id.tab2){

                    actionBar.setTitle("농성동∨");
                    changeFragment(new LifeFragment());
                }else if(item.getItemId() == R.id.tab3){
                    actionBar.setTitle("내 근처");
                    changeFragment(new LifeFragment());
                }else if(item.getItemId() == R.id.tab4){
                    actionBar.setTitle("채팅");
                    changeFragment(new ChatFragment());
                }else if(item.getItemId() == R.id.tab5){
                    actionBar.setTitle("나의 당근");
                    changeFragment(new MyFragment());
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
        /*item.setIcon(R.drawable.home);
        item.setIcon(R.drawable.life);
        item.setIcon(R.drawable.gps);
        item.setIcon(R.drawable.chat);
        item.setIcon(R.drawable.my);
        */

       /* if(item.getItemId().){
            tab1.setIcon(R.drawable.home_s);
            tab2.setIcon(R.drawable.life);
            tab3.setIcon(R.drawable.gps);
            tab4.setIcon(R.drawable.chat);
            tab5.setIcon(R.drawable.my);
        }else if(item.getItemId() == R.id.tab2) {

            item.setIcon(R.drawable.life_s);

        }else if(item.getItemId() == R.id.tab3) {

            item.setIcon(R.drawable.gps_s);

        }else if(item.getItemId() == R.id.tab4) {

            item.setIcon(R.drawable.chat_s);

        }else if(item.getItemId() == R.id.tab5) {

            item.setIcon(R.drawable.my_s);
        }*/
    }
}