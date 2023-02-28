package com.nowcoder.community.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * The Email service.
 *
 * @author felord.cn
 * @since 2020 /1/14 23:22
 */
@Component
public class EmailService { //相当于客户端发送邮件
    /*
    * 非常重要，不能用自动装配，需要用@Resource
    * 如果用@Autowired，会爆类型错误，@AutoWried按by type自动注入的
    * @Resource是按照名字注入的，所以不会报错，
    * 这两个都是注入
    * */
    @Resource
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;


    /**
     * 发送纯文本邮件.
     *
     * @param to      目标email 地址
     * @param subject 邮件主题
     * @param text    纯文本内容
     */
    public void sendMail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}