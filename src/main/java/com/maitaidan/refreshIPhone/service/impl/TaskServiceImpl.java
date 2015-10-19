package com.maitaidan.refreshIPhone.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.maitaidan.refreshIPhone.pojo.*;
import com.maitaidan.refreshIPhone.service.CacheService;
import com.maitaidan.refreshIPhone.service.JSONService;
import com.maitaidan.refreshIPhone.service.TaskService;
import com.maitaidan.refreshIPhone.util.HttpRequestUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Crytis on 2015/10/9.
 */
@Service
public class TaskServiceImpl implements TaskService {
    private Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
    private final static String hkStoreOnlineUrl = "http://www.apple.com/hk-zh/shop/updateSummary";
    private final static String cnStoreOnlineUrl = "http://www.apple.com/cn/shop/updateSummary";
    private ArrayList<IPhoneTask> tasks = Lists.newArrayList();

    //todo test用注解  不知道spring行不
    @Autowired
    JSONService jsonService;
    @Resource
    CacheService cacheService;

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


    public boolean flushIPhoneOnlineStatus(String partNumber) {
        IPhoneEnum iphoneEnum = cnIPhoneEnum.Gold128.getEnumByPartName(partNumber) == null ? hkIPhoneEnum.Gold128.getEnumByPartName(partNumber) : cnIPhoneEnum.Gold128.getEnumByPartName(partNumber);
        HashMap<String, String> availableJSONParam = Maps.newHashMap();
        setParam(iphoneEnum, availableJSONParam);

        String url;
        if (cnIPhoneEnum.Gold128.getEnumByPartName(partNumber) != null) {
            url = cnStoreOnlineUrl;
        } else {
            url = hkStoreOnlineUrl;
        }

        String jsonResult = HttpRequestUtil.doGet(url, availableJSONParam, "UTF-8");
        logger.info("请求在线购买json结果:{}", jsonResult);
        System.out.println(jsonResult);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
        boolean iPhoneOnlineAvailable = jsonService.isIPhoneOnlineAvailable(jsonResult);

        return iPhoneOnlineAvailable;
    }


    /**
     * 定时检测在线购买是否可以
     */
    @Scheduled(fixedDelay = 3000)
    public void isNeedIPhoneOnlineAvailable() {
        Iterator<IPhoneTask> it = tasks.listIterator();
        while (it.hasNext()) {
            IPhoneTask iPhoneTask = it.next();
            String partNumber = iPhoneTask.getiPhone().getPartNumber();
            boolean isOK = cacheService.isAvailableOnlineByPartNo(partNumber);
            if (isOK) {
                //如果可以买了，发邮件，清除任务
                it.remove();
                logger.info("{}可以买了", partNumber);
            }
        }
    }


    public void addOnlineTask(String partNumber, String region, String email) {
        if (StringUtils.isBlank(region)) {
            logger.error("地区是空");
        }
        if ("hk".equalsIgnoreCase(region)) {
            tasks.add(new IPhoneTask("", email, hkIPhoneEnum.Gold128.getEnumByPartName(partNumber)));
        } else if ("cn".equalsIgnoreCase(region)) {
            tasks.add(new IPhoneTask("", email, cnIPhoneEnum.Gold128.getEnumByPartName(partNumber)));
        } else {
            logger.error("地区错误:{}", region);
        }
    }


    private void setParam(IPhoneEnum IPhoneType, HashMap<String, String> Param) {
        Param.put("node", Parameters.node);
        Param.put("setp", Parameters.step);
        Param.put("option.carrierModel", Parameters.option_carrierModel);
        Param.put("carrierPolicyType", Parameters.carrierPolicyType);
        //其它变化参数
        Param.put("option.dimensionScreensize", IPhoneType.getScreenSize());
        Param.put("option.dimensionColor", IPhoneType.getColor());
        Param.put("option.dimensionCapacity", IPhoneType.getCapacity());
        Param.put("product", IPhoneType.getPartNumber());
        logger.info("请求在线购买json参数:{}", Param);
    }


}
