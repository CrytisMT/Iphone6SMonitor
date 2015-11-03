package com.maitaidan.refreshIPhone.service.impl;

import java.util.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.maitaidan.refreshIPhone.pojo.*;
import com.maitaidan.refreshIPhone.service.CacheService;
import com.maitaidan.refreshIPhone.service.JSONService;
import com.maitaidan.refreshIPhone.service.TaskService;
import com.maitaidan.refreshIPhone.util.HttpRequestUtil;

/**
 * Created by Crytis on 2015/10/9.
 */
@Service
public class TaskServiceImpl implements TaskService {

    private final static String hkOnlineUrl = "http://www.apple.com/hk-zh/shop/updateSummary";
    private final static String cnOnlineUrl = "http://www.apple.com/cn/shop/updateSummary";
    private final static String cnAppleStoreJsonUrl = "https://reserve.cdn-apple.com/CN/zh_CN/reserve/iPhone/availability.json";
    private final static String hkAppleStoreJsonUrl = "https://reserve.cdn-apple.com/HK/zh_HK/reserve/iPhone/availability.json";

    @Autowired
    JSONService jsonService;
    @Resource
    CacheService cacheService;
    @Resource
    JavaMailSenderImpl javaMailSender;

    private Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
    private HashSet<onlineTask> onlineTasks = Sets.newHashSet();
    private HashSet<onlineTask> storeTasks = Sets.newHashSet();

    public HashSet<onlineTask> getAllOnlineTasks() {
        return onlineTasks;
    }

    public HashSet<onlineTask> getAllStoreTasks() {
        return storeTasks;
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

    /**
     * 根据partNo刷新状态,缓存调用
     *
     * @param partNumber
     * @return
     */
    public boolean getIPhoneOnlineStatus(String partNumber) {
        IPhoneEnum iphoneEnum = cnIPhoneEnum.Gold128.getEnumByPartName(partNumber) == null
                ? hkIPhoneEnum.Gold128.getEnumByPartName(partNumber)
                : cnIPhoneEnum.Gold128.getEnumByPartName(partNumber);
        HashMap<String, String> availableJSONParam = Maps.newHashMap();
        setParam(iphoneEnum, availableJSONParam);

        String url;
        if (cnIPhoneEnum.Gold128.getEnumByPartName(partNumber) != null) {
            url = cnOnlineUrl;
        } else {
            url = hkOnlineUrl;
        }

        String jsonResult = HttpRequestUtil.doGet(url, availableJSONParam, "UTF-8");
        // logger.info("请求在线购买json结果:{}", jsonResult);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }

        return jsonService.isIPhoneOnlineAvailable(jsonResult);
    }

    /**
     * 获取可售卖apple store
     *
     * @param partNumber
     * @return
     */
    public Set<StoreEnum> getAppleStoreStatusByPartNO(String partNumber) {
        String url;
        if (cnIPhoneEnum.Gold128.getEnumByPartName(partNumber) != null) {
            url = cnAppleStoreJsonUrl;
        } else {
            url = hkAppleStoreJsonUrl;
        }
        String json = HttpRequestUtil.doGet(url, new HashMap<String, String>(), "UTF-8");
        if (json == null || "{}".equals(json) || json.length() <= 10) {
            logger.info("store错误的json：{}", json);
            return Sets.newHashSet();
        }
        logger.info("json长度{}", json.length());
        HashMap<String, HashSet<StoreEnum>> parseResult = jsonService.parseStoreAvailableJson(json);
        if (parseResult.get(partNumber) == null) {
            logger.error("获取store失败,{},{}", partNumber, parseResult);
            return Sets.newHashSet();
        }
        return parseResult.get(partNumber);
    }

    public void addOnlineTask(String partNumber, String region, String email) {
        if (StringUtils.isBlank(region)) {
            logger.error("地区是空");
        }
        if ("hk".equalsIgnoreCase(region)) {
            onlineTasks.add(new onlineTask(email, hkIPhoneEnum.Gold128.getEnumByPartName(partNumber)));
        } else if ("cn".equalsIgnoreCase(region)) {
            onlineTasks.add(new onlineTask(email, cnIPhoneEnum.Gold128.getEnumByPartName(partNumber)));
        } else {
            logger.error("地区错误:{}", region);
        }
    }

    public void addStoreTask(String partNumber, String region, String email, String[] storeNO) {


    }

    /**
     * 定时检测在线购买任务是否可以
     */
    @Scheduled(fixedDelay = 30000)
    public void checkOnlineTask() {
        logger.info("当前任务数量:{}", onlineTasks.size());
        logger.info("当前任务：{}", onlineTasks.toString());
        Iterator<onlineTask> it = onlineTasks.iterator();
        while (it.hasNext()) {
            onlineTask onlineTask = it.next();
            String partNumber = onlineTask.getiPhone().getPartNumber();
            boolean isOK = cacheService.isAvailableOnlineByPartNo(partNumber);
            if (isOK) {

                logger.info("{}可以买了", partNumber);
                MimeMessage mimeMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
                try {
                    helper.setTo(onlineTask.getEmail());
                    helper.setSubject("你好！你关注的iPhone有货了！");
                    helper.setFrom("麦钛蛋IPhone6S监控");
                    String content = "Hi!<br/>你所关注的" + onlineTask.getiPhone().getName() + "已经有货可以在线购买了！购买链接：<a href=\""
                            + onlineTask.getBuyingUrl() + "\">购买传送门！</a>" + "<br/>Powered By www.maitaidan.com";
                    helper.setText(content, true);

                    logger.info("发送邮件！{}", onlineTask.getEmail());
                    javaMailSender.send(mimeMessage);
                } catch (MessagingException e) {
                    logger.error("发送邮件失败！{},{}", onlineTask, e);
                }
                // 如果可以买了，发邮件，清除任务
                it.remove();
            } else {
                logger.info("{}不可购买", partNumber);
            }

        }
    }

    private void setParam(IPhoneEnum IPhoneType, HashMap<String, String> Param) {
        Param.put("node", Parameters.node);
        Param.put("setp", Parameters.step);
        Param.put("option.carrierModel", Parameters.option_carrierModel);
        Param.put("carrierPolicyType", Parameters.carrierPolicyType);
        // 其它变化参数
        Param.put("option.dimensionScreensize", IPhoneType.getScreenSize());
        Param.put("option.dimensionColor", IPhoneType.getColor());
        Param.put("option.dimensionCapacity", IPhoneType.getCapacity());
        Param.put("product", IPhoneType.getPartNumber());
        logger.info("请求在线购买json参数:{}", Param);
    }

}
