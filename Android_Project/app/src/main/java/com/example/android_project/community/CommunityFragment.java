package com.example.android_project.community;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android_project.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class CommunityFragment extends Fragment {

    TabLayout tab_layout;
    ArrayList<CommunityDTO> list;
    CommunityAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_community, container, false);

        GridView gridView = viewGroup.findViewById(R.id.grid_view);

        list = new ArrayList<>();
        list.add(new CommunityDTO(R.drawable.nav_logo,"취미","내용","종훈","동명동",
                                                        "1시간 전","궁금해요","답변하기","1"));

        adapter = new CommunityAdapter(list, inflater);
        tab_layout = viewGroup.findViewById(R.id.tab_layout);
        tab_layout.addTab(tab_layout.newTab().setText("동내질문").setId(0));
        tab_layout.addTab(tab_layout.newTab().setText("동내질문").setId(1));
        tab_layout.addTab(tab_layout.newTab().setText("동내질문").setId(2));
        tab_layout.addTab(tab_layout.newTab().setText("동내질문").setId(3));
        tab_layout.addTab(tab_layout.newTab().setText("동내질문").setId(4));
        tab_layout.addTab(tab_layout.newTab().setText("동내질문").setId(5));
        tab_layout.addTab(tab_layout.newTab().setText("동내질문").setId(6));
        tab_layout.addTab(tab_layout.newTab().setText("동내질문").setId(7));

        tab_layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                adapter.list = changeData(tab);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        gridView.setAdapter(adapter);

        return viewGroup;
    }

    public  ArrayList<CommunityDTO> changeData(TabLayout.Tab tab){
        ArrayList<CommunityDTO> list = new ArrayList<>();

        if(tab.getPosition() == 0){
            list.add(new CommunityDTO(R.drawable.nav_logo,"취미","내용","종훈","동명동",
                    "1시간 전","궁금해요","답변하기","1"));
            list.add(new CommunityDTO(R.drawable.nav_logo,"취미","내용","종훈","동명동",
                    "1시간 전","궁금해요","답변하기","1"));
            list.add(new CommunityDTO(R.drawable.nav_logo,"취미","내용","종훈","동명동",
                    "1시간 전","궁금해요","답변하기","1"));
            list.add(new CommunityDTO(R.drawable.nav_logo,"취미","내용","종훈","동명동",
                    "1시간 전","궁금해요","답변하기","1"));
        }
        if(tab.getPosition() == 1){
            list.add(new CommunityDTO(R.drawable.nav_logo,"취미","내용","종훈","동명동",
                    "1시간 전","궁금해요","답변하기","1"));
        }
        if(tab.getPosition() == 2){
            list.add(new CommunityDTO(R.drawable.nav_logo,"취미","내용","종훈","동명동",
                    "1시간 전","궁금해요","답변하기","1"));
            list.add(new CommunityDTO(R.drawable.nav_logo,"취미","내용","종훈","동명동",
                    "1시간 전","궁금해요","답변하기","1"));
            list.add(new CommunityDTO(R.drawable.nav_logo,"취미","내용","종훈","동명동",
                    "1시간 전","궁금해요","답변하기","1"));
            list.add(new CommunityDTO(R.drawable.nav_logo,"취미","내용","종훈","동명동",
                    "1시간 전","궁금해요","답변하기","1"));
        }
        if(tab.getPosition() == 3){
            list.add(new CommunityDTO(R.drawable.nav_logo,"취미","내용","종훈","동명동",
                    "1시간 전","궁금해요","답변하기","1"));
        }




        return list;
    }


}