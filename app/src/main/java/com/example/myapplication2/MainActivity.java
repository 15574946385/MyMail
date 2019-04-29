package com.example.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication2.adapter.get_Mail_Adapter;
import com.example.myapplication2.entity.MailEntity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MailEntity>list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycle_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        //设置布局管理器
        recyclerView.setLayoutManager(linearLayoutManager);
        //设置为垂直布局
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置Adapter
        get_Mail_Adapter adapter=new get_Mail_Adapter(list,this);
        recyclerView.setAdapter(adapter);
        //设置增加或删除条目的动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
    //初始化RecycleView中的列表内容
    private void initList(){
        MailEntity mailEntity=new MailEntity(R.mipmap.writeletter,"写信");
        list.add(mailEntity);
        MailEntity mailEntity2=new MailEntity(R.mipmap.getmail,"收信");
        MailEntity mailEntity3=new MailEntity(R.mipmap.garbege,"垃圾箱");
        list.add(mailEntity2);
        list.add(mailEntity3);
    }
}
