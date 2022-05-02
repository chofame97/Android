package com.example.father;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    TextView text1,text2;
    String DataType,Date,ServiceKey,ObsCode,ResultType,REST,data;
    Button btn;
    String result = "";
    Handler handler = new Handler();
    static String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        ArrayList<String> str = new ArrayList<String>();

        DataType ="tideObsPreTab";
        Date="20160101";
        ServiceKey = "JRm9tO2859oZGUMBy34mHw==";
        ObsCode = "DT_0001";

        REST = "http://www.khoa.go.kr/api/oceangrid/DataType/search.do?ServiceKey="+ServiceKey+"&ObsCode="+ObsCode+"&Date="+Date+"&ResultType=json";

        btn= findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlStr = "http://www.khoa.go.kr/api/oceangrid/tideObsPreTab/search.do?ServiceKey=wldhxng34hkddbsgm81lwldhxng34hkddbsgm81l==&ObsCode=DT_0001&Date=20160101&ResultType=json";
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        request(urlStr);
                    }
                }).start();
            }
        });
    }

    public void request(String urlstr){
        StringBuilder output = new StringBuilder();

        try {
            URL url = new URL(urlstr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if(connection != null){
                connection.setConnectTimeout(10000);
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                int resCode = connection.getResponseCode();
                if(resCode == HttpURLConnection.HTTP_OK){
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line = null;
                    while(true){
                        line = reader.readLine();
                        if(line==null){
                            break;
                        }
                        output.append(line +"\n");
                    }
                    reader.close();
                    connection.disconnect();
                }else{
                    Toast.makeText(this, "현재 요청 상태 : "+resCode, Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "응답"+output.toString(), Toast.LENGTH_SHORT).show();
    }
    public void println(final String data){
        handler.post(new Runnable() {
            @Override
            public void run() {
                text1.append(data+"\n");
            }
        });
    }

}