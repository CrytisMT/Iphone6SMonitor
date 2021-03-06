package com.maitaidan.IPhoneMonitor.service.impl;

import com.maitaidan.IPhoneMonitor.pojo.hkIPhoneEnum;
import com.maitaidan.IPhoneMonitor.service.CacheService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Crytis on 2015/10/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/ApplicationContext.xml")
public class CacheServiceImplTest extends TestCase {

    @Resource
    CacheService cacheService;

    @Test
    public void testGetTaskByEmail() throws Exception {
        boolean available = cacheService.isAvailableOnlineByPartNo(hkIPhoneEnum.Gold128.getPartNumber());
        System.out.println(available);
        available = cacheService.isAvailableOnlineByPartNo(hkIPhoneEnum.Gold128.getPartNumber());
        System.out.println(available);
    }
}