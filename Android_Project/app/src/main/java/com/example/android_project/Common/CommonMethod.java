package com.example.android_project.Common;

import android.os.AsyncTask;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

public class CommonMethod {
    //공통으로 사용할 메소드
    static InputStream in = null;

    public static InputStreamReader executeAskGet(AsyncTask<String, String, InputStream> asktask){
        try {
            return new InputStreamReader( asktask.execute().get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
