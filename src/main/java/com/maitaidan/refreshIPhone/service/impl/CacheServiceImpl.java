package com.maitaidan.refreshIPhone.service.impl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.maitaidan.refreshIPhone.pojo.cnIPhoneEnum;
import com.maitaidan.refreshIPhone.service.CacheService;
import com.maitaidan.refreshIPhone.service.TaskService;
import com.maitaidan.refreshIPhone.util.HTTPThread;

/**
 * Created by xinyu.jiang on 2015/10/9.
 */
@Service
public class CacheServiceImpl implements CacheService {

    @Resource
    TaskService taskService;

    private Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);

    private LoadingCache<String, Boolean> IPhoneOnlineStatusCache = CacheBuilder.newBuilder()
            .expireAfterAccess(20, TimeUnit.MINUTES).build(new CacheLoader<String, Boolean>() {
                @Override
                public Boolean load(String partNumber) throws Exception {
                    logger.info("刷新缓存");
                    return taskService.flushIPhoneOnlineStatus(partNumber);
                }
            });

    // public void addTaskCache(String email, IPhoneTask iPhoneTask) {
    // // TODO email是key，不支持同一个email多个任务
    // todo 手动刷新的功能
    // IPhoneOnlineStatusCache.put(email, iPhoneTask);
    // }

    public boolean isAvailableOnlineByPartNo(String partNumber) {
        try {
            return IPhoneOnlineStatusCache.get(partNumber);
        } catch (ExecutionException e) {
            logger.error("获取task出错", e);
        }
        return false;
    }

    @Scheduled(fixedDelay = 300000)
    public void refreshCache() {
        long time = System.currentTimeMillis();
        logger.info("定时任务刷新缓存，当前时间{}", time);
        IPhoneOnlineStatusCache.invalidateAll();
        cnIPhoneEnum[] cnIPhoneEnums = cnIPhoneEnum.values();

        for (cnIPhoneEnum cnIPhoneEnum : cnIPhoneEnums) {
            String partName = cnIPhoneEnum.getPartNumber();
            // isAvailableOnlineByPartNo(partName);
            HTTPThread httpThread = new HTTPThread(partName,IPhoneOnlineStatusCache);
            Thread thread = new Thread(httpThread);
            thread.start();
        }

        logger.info("刷新缓存完毕,耗时：{}", System.currentTimeMillis() - time);
    }

}
