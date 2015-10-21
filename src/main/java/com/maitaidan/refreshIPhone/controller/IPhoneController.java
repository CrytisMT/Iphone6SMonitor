package com.maitaidan.refreshIPhone.controller;

import com.google.common.collect.Maps;
import com.maitaidan.refreshIPhone.pojo.IPhoneEnum;
import com.maitaidan.refreshIPhone.pojo.IPhoneStatus;
import com.maitaidan.refreshIPhone.pojo.cnIPhoneEnum;
import com.maitaidan.refreshIPhone.pojo.hkIPhoneEnum;
import com.maitaidan.refreshIPhone.service.CacheService;
import com.maitaidan.refreshIPhone.service.TaskService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Controller
public class IPhoneController {

    private Logger logger = LoggerFactory.getLogger(IPhoneController.class);
    @Resource
    TaskService taskService;
    @Resource
    CacheService cacheService;

    @RequestMapping(value = "addOnlineTask", produces = "application/x-www-form-urlencoded; charset=UTF-8")
    @ResponseBody
    public String addOnlineTask(String email, String keyword, String region, String IPhoneColor, String IPhoneScreenSize, String IPhoneCapacity) {
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
    public Map<String, IPhoneStatus> getonlineStatus() {
        HashMap<String, IPhoneStatus> statusResult = Maps.newHashMap();
        cnIPhoneEnum[] cnIPhoneEnums = cnIPhoneEnum.values();
        hkIPhoneEnum[] hkIPhoneEnums = hkIPhoneEnum.values();
        generateJSON(statusResult, cnIPhoneEnums);
        generateJSON(statusResult, hkIPhoneEnums);
        return statusResult;
    }

    private void generateJSON(HashMap<String, IPhoneStatus> statusResult, IPhoneEnum[] iPhoneEnums) {
        for (IPhoneEnum iPhoneEnum : iPhoneEnums) {
            String partName = iPhoneEnum.getPartNumber();
            IPhoneStatus iPhoneStatus = new IPhoneStatus();
            iPhoneStatus.setIphoneName(iPhoneEnum.getName());
            iPhoneStatus.setPartNumer(partName);
            iPhoneStatus.setIsOnline(cacheService.isAvailableOnlineByPartNo(partName));
            statusResult.put(partName, iPhoneStatus);
        }
    }

}
