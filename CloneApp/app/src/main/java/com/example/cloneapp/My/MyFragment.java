package com.example.cloneapp.My;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cloneapp.R;

import java.util.ArrayList;


public class MyFragment extends Fragment {
    RecyclerView list_my,list_main;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my, container, false);
        list_my = v.findViewById(R.id.list_my);
      //  list_main =v.findViewById(R.id.list_my_main);
        ArrayList<MyDTO> list = new ArrayList<>();

        list.add(new MyDTO("당근가계부", R.drawable.home));
        list.add(new MyDTO("받은 쿠폰함", R.drawable.gps));
        list.add(new MyDTO("내 단골 가게", R.drawable.life));
        list.add(new MyDTO("동네생활 글/댓글", R.drawable.chat_s));
        list.add(new MyDTO("동네 가게 후기", R.drawable.home_s));
        list.add(new MyDTO("비즈프로필 만들기", R.drawable.home));
        list.add(new MyDTO("동네홍보 글", R.drawable.home));
        list.add(new MyDTO("지역광고", R.drawable.home));
        list.add(new MyDTO("친구초대", R.drawable.home));
        list.add(new MyDTO("공지사항", R.drawable.home));
        list.add(new MyDTO("자주 묻는 질문", R.drawable.home));
        list.add(new MyDTO("앱 설정", R.drawable.home));
        list.add(new MyDTO("친구초대", R.drawable.home));

      //  MyAdapter2 adapter2 = new MyAdapter2(inflater);

        MyAdapter adapter = new MyAdapter(inflater,list);
        list_my.setAdapter(adapter);
      //  list_my.setAdapter(adapter2);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext(), RecyclerView.VERTICAL, false
        );
        list_my.setLayoutManager(manager);


        return v;
    }
}