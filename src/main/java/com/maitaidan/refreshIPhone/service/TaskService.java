package com.maitaidan.refreshIPhone.service;

import java.util.Map;

import com.maitaidan.refreshIPhone.pojo.IPhoneStatus;
import com.maitaidan.refreshIPhone.pojo.IPhoneTask;

/**
 * Created by xinyu.jiang on 2015/10/9.
 */
public interface TaskService {
    void addTask(String email, IPhoneTask iPhoneTask);
    void addOnlineTask(String partNumber,String region,String email);

    IPhoneTask getTask(String email);

    Map getIPhoneStatus();

    Map<String, IPhoneStatus> getIPhoneAllStatus();

    boolean flushIPhoneOnlineStatus(String partNumber);
}
