package com.example.father;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity2 extends AppCompatActivity {
    TextView t1, t2, t3;
    final String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        String json = "";

        // 영화정보
        try {
            // 바이트 단위로저장
            InputStream is = getAssets().open("TestJson.json");

            // 해당파일 바이트 크기 저장
            int fileSize = is.available();

            // 파일 크기에 맞는 배열 생성
            byte[] buffer = new byte[fileSize];
            // 배열 읽어옴
            is.read(buffer);

            // InputStream 닫음
            is.close();

            // UTF-8로 변환하고 읽어온 배열을 String json 에 저장
            json = new String(buffer, "UTF-8");

            //
            JSONObject jsonObject = new JSONObject(json);
            JSONArray array = jsonObject.getJSONArray("Movies");
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                Log.d(TAG, "" + object.getString("title"));
                Log.d(TAG, "" + object.getString("grade"));
                Log.d(TAG, "" + object.getString("category"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 조석 예보 (http://www.khoa.go.kr/oceangrid/khoa/takepart/openapi/openApiObsTidePreTabDataInfo.do)
        try {
            InputStream is = getAssets().open("TestApi.json");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}