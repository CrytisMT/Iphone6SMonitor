package com.maitaidan.flushIPhone.service;

import com.maitaidan.flushIPhone.pojo.IPhoneTask;

/**
 * Created by xinyu.jiang on 2015/10/9.
 */
public interface TaskService {
    public void addTask(String email, IPhoneTask iPhoneTask);

    public IPhoneTask getTask(String email);
}
