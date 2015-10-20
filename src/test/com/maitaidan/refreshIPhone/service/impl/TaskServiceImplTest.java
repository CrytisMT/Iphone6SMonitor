package com.maitaidan.refreshIPhone.service.impl;

import com.maitaidan.refreshIPhone.pojo.hkIPhoneEnum;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Crytis on 2015/10/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/ApplicationContext.xml"})
public class TaskServiceImplTest extends TestCase {
    @Resource
    JavaMailSenderImpl javaMailSender;
    @Test
    public void testFlushIPhoneOnlineStatus() throws Exception {
        TaskServiceImpl taskService = new TaskServiceImpl();
        taskService.flushIPhoneOnlineStatus(hkIPhoneEnum.Gold128.getPartNumber());


    }

    @Test
    public void testMail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("38006766@qq.com");
        simpleMailMessage.setSubject("test");
        simpleMailMessage.setFrom(javaMailSender.getUsername());
        simpleMailMessage.setText("haha");
        javaMailSender.send(simpleMailMessage);
    }


}