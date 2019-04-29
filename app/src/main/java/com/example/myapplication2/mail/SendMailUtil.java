package com.example.myapplication2.mail;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.File;



public class SendMailUtil {
    final static String TAG="SendMailUtil";
    //qq
    private static final String HOST = "smtp.qq.com";
    private static final String PORT = "587";
    private static final String FROM_ADD = "183071301@qq.com";
    private static final String FROM_PSW = "racgswgsxkwnbiij";

//    //163
//    private static final String HOST = "smtp.163.com";
//    private static final String PORT = "465"; //或者465  994
//    private static final String FROM_ADD = "teprinciple@163.com";
//    private static final String FROM_PSW = "teprinciple163";
////    private static final String TO_ADD = "2584770373@qq.com";





    public static void send(String toAdd,String subject,String content){
        final MailInfo mailInfo = creatMail(toAdd);
        final MailSender sms = new MailSender();
        mailInfo.setContent(content);
        mailInfo.setSubject(subject);
        Log.d(TAG,"正在发送");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG,"进入sendTextMail");
                sms.sendTextMail(mailInfo);
            }
        }).start();
    }

    @NonNull
    private static MailInfo creatMail(String toAdd) {
        final MailInfo mailInfo = new MailInfo();
        mailInfo.setMailServerHost(HOST);
        mailInfo.setMailServerPort(PORT);
        mailInfo.setValidate(true);
        mailInfo.setUserName(FROM_ADD); // 你的邮箱地址
        mailInfo.setPassword(FROM_PSW);// 您的邮箱密码
        mailInfo.setFromAddress(FROM_ADD); // 发送的邮箱
        mailInfo.setToAddress(toAdd); // 发到哪个邮件去
        mailInfo.setSubject("Hello"); // 邮件主题
        mailInfo.setContent("Android 测试"); // 邮件文本
        return mailInfo;
    }

}
