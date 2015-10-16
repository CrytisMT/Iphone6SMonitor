package com.maitaidan.flushIPhone.service.impl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.maitaidan.flushIPhone.pojo.IPhoneTask;
import com.maitaidan.flushIPhone.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.maitaidan.flushIPhone.service.CacheService;

import javax.annotation.Resource;

/**
 * Created by xinyu.jiang on 2015/10/9.
 */
@Service
public class CacheServiceImpl implements CacheService {

    @Resource
    TaskService taskService;


    private Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);

    private LoadingCache<String, Boolean> IPhoneOnlineStatusCache = CacheBuilder.newBuilder().expireAfterAccess(20, TimeUnit.DAYS)
            .build(new CacheLoader<String, Boolean>() {
                @Override
                public Boolean load(String partNumber) throws Exception {
                    logger.info("刷新缓存");
                    return taskService.flushIPhoneOnlineStatus(partNumber);
                }
            });

//    public void addTaskCache(String email, IPhoneTask iPhoneTask) {
//        // TODO email是key，不支持同一个email多个任务
//        IPhoneOnlineStatusCache.put(email, iPhoneTask);
//    }

    public boolean isAvailableOnlineByPartNo(String partNumber) {
        try {
            return IPhoneOnlineStatusCache.get(partNumber);
        } catch (ExecutionException e) {
            logger.error("获取task出错", e);
        }
        return false;
    }

}
