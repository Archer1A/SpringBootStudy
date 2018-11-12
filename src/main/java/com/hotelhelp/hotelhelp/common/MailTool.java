package com.hotelhelp.hotelhelp.common;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class MailTool {
    private static final String ALIDM_SMTP_HOST = "smtp.qq.com";
    private static final String ALIDM_SMTP_PORT = "25";

    public static void main(String[] args) {

        // 配置发送邮件的环境属性
        final Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.host", ALIDM_SMTP_HOST);
        props.put("mail.smtp.port", ALIDM_SMTP_PORT);

        //发件人的账号
        props.put("mail.user", "985695123@qq.com");
        //发件人的密码
        props.put("mail.password", "***********");

        //构建授权信息，用于进行smtp进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        Session maiSession = Session.getDefaultInstance(props, authenticator);
        maiSession.setDebug(true);
        // 创建邮件信息
        MimeMessage message = new MimeMessage(maiSession);

        try {
            //设置发件人邮件地址和名称。
            InternetAddress form = new InternetAddress("985695123@qq.com", "vic");
            message.setFrom(form);


            //设置收信人地址
            InternetAddress to = new InternetAddress("wangyijun@jiudianbang.com");
            message.setRecipient(MimeMessage.RecipientType.TO, to);
            //如果同时发给多人，才将上面两行替换为如下（因为部分收信系统的一些限制，尽量每次投递给一个人；同时我们限制单次允许发送的人数是30人）：
            //InternetAddress[] adds = new InternetAddress[2];
            //adds[0] = new InternetAddress("xxxxx@qq.com");
            //adds[1] = new InternetAddress("xxxxx@qq.com");
            //message.setRecipients(Message.RecipientType.TO, adds);

            // 设置邮件标题
            message.setSubject("测试邮件");
            //设置邮件的内容体
            message.setContent("测试html邮件", "text/html;charset=UTF-8");

            //发送邮件
            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();


        }

    }
}