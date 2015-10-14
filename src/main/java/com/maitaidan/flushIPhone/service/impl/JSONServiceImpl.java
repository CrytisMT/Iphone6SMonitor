package com.maitaidan.flushIPhone.service.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.maitaidan.flushIPhone.service.JSONService;
import org.springframework.stereotype.Component;

/**
 * Created by xinyu.jiang on 2015/10/12. 处理json数据
 */
@Component
public class JSONServiceImpl implements JSONService {
    public void parseStoreAvailableJson(String json) {
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        jsonObject.remove("isToday").getAsJsonObject().remove("zh_CN").getAsJsonObject()
                .remove("updated");

    }
}
