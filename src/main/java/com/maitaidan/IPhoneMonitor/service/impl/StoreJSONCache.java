package com.maitaidan.IPhoneMonitor.service.impl;

import com.maitaidan.IPhoneMonitor.util.HttpRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by Crytis on 2015/11/6.
 * 缓存json
 */
@Component
public class StoreJSONCache {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final static String cnAppleStoreJsonUrl = "https://reserve.cdn-apple.com/CN/zh_CN/reserve/iPhone/availability.json";
    private final static String hkAppleStoreJsonUrl = "https://reserve.cdn-apple.com/HK/zh_HK/reserve/iPhone/availability.json";
    String cnJSON;
    String hkJSON;
    long time = System.currentTimeMillis() - 6 * 60 * 1000;


    public String getCnJSON() {
        isExpire();
        return cnJSON;
    }

    public void setCnJSON(String cnJSON) {
        this.cnJSON = cnJSON;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setHkJSON(String hkJSON) {
        this.hkJSON = hkJSON;
    }

    public String getHkJSON() {
        isExpire();
        return hkJSON;
    }

    private boolean isExpire() {
        long currentTime = System.currentTimeMillis();
        synchronized (logger) {
            if (currentTime - time >= 3 * 60 * 1000) {
                //如果大于3分钟就是过期
                //TODO 蛋疼
                logger.info("store json过期了,{}",currentTime-time);
                this.cnJSON = HttpRequestUtil.doGet(cnAppleStoreJsonUrl, new HashMap<String, String>(), "UTF-8");
                this.hkJSON = HttpRequestUtil.doGet(hkAppleStoreJsonUrl, new HashMap<String, String>(), "UTF-8");
                this.time = System.currentTimeMillis();
                return true;
            }
        }
        return false;

    }
}
