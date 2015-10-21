package com.maitaidan.refreshIPhone.service.impl;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.maitaidan.refreshIPhone.pojo.*;
import com.maitaidan.refreshIPhone.service.CacheService;
import com.maitaidan.refreshIPhone.service.JSONService;
import com.maitaidan.refreshIPhone.service.TaskService;
import com.maitaidan.refreshIPhone.util.HttpRequestUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Crytis on 2015/10/9.
 *
 */
@Service
public class TaskServiceImpl implements TaskService {
    private final static String hkStoreOnlineUrl = "http://www.apple.com/hk-zh/shop/updateSummary";
    private final static String cnStoreOnlineUrl = "http://www.apple.com/cn/shop/updateSummary";
    // todo test用注解 不知道spring行不
    @Autowired
    JSONService jsonService;
    @Resource
    CacheService cacheService;
    @Resource
    JavaMailSenderImpl javaMailSender;

    private Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
    private HashSet<IPhoneTask> tasks = Sets.newHashSet();

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

    /**
     * 根据partNo刷新状态
     * @param partNumber
     * @return
     */
    public boolean refreshIPhoneOnlineStatus(String partNumber) {
        IPhoneEnum iphoneEnum = cnIPhoneEnum.Gold128.getEnumByPartName(partNumber) == null
                ? hkIPhoneEnum.Gold128.getEnumByPartName(partNumber)
                : cnIPhoneEnum.Gold128.getEnumByPartName(partNumber);
        HashMap<String, String> availableJSONParam = Maps.newHashMap();
        setParam(iphoneEnum, availableJSONParam);

        String url;
        if (cnIPhoneEnum.Gold128.getEnumByPartName(partNumber) != null) {
            url = cnStoreOnlineUrl;
        } else {
            url = hkStoreOnlineUrl;
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
     * 定时检测在线购买是否可以
     */
    @Scheduled(fixedDelay = 3000)
    public void isNeedIPhoneOnlineAvailable() {
        logger.info("当前任务数量:{}", tasks.size());
        logger.info("当前任务：{}",tasks.toString());
        Iterator<IPhoneTask> it = tasks.iterator();
        while (it.hasNext()) {
            IPhoneTask iPhoneTask = it.next();
            String partNumber = iPhoneTask.getiPhone().getPartNumber();
            boolean isOK = cacheService.isAvailableOnlineByPartNo(partNumber);
            if (isOK) {

                logger.info("{}可以买了", partNumber);
                MimeMessage mimeMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
                try {
                    helper.setTo(iPhoneTask.getEmail());
                    helper.setSubject("你好！你关注的iPhone有货了！");
                    helper.setFrom("麦钛蛋IPhone6S监控");
                    String content = "Hi!<br/>你所关注的" + iPhoneTask.getiPhone().getName() + "已经有货可以在线购买了！购买链接：<a href=\"" + iPhoneTask.getBuyingUrl() + "\">购买传送门！</a>" + "<br/>Powered By www.maitaidan.com";
                    helper.setText(content, true);

                    // 如果可以买了，发邮件，清除任务
                    it.remove();
                } catch (MessagingException e) {
                    logger.error("发送邮件失败！{},{}", iPhoneTask, e);
                }
                logger.info("发送邮件！{}", iPhoneTask.getEmail());
                javaMailSender.send(mimeMessage);
            } else {
                logger.info("{}不可购买", partNumber);
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
        // 其它变化参数
        Param.put("option.dimensionScreensize", IPhoneType.getScreenSize());
        Param.put("option.dimensionColor", IPhoneType.getColor());
        Param.put("option.dimensionCapacity", IPhoneType.getCapacity());
        Param.put("product", IPhoneType.getPartNumber());
        logger.info("请求在线购买json参数:{}", Param);
    }

}
