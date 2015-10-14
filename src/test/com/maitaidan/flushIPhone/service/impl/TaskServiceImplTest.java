package com.maitaidan.flushIPhone.service.impl;

import com.maitaidan.flushIPhone.pojo.hkIPhoneEnum;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Crytis on 2015/10/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/ApplicationContext.xml"})
public class TaskServiceImplTest extends TestCase {

    @Test
    public void testFlushIPhoneOnlineStatus() throws Exception {
        TaskServiceImpl taskService = new TaskServiceImpl();
        taskService.flushIPhoneOnlineStatus(hkIPhoneEnum.Gold128.getPartNumber());


    }
}