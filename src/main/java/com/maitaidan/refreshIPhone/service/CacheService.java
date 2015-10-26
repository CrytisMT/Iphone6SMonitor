package com.maitaidan.refreshIPhone.service;

import com.maitaidan.refreshIPhone.pojo.StoreEnum;

import java.util.Map;
import java.util.Set;

/**
 * Created by xinyu.jiang on 2015/10/9.
 *
 */
public interface CacheService {

    boolean isAvailableOnlineByPartNo(String partNumber);

    Map<String, Boolean> getOnlineCache();

    Map<String, Set<StoreEnum>> getStoreCache();

}
