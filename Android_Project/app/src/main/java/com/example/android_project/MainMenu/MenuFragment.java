package com.example.android_project.MainMenu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.android_project.R;


public class MenuFragment extends Fragment {
    RecyclerView rec_MainMenu1,rec_MainMenu2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_menu1, container, false);

        // 메뉴 1번
        rec_MainMenu1 = view.findViewById(R.id.rec_MainMenu1);
        RecyclerView.LayoutManager manager1 = new LinearLayoutManager(
          getContext(),RecyclerView.VERTICAL,false
        );
        rec_MainMenu1.setLayoutManager(manager1);
        MenuAdapter1 adapter1 = new MenuAdapter1(inflater);
        rec_MainMenu1.setAdapter(adapter1);

        rec_MainMenu2 = view.findViewById(R.id.rec_MainMenu2);
        RecyclerView.LayoutManager manager2 = new LinearLayoutManager(
          getContext(),RecyclerView.HORIZONTAL,false
        );
        rec_MainMenu2.setLayoutManager(manager2);
        MenuAdapter2 adapter2 = new MenuAdapter2(inflater);
        rec_MainMenu2.setAdapter(adapter2);

        return view;
    }

}