package com.nowcoder.community;


import com.nowcoder.community.util.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {
    @Autowired
    private EmailService emailService;

    @Autowired
    private TemplateEngine templateEngine; //模版引擎本来就在容器中

    @Test
    public void testTextMail() {
        emailService.sendMail("2295614203@qq.com", "TEST", "Welcome.好了....");
    }

    @Test
    public void  testHtmlMail() {
        Context context = new Context();
        context.setVariable("username", "sunday");
        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);
        emailService.sendMail("2295614203@qq.com", "HTML", content);

    }
}
