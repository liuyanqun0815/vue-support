package com.example.vuesupport.user.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.vuesupport.config.ResultData;
import com.example.vuesupport.user.entity.TUser;
import com.example.vuesupport.user.service.ITUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lyq
 * @since 2020-04-19
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class TUserController {

    @Autowired
    ITUserService tUserService;

    @PostMapping("/login" )
    public ResultData login(@RequestBody JSONObject object){
        log.info("login:",JSON.toJSONString(object));
        String username = object.getString("username");
        String password = object.getString("password");
       TUser user = tUserService.login(username,password);
       if (user != null){
           return ResultData.success(user);
       }
       return ResultData.success(null);
    }

    @GetMapping("/info" )
    public ResultData info(HttpServletRequest request,@RequestParam("token") String token){
        log.info("info token:{}, request:{}",token,JSONObject.toJSONString(request.getCookies()));
//        String username = object.getString("username");
//        String password = object.getString("password");
        Cookie[] cookies = request.getCookies();
        List<String> names = new ArrayList<>();
        for(Cookie cookie : cookies){
            if ("vue_token".equals(cookie.getName())){
                names.add(cookie.getName());
            }
        }
        TUser user = tUserService.getUserByToken(token);
        if (user != null){
            return ResultData.success(user);
        }
        return ResultData.success(null);
    }
}
