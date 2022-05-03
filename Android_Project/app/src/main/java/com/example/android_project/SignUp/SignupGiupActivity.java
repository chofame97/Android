package com.example.android_project.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_project.MainActivity;
import com.example.android_project.R;
import com.example.android_project.TestActivity;

import java.util.regex.Pattern;


public class SignupGiupActivity extends AppCompatActivity {
    Button btn_Signup;
    Button btn_join;
    EditText edt_id, edt_pw, edt_pw_chk, edt_name, edt_birth, edt_email, edt_phn, edt_addr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_giup);

        btn_join = findViewById(R.id.btn_join);
        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        edt_pw_chk = findViewById(R.id.edt_pw_chk);
        edt_phn = findViewById(R.id.edt_phn);
        edt_name = findViewById(R.id.edt_name);
        edt_birth = findViewById(R.id.edt_age);
        edt_email = findViewById(R.id.edt_email);
        edt_addr = findViewById(R.id.edt_addr);

        // 가입성공후 메인으로 이동
        btn_Signup = findViewById(R.id.btn_Signup);
        btn_Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /*
                // 아이디 유효성검사
                if (edt_id.getText().toString().length() == 0) {
                    Toast.makeText(SignupGiupActivity.this, "아이디를 입력하세요", Toast.LENGTH_SHORT).show();
                    edt_id.requestFocus();
                    return;
                }
                if(!Pattern.matches("^[^0-9]*[a-zA-Z][0-9]{4,15}$",edt_id.getText().toString())){
                    Toast.makeText(SignupGiupActivity.this, "4~10자 영어대소문자 또는 숫자", Toast.LENGTH_SHORT).show();
                    edt_id.requestFocus();
                    return;
                }


                // 비밀번호 유효성검사
                if (edt_pw.getText().toString().length() == 0) {
                    Toast.makeText(SignupGiupActivity.this, "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
                    edt_pw.requestFocus();
                    return;
                }
                if(!Pattern.matches("^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$",edt_pw.getText().toString())){
                    Toast.makeText(SignupGiupActivity.this, "8~20글자 비밀번호", Toast.LENGTH_SHORT).show();
                    edt_pw.requestFocus();
                    return;
                }
                // 비밀번호 확인 유효성
                if ( !edt_pw.getText().toString().equals(edt_pw_chk.getText().toString()) ) {
                    Toast.makeText(SignupGiupActivity.this, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
                    edt_pw.setText("");
                    edt_pw_chk.setText("");
                    edt_pw.requestFocus();
                    return;
                }
                if(!Pattern.matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{8,20}$\n",edt_pw_chk.getText().toString())){
                    Toast.makeText(SignupGiupActivity.this, "8~20글자 비밀번호", Toast.LENGTH_SHORT).show();
                    edt_pw_chk.requestFocus();
                    return;
                }

                // 이메일 유효성 (.co.kr 제외)
                if (!Pattern.matches("^\\w{4,11}@[a-z]{2,10}[\\.][a-z]{2,8}[\\.]?[a-z]{0,2}$",edt_email.getText().toString())) {
                    Toast.makeText(SignupGiupActivity.this, "이메일 양식이 틀림", Toast.LENGTH_SHORT).show();
                    edt_email.requestFocus();
                    return;
                }
                if (edt_email.getText().toString().length() == 0) {
                    Toast.makeText(SignupGiupActivity.this, "아이디를 입력하세요", Toast.LENGTH_SHORT).show();
                    edt_email.requestFocus();
                    return;
                }


                // 전화번호 유효성
                if (edt_phn.getText().toString().length() == 0) {
                    Toast.makeText(SignupGiupActivity.this, "아이디를 입력하세요", Toast.LENGTH_SHORT).show();
                    edt_phn.requestFocus();
                    return;
                }
                if (!Pattern.matches("^[0-9]{11}$",edt_phn.getText().toString())) {
                    Toast.makeText(SignupGiupActivity.this, "전화번호 양식이 틀림", Toast.LENGTH_SHORT).show();
                    edt_phn.requestFocus();
                    return;
                }

                // 이름 유효성
                if (edt_name.getText().toString().length() == 0) {
                    Toast.makeText(SignupGiupActivity.this, "아이디를 입력하세요", Toast.LENGTH_SHORT).show();
                    edt_name.requestFocus();
                    return;
                }
                if (!Pattern.matches("^[가-힣]{2,4}$",edt_name.getText().toString())) {
                    Toast.makeText(SignupGiupActivity.this, "이름 양식이 틀림", Toast.LENGTH_SHORT).show();
                    edt_name.requestFocus();
                    return;
                }
                 */




                Intent intent = new Intent(SignupGiupActivity.this, TestActivity.class);

                startActivity(intent);
                overridePendingTransition(0, 0);

            }
        });




    }
}