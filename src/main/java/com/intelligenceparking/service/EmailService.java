package com.intelligenceparking.service;


import com.intelligenceparking.tool.dynamicTable.DynamicRegisterTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    private static final String SENDER = "1424602142@qq.com";
    private static final int LENGTH = 10;
    /**
     * 发送普通邮件
     *
     * @param emailAddress      收件人
     */
    public void sendSimpleMailMessge(String emailAddress) {
        String subject,content,code;
        code = generateVerificationCode();
        DynamicRegisterTable.insert(emailAddress,code);
        subject = "Intelligence Parking Verification";
        content = "Your verification code is: \n"+code;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SENDER);
        message.setTo(emailAddress);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
        } catch (Exception e) {
            System.out.println("发送简单邮件时发生异常! "+ e);
        }
    }

    private String generateVerificationCode(){
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer code=new StringBuffer();
        for(int i=0;i<LENGTH;i++){
            int number=random.nextInt(str.length());
            code.append(str.charAt(number));
        }
        System.out.println(code);
        return code.toString();
    }
}
