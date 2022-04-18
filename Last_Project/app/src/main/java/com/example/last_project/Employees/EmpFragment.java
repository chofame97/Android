package com.example.last_project.Employees;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.last_project.R;

import java.util.ArrayList;


public class EmpFragment extends Fragment {

    RecyclerView recv_cus1;
    SwipeRefreshLayout swipe1;
    SearchView scv_cus1 ;
    ArrayList<EmpDTO> list;
    EmpAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_employees, container, false);

        swipe1  = v.findViewById(R.id.swipe1);
        scv_cus1  = v.findViewById(R.id.scv_cus1);
        recv_cus1 =v.findViewById(R.id.recv_cus1);
        list = selectList();
        adapter= new EmpAdapter(inflater,list,getContext());
        recv_cus1.setAdapter(adapter);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext(),RecyclerView.VERTICAL, false
        );
        scv_cus1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.setList(selectList(query));
                adapter.notifyDataSetChanged();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText == null || newText.length() < 1){
                    refreshSelect();
                }

                return false;
            }
        });

        return v ;
    }
}