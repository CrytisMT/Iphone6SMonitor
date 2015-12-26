package com.maitaidan.IPhoneMonitor.util;

import java.util.Set;
import java.util.concurrent.ExecutionException;

import com.maitaidan.IPhoneMonitor.pojo.StoreEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.LoadingCache;

/**
 * Created by Crytis on 2015/10/16.
 */
public class HTTPThread implements Runnable {

    private Logger logger = LoggerFactory.getLogger(HTTPThread.class);

    private String partNumber;
    private LoadingCache<String, Boolean> iPhoneOnlineStatusCache;
    private LoadingCache<String, Set<StoreEnum>> appleStoreStatusCache;

    public HTTPThread() {
    }

    public HTTPThread(String partNumber,LoadingCache<String,Boolean> loadingCache,LoadingCache<String, Set<StoreEnum>> appleStoreStatusCache) {
        super();
        this.partNumber = partNumber;
        this.iPhoneOnlineStatusCache = loadingCache;
        this.appleStoreStatusCache = appleStoreStatusCache;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void run() {
        try {
            iPhoneOnlineStatusCache.get(partNumber);
            appleStoreStatusCache.get(partNumber);
        } catch (ExecutionException e) {
            logger.error("多线程刷新异常",e);
        }
    }
}
