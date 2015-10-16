package com.maitaidan.refreshIPhone.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.maitaidan.refreshIPhone.service.JSONService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by xinyu.jiang on 2015/10/12. 处理json数据
 */
@Service
public class JSONServiceImpl implements JSONService {
    private Logger logger = LoggerFactory.getLogger(JSONServiceImpl.class);

    public void parseStoreAvailableJson(String json) {
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        jsonObject.remove("isToday").getAsJsonObject().remove("zh_CN").getAsJsonObject()
                .remove("updated");

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
