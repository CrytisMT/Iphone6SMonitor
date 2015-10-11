package com.maitaidan.flushIPhone.service.impl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.maitaidan.flushIPhone.pojo.IPhoneTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.maitaidan.flushIPhone.service.CacheService;

/**
 * Created by xinyu.jiang on 2015/10/9.
 */
@Service
public class CacheServiceImpl implements CacheService {

    private Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);

    private LoadingCache<String, IPhoneTask> taskCache = CacheBuilder.newBuilder().expireAfterAccess(20, TimeUnit.DAYS)
            .build(new CacheLoader<String, IPhoneTask>() {
                @Override
                public IPhoneTask load(String email) throws Exception {
                    logger.error("没有缓存，不应该啊");
                    return null;
                }
            });

    public void addTaskCache(String email, IPhoneTask iPhoneTask) {
        // TODO email是key，不支持同一个email多个任务
        taskCache.put(email, iPhoneTask);
    }

    public IPhoneTask getTaskByEmail(String email) {
        try {
            return taskCache.get(email);
        } catch (ExecutionException e) {
            logger.error("获取task出错", e);
        }
        return null;
    }

}
