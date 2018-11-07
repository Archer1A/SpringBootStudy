package com.hotelhelp.hotelhelp.controller;

import com.alibaba.fastjson.JSON;
import com.hotelhelp.hotelhelp.domain.SendTerminalCheckInSms;
import com.hotelhelp.hotelhelp.domain.User;
import com.hotelhelp.hotelhelp.service.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloWorldController {
    @Autowired
    FilterRegistrationBean filterRegistrationBean;
    @RequestMapping("/hello")
    public String index() {
        return "hello world";
    }

    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setUserName("Vic");
        user.setPassword("123456");
        return user;
    }



    @RequestMapping("/getname")
    public Map<String, String> getName() {
        Map<String, String> initParameters = filterRegistrationBean.getInitParameters();
        return initParameters;
    }

    @RequestMapping("/sms")
    public boolean sendSms(){
        String url = "";
        SendTerminalCheckInSms checkInSms = new SendTerminalCheckInSms();
        System.out.println(JSON.toJSONString(checkInSms));
        SendSms.sendPostRequest(url,JSON.toJSONString(checkInSms));
        return true;
    }
}
