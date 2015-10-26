package com.maitaidan.refreshIPhone.service;

import java.util.Map;
import java.util.Set;

import com.maitaidan.refreshIPhone.pojo.StoreEnum;

/**
 * Created by xinyu.jiang on 2015/10/9.
 *
 */
public interface CacheService {

    boolean isAvailableOnlineByPartNo(String partNumber);

    Map<String, Boolean> getOnlineCache();

    Map<String, Set<StoreEnum>> getStoreTasks();

}
