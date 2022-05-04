package com.example.android_project.Login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_project.R;


public class LoginSoloFragment extends Fragment {
    RecyclerView rec_solo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login_solo, container, false);

        rec_solo = view.findViewById(R.id.rec_solo);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext(),RecyclerView.VERTICAL,false
        );
        rec_solo.setLayoutManager(manager);
        LoginSoloAdapter adapter = new LoginSoloAdapter(inflater);
        rec_solo.setAdapter(adapter);
        return view;
    }
}