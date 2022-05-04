package com.example.android_project.Chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android_project.R;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder>{
    LayoutInflater inflater;//<=일반 클래스 타입(어댑터)에서는 생성할수가없음.
    ArrayList<ChatDTO> list ;

    public ChatAdapter(LayoutInflater inflater, ArrayList<ChatDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    public ChatAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_chat , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.chat_name.setText(list.get(position).getChat_name());
        holder.chat_msg.setText(list.get(position).getChat_msg());
        holder.chat_date.setText(list.get(position).getChat_date());
        Glide.with(holder.itemview)
                .load("https://cdn.notefolio.net/img/d6/3f/d63fc54819cd3fb0c319021e2e7cd6bfee951e8ce2db9e948bd828f538272da6_v1.jpg")
                .into(holder.chat_image);
    }

    //onCreateViewHolder 몇개를 붙일껀지를 지정함 ( ==> list.size() 데이터 갯수 만큼 )
    @Override
    public int getItemCount() {
        return list.size();
    }


    // -List 자료 구조 ( 추후 )
    // -Layout을 붙여서 View에 넣을수있는 객체 ( LayoutInflater ) ※ 디자인 확인 가능
    // -Context ( 토스트 창 , 새로운 액티비티 연결 등의 기능이 필요한 경우 )



    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView chat_image;
        TextView chat_name , chat_msg , chat_date;
        View itemview ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemview = itemView;
            chat_image = itemView.findViewById(R.id.chat_image);
            chat_name = itemView.findViewById(R.id.chat_name);
            chat_msg = itemView.findViewById(R.id.chat_msg);
            chat_date = itemView.findViewById(R.id.chat_date);
        }
    }
}
