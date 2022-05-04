package com.example.android_project.Login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_project.R;


public class LoginGiupFragment extends Fragment{
    RecyclerView rec_giup;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login_giup, container, false);

        rec_giup = view.findViewById(R.id.rec_giup);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
            getContext(),RecyclerView.VERTICAL,false
        );
        rec_giup.setLayoutManager(manager);
        LoginGiupAdapter adapter = new LoginGiupAdapter(inflater);
        rec_giup.setAdapter(adapter);


        return view;
    }

}