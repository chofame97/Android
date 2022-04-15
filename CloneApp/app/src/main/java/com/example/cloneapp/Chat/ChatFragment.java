package com.example.cloneapp.Chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cloneapp.R;

import java.util.ArrayList;


public class ChatFragment extends Fragment {
    RecyclerView chat_frag;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chat, container, false);
        chat_frag=v.findViewById(R.id.chat_frag);

        ArrayList<ChatDTO> list=  new ArrayList<>();

        list.add(new ChatDTO("아디닥스훈트","넵 잘쓰세욥!"));
        list.add(new ChatDTO("감사합니다","쪽문?후문같은곳에있어요 비상등요"));
        list.add(new ChatDTO("sw","네,초기화 되있는것같아 그냥쓰려구여~"));
        list.add(new ChatDTO("동물의수웊","아하ㅜㅜ네ㅜㅜ"));
        list.add(new ChatDTO("이게뭐야","아이패드 무료나눔 가능할까여?"));
        list.add(new ChatDTO("참다랑어","다랑어 팝니다"));
        list.add(new ChatDTO("참치","참치캔 급쳐 합니다"));
        list.add(new ChatDTO("상어","장사꾼 아니구요 섡 이요"));
        list.add(new ChatDTO("감사합니다","쪽문?후문같은곳에있어요 비상등요"));
        list.add(new ChatDTO("감사합니다","쪽문?후문같은곳에있어요 비상등요"));
        list.add(new ChatDTO("감사합니다","쪽문?후문같은곳에있어요 비상등요"));
        list.add(new ChatDTO("감사합니다","쪽문?후문같은곳에있어요 비상등요"));

        ChatAdapter adapter = new ChatAdapter(list,inflater);

        chat_frag.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext(), RecyclerView.VERTICAL, false
        );
        chat_frag.setLayoutManager(manager);

        return v;
    }
}