package com.example.a00vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    TextView rs,text_rs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        MachineDTO dto = new MachineDTO();
    //    ArrayList<MachineDTO> list = new ArrayList<>();

        rs=findViewById(R.id.rs);
        text_rs=findViewById(R.id.text_rs);

        int money = intent.getIntExtra("money", 0);

        ArrayList<MachineDTO> addlist = (ArrayList<MachineDTO>) intent.getSerializableExtra("lists");
        for(int i = 0; i<4;i++){

             MachineDTO count = addlist.get(i);
             if(count.getCount()<=9){
                int na =  10-count.getCount();
                String drnk = count.getDrink();

                rs.append(""+drnk+": "+na+"개\n");


             }
        }


        // 잔액
        text_rs.setText(""+money+" 원");

        // 주문 목록




    }
}