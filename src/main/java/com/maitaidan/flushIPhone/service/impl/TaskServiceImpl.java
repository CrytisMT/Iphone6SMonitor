package com.maitaidan.flushIPhone.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.maitaidan.flushIPhone.pojo.IPhoneStatus;
import com.maitaidan.flushIPhone.pojo.IPhoneTask;
import com.maitaidan.flushIPhone.pojo.cnIPhoneEnum;
import com.maitaidan.flushIPhone.service.JSONService;
import com.maitaidan.flushIPhone.service.TaskService;
import com.maitaidan.flushIPhone.util.HttpRequestUtil;

/**
 * Created by xinyu.jiang on 2015/10/9.
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    JSONService jsonService;

    public void addTask(String email, IPhoneTask iPhoneTask) {

    }

    public IPhoneTask getTask(String email) {
        return null;
    }

    public Map getIPhoneStatus() {
        return null;
    }

    /**
     * 获取所有的iphone售卖状态
     * 
     * @return key:iphone value:状态
     */
    public Map<String, IPhoneStatus> getIPhoneAllStatus() {
        HashMap<String, IPhoneStatus> iPhoneALLStatus = Maps.newHashMap();
        cnIPhoneEnum[] cnIPhoneEnumValues = cnIPhoneEnum.values();

        // 请求接口获取预约json
        // todo 参数待完善
        String storeAvailableResult = HttpRequestUtil.doGet(null, null, null);
        jsonService.parseStoreAvailableJson(storeAvailableResult);
        for (cnIPhoneEnum value : cnIPhoneEnumValues) {

            iPhoneALLStatus.put(value.getPartNumber(), null);
        }

        return null;
    }
}
