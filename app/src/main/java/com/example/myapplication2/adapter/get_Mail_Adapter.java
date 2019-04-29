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

import com.example.myapplication2.GarbageActivity;
import com.example.myapplication2.GetMailActivity;
import com.example.myapplication2.entity.MailEntity;
import com.example.myapplication2.R;
import com.example.myapplication2.WriteActivity;

import java.util.List;

public class get_Mail_Adapter extends RecyclerView.Adapter<get_Mail_Adapter.ViewHolder> {
    private List<MailEntity>list;
    private Context context;
    public get_Mail_Adapter(List<MailEntity>list,Context context){
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    //完成布局绑定ViewHolder，创建ViewHolder对象
    public get_Mail_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        /**
         *         这里获取item的布局，复用时要改
         */

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_getmail,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    //数据填充
    @Override
    public void onBindViewHolder(@NonNull get_Mail_Adapter.ViewHolder viewHolder, final int position) {
        //获取图片id的方法
        viewHolder.imageView.setImageResource(list.get(position).getImageId());
        viewHolder.mText.setText(list.get(position).getName());

        viewHolder.mText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在适配器中实现跳转，需要在构造函数中把context传入
                Intent intent=new Intent();
                Class nextClass=null;
                if(position==0){
                    nextClass= WriteActivity.class;
                }
                else if(position==1){
                    nextClass= GetMailActivity.class;
                }
                else if(position==2){
                    nextClass= GarbageActivity.class;
                }
                intent.setClass(context,nextClass);
                context.startActivity(intent);
            }
        });
    }//返回list中子项的个数
    @Override
    public int getItemCount() {
        return list.size();
    }
    //在ViewHolder中完成对控件的绑定
    class ViewHolder extends RecyclerView.ViewHolder{
        /**
         * 这里获取布局中的item子项，复用时要改
         */
        ImageView imageView;
        TextView mText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_get_mail);
            mText=itemView.findViewById(R.id.item_get_mail);
        }
    }
}
