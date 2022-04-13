package com.example.cloneapp.mainview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.cloneapp.MemberDTO;
import com.example.cloneapp.R;

import java.util.ArrayList;


public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(
          getContext(),RecyclerView.VERTICAL,false
        );

        ArrayList<String> list = new ArrayList<>();
        list.add("ddd");
        list.add("ddd");list.add("ddd");list.add("ddd");list.add("ddd");list.add("ddd");list.add("ddd");list.add("ddd");
        MainListAdapter adapter = new MainListAdapter(inflater,list);
        RecyclerView rec_view = rootView.findViewById(R.id.rec_view);
        rec_view.setAdapter(adapter);
        rec_view.setLayoutManager(manager);

        return rootView;
    }
}