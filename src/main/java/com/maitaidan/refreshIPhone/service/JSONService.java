package com.maitaidan.refreshIPhone.service;

/**
 * Created by xinyu.jiang on 2015/10/12.
 */
public interface JSONService {

     void parseStoreAvailableJson(String json);

     boolean isIPhoneOnlineAvailable(String json);
}
