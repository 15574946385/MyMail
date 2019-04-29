package com.example.myapplication2.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.myapplication2.entity.FromMailEntity;
import com.example.myapplication2.entity.MailEntity;
import com.example.myapplication2.R;


import java.util.List;

public class FromMailAdapter extends RecyclerView.Adapter<FromMailAdapter.ViewHolder> {
    private List<FromMailEntity>list;
    private Context context;
    public FromMailAdapter(List<FromMailEntity>list,Context context){
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    //完成布局绑定ViewHolder，创建ViewHolder对象
    public FromMailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //这里获取item的布局，复用时要改
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_from_mail,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        //获取图片id的方法
        viewHolder.imageView.setImageResource(list.get(position).getImageId());
        viewHolder.mText1.setText(list.get(position).getFrom());
        viewHolder.mText2.setText(list.get(position).getSubject());

    }//返回list中子项的个数
    @Override
    public int getItemCount() {
        return list.size();
    }
    //在ViewHolder中完成对控件的绑定
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView mText1;
        TextView mText2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.from_mail_img);
            mText1=itemView.findViewById(R.id.from_mail_head);
            mText2=itemView.findViewById(R.id.from_mail_subject);
        }
    }
}
