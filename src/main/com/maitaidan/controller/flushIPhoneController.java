package main.com.maitaidan.controller;

/**
 * Created by xinyu.jiang on 2015/10/8.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.String;

@Controller
public class flushIPhoneController {

    @ResponseBody
    @RequestMapping(value = "addTask", method = RequestMethod.POST)
    public String addFlushTask(String email, String keyword) {

        return null;
    }
}
