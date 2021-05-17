package com.intelligenceparking.controller;

import com.intelligenceparking.bean.UserModel;
import com.intelligenceparking.controller.viewobject.UserVO;
import com.intelligenceparking.response.CommonReturnType;
import com.intelligenceparking.service.EmailService;
import com.intelligenceparking.service.UserService;
import com.intelligenceparking.tool.IpUtil;
import com.intelligenceparking.tool.dynamicTable.DynamicRegisterTable;
import com.intelligenceparking.tool.dynamicTable.DynamicUserTable;
import com.intelligenceparking.tool.requests.UserRegisterVerifyMsg;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

    @RequestMapping("/hello")
    public String testHello(HttpServletRequest request,
                            @RequestParam(value = "name",defaultValue = "World")String name,
                            @RequestParam(value = "password",defaultValue = "World")String password) {
        System.out.println(IpUtil.getIpAddr(request));
        return String.format("Hello %s  %s",name,password);
    }

    //用户注册
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType register(@RequestParam(name = "username") String username,
                                     @RequestParam(name = "password") String password,
                                     @RequestParam(name = "phone") String phone,
                                     @RequestParam(name = "email") String email,
                                     @RequestParam(name = "account") String account) {
        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setPassword(password);
        userModel.setPhone(phone);
        userModel.setEmail(email);
        userModel.setAccount(account);
        System.out.print(userModel);
        userService.register(userModel);
        emailService.sendSimpleMailMessge(userModel.getEmail());
        return CommonReturnType.create(null);
    }

    @PostMapping(value="/login",produces = "application/json;charset=UTF-8")
    public CommonReturnType login(HttpServletRequest request,
                      @RequestParam(name = "username") String username,
                      @RequestParam(name = "password") String password){
        //获取IP地址
        String ipAddress = IpUtil.getIpAddr(request);
        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setPassword(password);
        UserModel result = userService.login(userModel);
        if(result==null)
            return CommonReturnType.create("fail","账号名或密码名错误",null);
        if(result.isFrozen())
            return CommonReturnType.create("fail","尚未激活账号",null); //have not verified your account yet.
//        if(!DynamicUserTable.checkOnline(result.getId(),ipAddress)){
//            DynamicUserTable.insert(result.getId(),ipAddress);
//            UserVO userVO = convertFromDataObject(result);
//            return CommonReturnType.create(userVO);
//        }
//        return CommonReturnType.create("fail","账号名或密码名错误",null);
        UserVO userVO = convertFromDataObject(result);
        return CommonReturnType.create(userVO);
    }

    @PostMapping("/registerVerify")
    public CommonReturnType registerVerify(@RequestParam(name = "email") String email,
                                           @RequestParam(name = "code") String code) {
        UserRegisterVerifyMsg userRegisterVerifyMsg = new UserRegisterVerifyMsg(email,code);
        if(DynamicRegisterTable.verify(userRegisterVerifyMsg.getEmail(), userRegisterVerifyMsg.getCode())) {
            userService.registerVerify(userRegisterVerifyMsg);
            return CommonReturnType.create("success","成功",null);
        }
        return CommonReturnType.create("fail","注册码或邮箱错误",null);
    }

    @PostMapping("/updateMsg")
    public CommonReturnType updateMsg(HttpServletRequest request,
                                      @RequestParam(name = "username") String username,
                                      @RequestParam(name = "password") String password,
                                      @RequestParam(name = "phone") String phone,
                                      @RequestParam(name = "email") String email,
                                      @RequestParam(name = "account") String account){
        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setPassword(password);
        userModel.setPhone(phone);
        userModel.setEmail(email);
        userModel.setAccount(account);
        userService.updateMsg(userModel);
        UserVO userVO = convertFromDataObject(userModel);
        return CommonReturnType.create(userVO);
    }

    @PostMapping("/quit")
    public CommonReturnType quit(HttpServletRequest request) {
        String ipAddress = IpUtil.getIpAddr(request);
        DynamicUserTable.delete(ipAddress);
        return null;
    }

    @PostMapping("/deleteAccount")
    public CommonReturnType deleteAccount(HttpServletRequest request) {
        return null;
    }

    @RequestMapping("/findAllUser")
    public CommonReturnType findallsuer(HttpServletRequest request) {
        return null;
    }

//    @RequestMapping("/selectUserById")
//    public CommonReturnType selectUserById(HttpServletRequest request,
//                                           @RequestParam(name = "id") int id) {
//        UserModel userModel = userService.selectUserById(id);
//        return CommonReturnType.create(userModel);
//    }


    private UserVO convertFromDataObject(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }

}
