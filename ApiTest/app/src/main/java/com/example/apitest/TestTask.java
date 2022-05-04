package com.example.apitest;

import android.content.res.AssetManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class TestTask {

    public String send(){
        String response = "실패";
        JSONObject jsonObject = new JSONObject();
        try {
            URL url;
            url = new URL("https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=gS7w9BBE3He%2FFTkjgInbf8iJxTmmAPaAYpTeopmJeJ6TM%2FXfi4wbAdmBZWUCcqe3l6dNktJ%2BNoClU2F5Vpr9Qg%3D%3D");

            // url 연결 객체
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

            // 요청 : post
            httpConn.setRequestMethod("POST");

            // 서버에 Response data 를 json 형식으로 요청함
            httpConn.setRequestProperty("accept", "application/json");

            //
            httpConn.setRequestProperty("Authorization", "gS7w9BBE3He/FTkjgInbf8iJxTmmAPaAYpTeopmJeJ6TM/Xfi4wbAdmBZWUCcqe3l6dNktJ+NoClU2F5Vpr9Qg==");

            // 서버에서 json 형식으로 응답받음
            httpConn.setRequestProperty("Content-Type", "application/json");

            // body 추가시에 OutputStream 을 사용하기 때문에 true 추가
            httpConn.setDoOutput(true);

            // 바디를 담을 객체
            OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());

            // 바디에 담을 내용
            writer.write("{  \"b_no\": [    \"0000000000\"  ]}");
            writer.flush();
            writer.close();
            httpConn.getOutputStream().close();

            InputStream responseStream = httpConn.getResponseCode() / 100 == 2
                    ? httpConn.getInputStream()
                    : httpConn.getErrorStream();
            Scanner s = new Scanner(responseStream).useDelimiter("\\A");
            response = s.hasNext() ? s.next() : "";

            StringBuffer sb = new StringBuffer();
            JSONArray jsonArray = new JSONArray(response);
            for(int i =0;i<jsonArray.length();i++){
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                String utcc_yn = jsonObject1.getString("utcc_yn");

                sb.append("사업자 등록 확인(y/n):" +utcc_yn);

            }



        } catch (Exception e) {
            Log.d("error", "send: ");
        }

        return response;
    }


}
