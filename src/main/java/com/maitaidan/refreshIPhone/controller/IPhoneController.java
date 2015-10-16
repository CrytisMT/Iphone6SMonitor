package com.maitaidan.refreshIPhone.controller;

import com.google.common.collect.Maps;
import com.maitaidan.refreshIPhone.pojo.IPhoneStatus;
import com.maitaidan.refreshIPhone.pojo.cnIPhoneEnum;
import com.maitaidan.refreshIPhone.service.CacheService;
import com.maitaidan.refreshIPhone.service.TaskService;
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

    @RequestMapping(value = "addTask")
    @ResponseBody
    public String addTask(String email, String keyword, String type) {
        logger.info("参数:{}{}{}", email, keyword, type);
//        taskService.addTask(email,new IPhoneTask());
        return null;
    }


    @RequestMapping("onlineStatus")
    @ResponseBody
    public Map<String, IPhoneStatus> getonlineStatus() {
        HashMap<String, IPhoneStatus> statusResult = Maps.newHashMap();
        cnIPhoneEnum[] cnIPhoneEnums = cnIPhoneEnum.values();
        for (cnIPhoneEnum cnIPhoneEnum : cnIPhoneEnums) {
            String partName = cnIPhoneEnum.getPartNumber();
            IPhoneStatus iPhoneStatus = new IPhoneStatus();
            iPhoneStatus.setIphoneName(cnIPhoneEnum.getName());
            iPhoneStatus.setPartNumer(partName);
            iPhoneStatus.setIsOnline(cacheService.isAvailableOnlineByPartNo(partName));
            statusResult.put(partName, iPhoneStatus);
        }
        return statusResult;
    }

}
