package com.maitaidan.refreshIPhone.controller;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.maitaidan.refreshIPhone.pojo.*;
import com.maitaidan.refreshIPhone.service.CacheService;
import com.maitaidan.refreshIPhone.service.TaskService;

@Controller
public class IPhoneController {

    @Resource
    TaskService taskService;
    @Resource
    CacheService cacheService;
    private Logger logger = LoggerFactory.getLogger(IPhoneController.class);

    @RequestMapping(value = "addOnlineTask", produces = "application/x-www-form-urlencoded; charset=UTF-8")
    @ResponseBody
    public String addOnlineTask(String email, String keyword, String region, String IPhoneColor,
            String IPhoneScreenSize, String IPhoneCapacity) {
        if (StringUtils.isBlank(email)) {
            return "email是必填项";
        }
        logger.info("参数:{},{},{}", email, keyword, region);
        IPhoneEnum iPhone = null;
        if ("hk".equalsIgnoreCase(region)) {
            iPhone = hkIPhoneEnum.Gold128.getEnumByParam(IPhoneColor, IPhoneCapacity, IPhoneScreenSize);
        } else if ("cn".equalsIgnoreCase(region)) {
            iPhone = cnIPhoneEnum.Gold128.getEnumByParam(IPhoneColor, IPhoneCapacity, IPhoneScreenSize);
        }
        if (iPhone == null) {
            logger.error("获取不到iPhone型号！");
            return "获取不到iPhone型号！";
        }

        taskService.addOnlineTask(iPhone.getPartNumber(), region, email);
        return "添加在线购买监控任务成功！";
    }

    @RequestMapping("onlineStatus")
    @ResponseBody
    public Map<String, IPhoneStatus> getOnlineStatus() {
        TreeMap<String, IPhoneStatus> statusResult = Maps.newTreeMap();
        cnIPhoneEnum[] cnIPhoneEnums = cnIPhoneEnum.values();
        hkIPhoneEnum[] hkIPhoneEnums = hkIPhoneEnum.values();
        setOnlineStatusToMap(statusResult, cnIPhoneEnums);
        setOnlineStatusToMap(statusResult, hkIPhoneEnums);
        return statusResult;
    }

    @RequestMapping("storeStatus")
    @ResponseBody
    public Map getStoreStatus() {
        return cacheService.getStoreCache();
    }

    @RequestMapping("onlineTaskList")
    @ResponseBody
    public Set onlineTaskList() {

        return taskService.getAllOnlineTasks();
    }

    @RequestMapping("storeTaskList")
    @ResponseBody
    public Set storeTaskList() {
        return taskService.getAllStoreTasks();
    }

    private void setOnlineStatusToMap(TreeMap<String, IPhoneStatus> statusResult, IPhoneEnum[] iPhoneEnums) {
        for (IPhoneEnum iPhoneEnum : iPhoneEnums) {
            String partName = iPhoneEnum.getPartNumber();
            IPhoneStatus iPhoneStatus = new IPhoneStatus();
            String buyingUrl = IPhoneTask.generateBuyingUrl(iPhoneEnum);
            iPhoneStatus.setBuyingUrl(buyingUrl);
            if (buyingUrl.contains("hk")) {
                iPhoneStatus.setIphoneName("【港行】" + iPhoneEnum.getName());
            } else {
                iPhoneStatus.setIphoneName("【国行】" + iPhoneEnum.getName());
            }
            iPhoneStatus.setPartNumer(partName);
            iPhoneStatus.setIsOnline(cacheService.isAvailableOnlineByPartNo(partName));
            statusResult.put(partName, iPhoneStatus);
        }
    }

}
