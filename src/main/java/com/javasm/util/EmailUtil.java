package com.javasm.util;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;
public class EmailUtil {
    public static void sendEmail(String toEmail,String userName) throws MessagingException, GeneralSecurityException, javax.mail.MessagingException{
        Properties properties = new Properties();

        properties.setProperty("mail.host","smtp.163.com");

        properties.setProperty("mail.transport.protocol","smtp");

        properties.setProperty("mail.smtp.auth","true");


        properties.put("mail.smtp.ssl.enable", "true");

        //创建一个session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("18062022696@163.com","PKZOURSBKOBUEDDT");
            }
        });

        //开启debug模式
        session.setDebug(true);

        //获取连接对象
        Transport transport = session.getTransport();

        //连接服务器
        transport.connect("smtp.163.com","18062022696@163.com","EAVGOJQAZINIUIDP");

        //创建邮件对象
        MimeMessage mimeMessage = new MimeMessage(session);

        //邮件发送人
        mimeMessage.setFrom(new InternetAddress("18062022696@163.com"));

        //邮件接收人
        mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));

        //邮件标题
        mimeMessage.setSubject("医彩登录邀请");

        //邮件内容
        mimeMessage.setContent("你的主管"+userName+"邀请您登录医彩药事，网址为http://localhost:8080/,账号为"+toEmail+"密码为123456","text/html;charset=UTF-8");

        //发送邮件
        transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());

        //关闭连接
        transport.close();

    }
}
