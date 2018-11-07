package com.hotelhelp.hotelhelp.service;

import com.alibaba.fastjson.JSON;
import com.hotelhelp.hotelhelp.domain.SendTerminalCheckInSms;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class SendSms {
//    public static void sendCheckInSms(SendTerminalCheckInSms checkInSms){
//        String js = JSON.toJSONString(checkInSms);
//
//
//    }
    public static boolean sendPostRequest(String url,String params) {

        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpMethod method = HttpMethod.POST;
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity requestEntity = new HttpEntity(params, headers);
        ResponseEntity responseEntity = client.exchange(url, method, requestEntity, String.class);
        System.out.println(responseEntity.getBody());
        return true;

    }
}
