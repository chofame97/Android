package com.example.project02_cloneapp.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.project02_cloneapp.R;

import java.util.ArrayList;

public class ViewFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view, container, false);
        RecyclerView rec_view = v.findViewById(R.id.rec_view);


        ArrayList<ViewDTO> list = new ArrayList<>();
        list.add(new ViewDTO(R.drawable.etc , R.drawable.search , "엄청난 기사 제목"
        ,   "엄청난 소식" , "엄청난 소식 2"
        ));
        list.add(new ViewDTO(R.drawable.shopping , R.drawable.search , " 홍길동 기사 제목"
                ,   "홍길동 소식" , "홍길동 소식 2"
        ));
        list.add(new ViewDTO(R.drawable.talk , R.drawable.user , "성춘향 기사 제목"
                ,   "성춘향 소식" , "성춘향 소식 2"
        ));
        list.add(new ViewDTO(R.drawable.etc , R.drawable.search , "이몽룡 기사 제목"
                ,   "이몽룡 소식" , "이몽룡 소식 2"
        ));
        list.add(new ViewDTO(R.drawable.ic_launcher_foreground , R.drawable.search , " 변사또 기사 제목"
                ,   "변사또 소식" , "변사또 소식 2"
        ));


        //=== 그리드뷰(세로) , 리스트뷰(세로) != 리사이클러뷰(가로,세로)
        RecyclerView.LayoutManager manager =new LinearLayoutManager(
                getContext() , RecyclerView.VERTICAL , false
        );//    ↑액티비티에서받아옴, 방향지정        , 반대로보이기(반전)
        ViewAdapter adapter = new ViewAdapter(inflater , list);
        //==================
        rec_view.setAdapter(adapter);
        rec_view.setLayoutManager(manager);

        return v;
    }
}