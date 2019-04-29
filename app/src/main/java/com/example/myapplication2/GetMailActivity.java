package com.example.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication2.adapter.FromMailAdapter;
import com.example.myapplication2.entity.FromMailEntity;

import java.util.ArrayList;

public class GetMailActivity extends AppCompatActivity {
    ArrayList<FromMailEntity>list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_mail);
        initList();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.get_mail_recycle);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        //设置布局管理器
        recyclerView.setLayoutManager(linearLayoutManager);
        //设置为垂直布局
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置Adapter
        FromMailAdapter adapter=new FromMailAdapter(list,this);
        recyclerView.setAdapter(adapter);
        //设置增加或删除条目的动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
    //初始化RecycleView中的列表内容
    private void initList(){
        String From="神鹰梦泽";
        String Subject="主题";
        FromMailEntity fromMailEntity=new FromMailEntity(R.mipmap.writeletter,From,Subject);
        list.add(fromMailEntity);
        FromMailEntity fromMailEntity2=new FromMailEntity(R.mipmap.writeletter,From,Subject);
        FromMailEntity fromMailEntity3=new FromMailEntity(R.mipmap.writeletter,From,Subject);
        list.add(fromMailEntity2);
        list.add(fromMailEntity3);

    }
}
