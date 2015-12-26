package com.maitaidan.IPhoneMonitor.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.maitaidan.IPhoneMonitor.pojo.IPhoneStatus;
import com.maitaidan.IPhoneMonitor.pojo.onlineTask;
import com.maitaidan.IPhoneMonitor.pojo.StoreEnum;
import com.maitaidan.IPhoneMonitor.pojo.storeTask;

/**
 * Created by Crytis on 2015/10/9.
 */
public interface TaskService {

    void addOnlineTask(String partNumber, String region, String email);

    HashSet<onlineTask> getAllOnlineTasks();

    HashSet<storeTask> getAllStoreTasks();

    Map<String, IPhoneStatus> getIPhoneAllStatus();

    boolean getIPhoneOnlineStatus(String partNumber);

    Set<StoreEnum> getAppleStoreStatusByPartNO(String partNumber);

    void addStoreTask(String partNumber, String region, String email, String[] storeNO);
}
