package com.maitaidan.flushIPhone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class flushIPhoneController {

    private Logger logger = LoggerFactory.getLogger(flushIPhoneController.class);
    @RequestMapping(value = "addTask")
    @ResponseBody
    public String addTask(String email, String keyword,String type) {
        logger.info("参数:{}{}{}",email,keyword,type);
        return null;
    }
}
