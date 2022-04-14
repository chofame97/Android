package com.example.cloneapp.MainView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cloneapp.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    RecyclerView home_frag;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_home, container, false);
        home_frag = v.findViewById(R.id.home_frag);



        ArrayList<MemberDTO> list = new ArrayList<>();
        for(int i = 0; i<2;i++){
            list.add(new MemberDTO("라코스테 상의 사이즈미스로 판매","서구 농성동 9분전","80,000원", R.drawable.home_img1));
            list.add(new MemberDTO("유니클로 M사이즈 상의","북구 중흥동 13분전","30,000원", R.drawable.home_img2));
            list.add(new MemberDTO("갤럭시S20 팜","북구 중흥동 16분전","300,000원",R.drawable.home_img3));
            list.add(new MemberDTO("ㄴ이사람 사기꾼임","북구 중흥동 16분전","무료나눔", R.drawable.login));
            list.add(new MemberDTO("가구 가져가실분","서구 금호1동 1시간 전","무료나눔", R.drawable.home_img4));
            list.add(new MemberDTO("갤럭시S20 울트라 자급제","광산구 수완동 1일전","530,000원",R.drawable.home_img5));
            list.add(new MemberDTO("깔끔한 옷","광산구 하남동 2일전","10,000원",R.drawable.home_img6));
            list.add(new MemberDTO("깔끔한 옷2","광산구 하남동 2일전","10,000원",R.drawable.home_img7));
        }

        HomeAdapter adapter = new HomeAdapter(inflater,list);
        home_frag.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
          getContext(), RecyclerView.VERTICAL, false
        );
        home_frag.setLayoutManager(manager);
        return v;
    }
}