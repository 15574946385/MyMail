package com.example.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication2.listener.MyDialog;

public class WriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        EditText getMail_man=(EditText)findViewById(R.id.getMail_man_plain);
        EditText sendMail_man=(EditText)findViewById(R.id.subject_plain);
        ImageButton send_btn=(ImageButton) findViewById(R.id.send_mail_btn);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MyDialog dialog = new MyDialog(WriteActivity.this, "发送邮件", "确定发送\nYes or No!");
                dialog.show();
                dialog.setOnClickInterface(new MyDialog.onClickInterface() {
                    @Override
                    public void clickYes() {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Yes, 发送成功", Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void clickNo() {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), "no,取消发送", Toast.LENGTH_LONG).show();
                    }
                });


//                Intent intent=new Intent(WriteActivity.this,SendSucsessfulActivity.class);
//                startActivity(intent);
            }
        });


    }
}
