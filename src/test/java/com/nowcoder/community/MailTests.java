package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
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
    private MailClient mailClient;
    @Autowired
    private TemplateEngine templateEngine;
    @Test
    public void testMailClient(){
        mailClient.sendMail("1583347703@qq.com","Test MailClient","The first send mail");
    }
    @Test
    public void testHtmlSend(){
        Context context=new Context();
        context.setVariable("username","ljw");
        String process = templateEngine.process("/mail/demo", context);
        mailClient.sendMail("1583347703@qq.com","Html",process);
    }
}
