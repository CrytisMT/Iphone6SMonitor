package com.maitaidan.IPhoneMonitor.service;

import com.maitaidan.IPhoneMonitor.pojo.StoreEnum;

import java.util.Map;
import java.util.Set;

/**
 * Created by Crytis on 2015/10/9.
 *
 */
public interface CacheService {

    boolean isAvailableOnlineByPartNo(String partNumber);

    Set<StoreEnum> getAvailableStoresByPartNo(String partNumber);

    Map<String, Boolean> getOnlineCache();

    Map<String, Set<StoreEnum>> getStoreCache();

}
