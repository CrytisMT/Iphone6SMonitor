package com.maitaidan.refreshIPhone.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.maitaidan.refreshIPhone.pojo.IPhoneStatus;
import com.maitaidan.refreshIPhone.pojo.onlineTask;
import com.maitaidan.refreshIPhone.pojo.StoreEnum;

/**
 * Created by xinyu.jiang on 2015/10/9.
 */
public interface TaskService {

    void addOnlineTask(String partNumber, String region, String email);

    HashSet<onlineTask> getAllOnlineTasks();

    HashSet<onlineTask> getAllStoreTasks();

    Map getIPhoneStatus();

    Map<String, IPhoneStatus> getIPhoneAllStatus();

    boolean getIPhoneOnlineStatus(String partNumber);

    Set<StoreEnum> getAppleStoreStatusByPartNO(String partNumber);

    void addStoreTask(String partNumber, String region, String email, String[] storeNO);
}
