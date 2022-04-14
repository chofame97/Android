package com.example.cloneapp.Life;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cloneapp.R;

import java.util.ArrayList;


public class LifeFragment extends Fragment {
    RecyclerView list_frag_row,list_frog_col;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_life, container, false);
        list_frag_row = v.findViewById(R.id.list_frag_row);
        list_frog_col = v.findViewById(R.id.list_frag_col);

        ArrayList<LifeDTO> list = new ArrayList<>();
        list.add(new LifeDTO("동네사진전"));
        list.add(new LifeDTO("동네질문"));
        list.add(new LifeDTO("동네맛집"));
        list.add(new LifeDTO("동네소식"));
        list.add(new LifeDTO("취미생활"));
        list.add(new LifeDTO("동네사진전"));
        list.add(new LifeDTO("동네사진전"));
        list.add(new LifeDTO("동네사진전"));


        ArrayList<LifeDTO> llist = new ArrayList<>();
        llist.add(new LifeDTO("일상","붕어빵 파는곳 있을까요?","망둥어 . 광천동", "공감하기1  댓글1"));
        llist.add(new LifeDTO("일상","산책길 추천좀 해주세요","다랑어 . 광천동", "공감하기3  댓글12"));
        llist.add(new LifeDTO("일상","내용 뭐 넣지","참다랑어 . 광천동", "공감하기5  댓글2"));
        llist.add(new LifeDTO("음식","새우튀김 맛있는곳 있나요?","새우 . 광천동", "공감하기1  댓글3"));
        llist.add(new LifeDTO("일상","백반 잘하는곳 없나염","말미잘 . 광천동", "공감하기2  댓글1"));
        llist.add(new LifeDTO("일상","아 배고프다","복어 . 광천동", "공감하기3  댓글4"));
        llist.add(new LifeDTO("일상","새우버거 먹고싶다","상어 . 광천동", "공감하기1  댓글4"));


        LifeAdapter adapter = new LifeAdapter(inflater,list);
        LifeAdapter2 adapter2 = new LifeAdapter2(inflater,llist);

        list_frag_row.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext(), RecyclerView.HORIZONTAL, false
        );
        list_frag_row.setLayoutManager(manager);


        list_frog_col.setAdapter(adapter2);
        RecyclerView.LayoutManager manager2 = new LinearLayoutManager(
                getContext(), RecyclerView.VERTICAL, false
        );
        list_frog_col.setLayoutManager(manager2);

        return v;

    }


}