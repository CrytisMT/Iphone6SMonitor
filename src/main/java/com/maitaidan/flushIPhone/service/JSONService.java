package com.maitaidan.flushIPhone.service;

/**
 * Created by xinyu.jiang on 2015/10/12.
 */
public interface JSONService {

    public void parseStoreAvailableJson(String json);

    public boolean isIPhoneOnlineAvailable(String json);
}
