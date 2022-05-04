package com.example.android_project.Login;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.android_project.Common.AskTask;
import com.example.android_project.Common.CommonMethod;
import com.example.android_project.Common.CommonVal;
import com.google.gson.Gson;

import java.io.InputStreamReader;

public class MemberDAO {

    LoginSoloAdapter adapter;
    Context context;

    public MemberDAO(Context context) {
        this.context = context;
    }

    public MemberDAO(LoginSoloAdapter adapter){
        this.adapter = adapter;
    }

        public boolean isMemberLogin(){
            Log.d("TAG", "onClick: ");
            AskTask task = new AskTask("login");
            task.addParam("id", adapter.test_id.getText().toString());
            task.addParam("pw", adapter.test_pw.getText().toString());
            //어떤 요청을 Spring에다가 하면 ( Request )
            //어떤 요청에 대한 응답을 하면  ( Response)
            //파라메터 추가해서 보내보기 ( 스프링 콘솔창에 출력 )
            InputStreamReader isr = CommonMethod.executeAskGet(task);//
            Gson gson = new Gson();
            //vo 형태의 클래스 타입 오브젝트는 스트링 타입으로 바꿀 수 없어서 에러
            // Log.d("TAG", "onClick: " + gson.fromJson(isr , String.class));//<=확인 후 DTO작업
            MemberVO vo = gson.fromJson(isr, MemberVO.class);
            if (vo != null) {
                CommonVal.loginInfo = vo;
                return true;
            } else {
                //Log.d(TAG, "onClick: " + vo.getId());
                Toast.makeText(context, "아이디 또는 비밀번호가 틀립니다.", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
}
