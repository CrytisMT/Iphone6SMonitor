package com.maitaidan.refreshIPhone.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.maitaidan.refreshIPhone.pojo.*;
import com.maitaidan.refreshIPhone.service.JSONService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by xinyu.jiang on 2015/10/12. 处理json数据
 */
@Service
public class JSONServiceImpl implements JSONService {
    private Logger logger = LoggerFactory.getLogger(JSONServiceImpl.class);

    /**
     * 解析json
     * @param json
     * @return key 手机型号 value：可购买的store，set
     */
    public HashMap<String, HashSet<StoreEnum>> parseStoreAvailableJson(String json) {
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        //初始化map和所有机型
        HashMap<String, HashSet<StoreEnum>> iphoneInStoreStatus = Maps.newHashMap();

        List<String> iPhonePartNumbers = Lists.newArrayList();
        cnIPhoneEnum[] cnIPhoneEnums = cnIPhoneEnum.values();
        hkIPhoneEnum[] hkIPhoneEnums = hkIPhoneEnum.values();
        for (cnIPhoneEnum iPhoneEnums : cnIPhoneEnums) {
            iPhonePartNumbers.add(iPhoneEnums.getPartNumber());
        }
        for (hkIPhoneEnum iPhoneEnums : hkIPhoneEnums) {
            iPhonePartNumbers.add(iPhoneEnums.getPartNumber());
        }

        //todo 加入hk的商店
        CNStoreEnum[] cnStoreEnums = CNStoreEnum.values();
        HKStoreEnum[] hkStoreEnums = HKStoreEnum.values();
        doParse(jsonObject, iphoneInStoreStatus, iPhonePartNumbers, cnStoreEnums);
        doParse(jsonObject, iphoneInStoreStatus, iPhonePartNumbers, hkStoreEnums);

        return iphoneInStoreStatus;
    }

    /**
     * 具体解析的方法
     * @param jsonObject json转成的jsonObject
     * @param iphoneInStoreStatus 存结果的map
     * @param iPhonePartNumbers 存所有手机型号的list
     */
    private void doParse(JsonObject jsonObject, HashMap<String, HashSet<StoreEnum>> iphoneInStoreStatus, List<String> iPhonePartNumbers, StoreEnum[] storeEnums) {
        for (StoreEnum storeEnum : storeEnums) {
            //获取商店的iPhone状态
            JsonElement storeStatus = jsonObject.get(storeEnum.getStoreNo());
            if (storeStatus == null) {
                //如果没有这个商店就排除
                continue;
            }
            storeStatus.getAsJsonObject().remove("timeSlot");
            JsonObject storeStatusNew = storeStatus.getAsJsonObject();

            for (String iPhonePartNumber : iPhonePartNumbers) {
                JsonElement status = storeStatusNew.get(iPhonePartNumber);
                if (status != null) {
                    HashSet<StoreEnum> availableStores = iphoneInStoreStatus.get(iPhonePartNumber);
                    if (availableStores == null) {
                        //空的话说明是第一次
                        availableStores = Sets.newHashSet();
                    }
                    if ("ALL".equalsIgnoreCase(status.getAsString())) {
                        //如果是all的话，加入store，再放入map
                        availableStores.add(storeEnum);
                        iphoneInStoreStatus.put(iPhonePartNumber, availableStores);
                    }

                }
            }
        }
    }

    /**
     * 从json解析 是否可以在线购买
     *
     * @param json
     * @return
     */
    public boolean isIPhoneOnlineAvailable(String json) {
        if (StringUtils.isBlank(json)) {
            return false;
        }
        boolean isAvailable;
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        jsonObject = jsonObject.get("body").getAsJsonObject().get("response").getAsJsonObject().get("summarySection").getAsJsonObject().get("summary").getAsJsonObject();
        HashMap summaryMap = new Gson().fromJson(jsonObject, HashMap.class);
        logger.info("手机型号：{},状态：{}", summaryMap.get("productTitle"), summaryMap.get("isBuyable"));
        isAvailable = Boolean.valueOf(String.valueOf(summaryMap.get("isBuyable")));
        return isAvailable;
    }
}
