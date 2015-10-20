package com.maitaidan.refreshIPhone.service.impl;

import com.maitaidan.refreshIPhone.pojo.IPhoneTask;
import com.maitaidan.refreshIPhone.pojo.hkIPhoneEnum;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

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
    public void testMail() throws MessagingException {
        IPhoneTask iPhoneTask = new IPhoneTask("dd", "ddd", hkIPhoneEnum.Gold128);
        iPhoneTask.setBuyingUrl("http://www.baidu.com");
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
        helper.setTo("38006766@qq.com");
        helper.setSubject("您预订的iPhone有货啦！");
        helper.setFrom(javaMailSender.getUsername());
        String content = "Hi!<br/>你所关注的" + iPhoneTask.getiPhone().getName() + "已经有货可以在线购买了！购买链接：<a href=\"" + iPhoneTask.getBuyingUrl() + "\">购买传送门！</a>" + "<br/>Powered By www.maitaidan.com";
        helper.setText(content, true);
        javaMailSender.send(mimeMessage);
    }


}