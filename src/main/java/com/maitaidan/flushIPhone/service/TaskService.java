package com.maitaidan.flushIPhone.service;

import com.maitaidan.flushIPhone.pojo.IPhoneStatus;
import com.maitaidan.flushIPhone.pojo.IPhoneTask;

import java.util.Map;

/**
 * Created by xinyu.jiang on 2015/10/9.
 */
public interface TaskService {
    public void addTask(String email, IPhoneTask iPhoneTask);

    public IPhoneTask getTask(String email);

    public Map getIPhoneStatus();

    public Map<String,IPhoneStatus> getIPhoneAllStatus();
}
