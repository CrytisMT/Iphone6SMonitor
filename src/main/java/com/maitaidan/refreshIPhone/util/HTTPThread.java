package com.maitaidan.refreshIPhone.util;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.cache.LoadingCache;

/**
 * Created by xinyu.jiang on 2015/10/16.
 */
public class HTTPThread implements Runnable {

    private Logger logger = LoggerFactory.getLogger(HTTPThread.class);

    private String partNumber;
    private LoadingCache<String, Boolean> IPhoneOnlineStatusCache;

    public HTTPThread() {
    }

    public HTTPThread(String partNumber,LoadingCache<String,Boolean> loadingCache) {
        super();
        this.partNumber = partNumber;
        this.IPhoneOnlineStatusCache = loadingCache;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void run() {
        try {
            IPhoneOnlineStatusCache.get(partNumber);
        } catch (ExecutionException e) {
            logger.error("多线程刷新异常",e);
        }
    }
}
