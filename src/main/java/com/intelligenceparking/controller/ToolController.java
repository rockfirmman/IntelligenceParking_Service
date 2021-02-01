package com.intelligenceparking.controller;

import com.intelligenceparking.tool.IpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ToolController {
    @RequestMapping("/tool")
    public String test(HttpServletRequest request){
        //获取IP地址
        String ipAddress = IpUtil.getIpAddr(request);
        return ipAddress;
    }
}
