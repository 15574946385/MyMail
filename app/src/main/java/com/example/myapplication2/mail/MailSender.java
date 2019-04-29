package com.example.myapplication2.mail;

import java.util.Properties;

import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
    String TAG="MailSender";
    /**
     * 以文本格式发送邮件
     */
    public boolean sendTextMail(final MailInfo mailInfo){
        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        if (mailInfo.isValidate()) {
            Log.d(TAG,"需要验证身份");
            // 如果需要身份认证，则创建一个密码验证器
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        Log.d(TAG,"构造session");
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        Log.d(TAG,"session构造完毕");
        try{
            Log.d(TAG,"创建地址和人物");
            //根据session创建一个邮件消息
            MimeMessage mailMessage =new MimeMessage(sendMailSession);
            //创建邮件发送地址
            Address from=new InternetAddress(mailInfo.getFromAddress());
            //设置邮件发送者
            mailMessage.setFrom(from);
            //创建邮件接受者地址，并设置到邮件消息中
            Address to =new InternetAddress(mailInfo.getToAddress());
            mailMessage.setRecipient(Message.RecipientType.TO,to);

            //设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());

            //设置i邮件发送的时间
            mailMessage.setSentDate(new Date());

            //设置邮件消息的主要内容
            String mailContent=mailInfo.getContent();
            Log.d(TAG,"发送中");
            mailMessage.setText(mailContent);
            Transport.send(mailMessage);
            Log.d(TAG,"发送成功");

            return true;
        }  catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
