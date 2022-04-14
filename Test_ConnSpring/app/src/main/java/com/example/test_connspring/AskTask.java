package com.example.test_connspring;


import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.IOException;
import java.io.InputStream;

public class AskTask extends AsyncTask<String, String, InputStream> {
    final String HTTPIP = "http://192.168.0.47";
    final String SVRPATH = "/mid/";

    HttpClient httpClient ;
    HttpPost httpPost ;
    MultipartEntityBuilder builder ;
    private String postUrl ;
    private String mapping ;

    private String data;

    public AskTask(String mapping, String data) {
        this.mapping = mapping;
        this.data = data;
    }

    @Override
    protected InputStream doInBackground(String... strings) {
        postUrl = HTTPIP + SVRPATH + mapping ;
        builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

        builder.addTextBody("testdata" , data,
                ContentType.create("Multipart/related" , "UTF-8"));

        httpClient = AndroidHttpClient.newInstance("Android");
        httpPost = new HttpPost(postUrl);
        httpPost.setEntity(builder.build());
        InputStream in = null;
        try {
            in = httpClient.execute(httpPost).getEntity().getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return in;
    }
}




