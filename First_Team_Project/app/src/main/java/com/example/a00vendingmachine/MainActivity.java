package com.example.a00vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_coke,btn_cider,btn_demisoda,btn_fanta,btn_in,btn_change;
    EditText text_in;
    TextView text_in2,text_coke,text_cider,text_fanta,text_demisoda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MachineDAO dao = new MachineDAO();
        MachineDTO dto = new MachineDTO();


        // 음료수 주문하기 버튼
        btn_coke=findViewById(R.id.btn_coke);
        btn_cider=findViewById(R.id.btn_cider);
        btn_fanta=findViewById(R.id.btn_fanta);
        btn_demisoda=findViewById(R.id.btn_demisoda);

        // 음료수 남은 개수 text
        dto.setText_coke(text_coke=findViewById(R.id.text_coke));
        dto.setText_cider(text_cider=findViewById(R.id.text_cider));
        dto.setText_fanta(text_fanta=findViewById(R.id.text_fanta));
        dto.setText_demisoda(text_demisoda=findViewById(R.id.text_demisoda));


        // 금액입력 버튼
        btn_in=findViewById(R.id.btn_in);
        // 금액입력칸
        dto.setText_in(text_in =findViewById(R.id.text_in));
        // 잔액표시
        dto.setText_in2(text_in2=findViewById(R.id.text_in2));
        // 잔돈 반환 버튼
        btn_change=findViewById(R.id.btn_change);


        ArrayList<MachineDTO> list   = new ArrayList<>();
        list.add(new MachineDTO("콜라",800,10));
        list.add(new MachineDTO("사이다",800,10));
        list.add(new MachineDTO("환타",700,10));
        list.add(new MachineDTO("데미소다",700,10));


        // 콜라 주문하기버튼
        btn_coke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String check=dao.call_coke(dto,list.get(0));
             Toast.makeText(MainActivity.this, ""+check, Toast.LENGTH_SHORT).show();

            }
        });// 콜라 주문하기버튼 닫음

        // 사이다 주문하기버튼
        btn_cider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check=dao.call_cider(dto,list.get(1));
                Toast.makeText(MainActivity.this, ""+check, Toast.LENGTH_SHORT).show();

            }
        });// 사이다 주문하기버튼 닫음

        // 환타 주문하기 버튼
        btn_fanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String check=dao.call_fanta(dto,list.get(2));
                Toast.makeText(MainActivity.this, ""+check, Toast.LENGTH_SHORT).show();
            }
        }); // 환타 주문하기 버튼 닫음

        // 데미소다 주문하기 버튼
        btn_demisoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check=dao.call_demisoda(dto,list.get(3));
                Toast.makeText(MainActivity.this, ""+check, Toast.LENGTH_SHORT).show();

            }
        });// 데미소다 주문하기 버튼 닫음

        // 금액입력 버튼 실행
        btn_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btn_in_re = dao.btn_ingo(dto);
                Toast.makeText(MainActivity.this, ""+btn_in_re, Toast.LENGTH_SHORT).show();
            }
        }); // 금액입력 버튼 실행 닫음


        // 잔돈 반환 버튼 실행
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                intent.putExtra("money",dto.getMoney());


                    intent.putExtra("lists",list);


                startActivity(intent);


            }

        });// 잔돈 반환 버튼 실행 닫음




    }
}