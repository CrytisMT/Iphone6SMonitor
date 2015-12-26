package com.maitaidan.IPhoneMonitor.service;

import com.maitaidan.IPhoneMonitor.pojo.StoreEnum;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Crytis on 2015/10/12.
 */
public interface JSONService {

    HashMap<String, HashSet<StoreEnum>> parseStoreAvailableJson(String json);

    boolean isIPhoneOnlineAvailable(String json);
}
