package com.maitaidan.refreshIPhone.service;

import com.maitaidan.refreshIPhone.pojo.StoreEnum;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by xinyu.jiang on 2015/10/12.
 */
public interface JSONService {

    HashMap<String, HashSet<StoreEnum>> parseStoreAvailableJson(String json);

    boolean isIPhoneOnlineAvailable(String json);
}
