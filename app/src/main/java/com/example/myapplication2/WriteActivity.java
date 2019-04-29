package com.example.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication2.listener.MyDialog;
import com.example.myapplication2.mail.SendMailUtil;

public class WriteActivity extends AppCompatActivity {
    String TAG="WriteActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        final EditText getMail_man=(EditText)findViewById(R.id.getMail_man_plain);
        final EditText subject=(EditText)findViewById(R.id.subject_plain);
        final EditText content=(EditText)findViewById(R.id.email_content);
        ImageButton send_btn=(ImageButton) findViewById(R.id.send_mail_btn);

        //在发送按钮中设置监听，点击时打开MyDialog
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MyDialog dialog = new MyDialog(WriteActivity.this, "发送邮件", "确定发送\nYes or No!");
                dialog.show();
                dialog.setOnClickInterface(new MyDialog.onClickInterface() {
                    @Override
                    public void clickYes() {
                        dialog.dismiss();
                        SendMailUtil.send(getMail_man.getText().toString(),subject.getText().toString(),content.getText().toString());

                        Toast.makeText(getApplicationContext(), "收件人"+getMail_man.getText().toString(), Toast.LENGTH_LONG).show();
                        Log.d(TAG,"完毕");
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
