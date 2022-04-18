package com.example.last_project.Employees;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.customer.CusAdapter;
import com.example.last_project.customer.CusDetailActivity;

import java.util.ArrayList;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.ViewHolder>{

    LayoutInflater inflater;
    ArrayList<EmpDTO> list;
    Context context;

    public ArrayList<EmpDTO> getList() {
        return list;
    }

    public void setList(ArrayList<EmpDTO> list) {
        this.list = list;
    }

    public EmpAdapter(LayoutInflater inflater, ArrayList<EmpDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EmpAdapter.ViewHolder( inflater.inflate(R.layout.item_recv_emp, parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,@SuppressLint("RecyclerView") int position) {
        holder.city.setText(list.get(position).getCity());
        holder.emp_no.setText(list.get(position).getEmp_no());
        holder.name.setText(list.get(position).getName());
        holder.card_cus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( context , EmpDetailActivity.class );
                intent.putExtra("dto" , list.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView emp_no,name,city;
        ImageView imgv;
        CardView card_cus1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.card_cus1 =itemView.findViewById(R.id.card_cus1);
            this.name=itemView.findViewById(R.id.name);
            this.city=itemView.findViewById(R.id.city);


        }
    }

}
