package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class TestActivity extends AppCompatActivity {
    String key;
    String data;
    TextView textView;
    EditText editText;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textView = findViewById(R.id.textv);
        editText = findViewById(R.id.edt);

        btn = findViewById(R.id.btn);
        key= "uEf80BD3F7F7gg%2BIrpzyF6zINlrb%2Fn8guq01BZeKScFd2BQH6wpIDZiLn1g1Uf1xFxiqyuRWqOleV7BuWMpsZg%3D%3D";

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            data =data();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    textView.setText(data);
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

    }// onCreate


    String data() throws IOException {

        //각각의 정보를 넣어줍니다.
        StringBuilder urlBuilder = new StringBuilder("http://api.odcloud.kr/api/nts-businessman/v1/validate?serviceKey="+key+"b_no&returnType=XML");
        URL url = new URL(urlBuilder.toString());
        //문자열로 된 요청 url을 URL 객체로 생성.
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-type", "application/xml");

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        rd.close();
        conn.disconnect();
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        return "";
    }
}


