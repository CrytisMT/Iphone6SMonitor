package com.maitaidan.flushIPhone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xinyu.jiang on 2015/10/9.
 */

@Controller
public class flushIPhoneController {

    @RequestMapping(value = "addTask")
    @ResponseBody
    public String addTask(String email, String keyword) {
        System.out.println("hellpo");
        return null;
    }
}
