package com.example.sp_connspring2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ArrayAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_acitivity);

        findViewById(R.id.tee).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<TestDTO> list = new ArrayList<>();
                Gson gson = new Gson();
                for(int i = 0;i<10;i++){
                    list.add(new TestDTO("id"+i,"pw"+i));
                } // Spring (ArrayList) => String(json) => AskTask(json) => Spring
                String data = gson.toJson(list);

                AskTask task = new AskTask("testlist",data);
                try {
                    InputStream in = task.execute().get(5000,TimeUnit.MILLISECONDS);
                    //String test = gson.fromJson(new InputStreamReader(in),String.class);
                    list = gson.fromJson(new InputStreamReader(in),new TypeToken<List<TestDTO>>(){}.getType());
                    for(int i =0;i<list.size();i++){
                        Log.d("TAG", "onClick: "+list.get(i).getId());
                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }

            }
        });




     //   Log.d("tag", "onCreate: "+data);
        // data를 어싱크테스크를 이용해서 Spring에 보내기 (reqmapping(testlist)<=)
        // 스프링 콘솔에
        // {"id":"id0","pw":"pw0"},{"id":"id1","pw":"pw1"},{"id":"id2","pw":"pw2"},{"id":"id3","pw":"pw3"},{"id":"id4","pw":"pw4"},{"id":"id5","pw":"pw5"},{"id":"id6","pw":"pw6"},{"id":"id7","pw":"pw7"},{"id":"id8","pw":"pw8"},{"id":"id9","pw":"pw9"}
    }

}