package com.example.vuesupport.postFactory.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: lyq
 * @createDate: 2020/6/26
 */

@RestController
public class TestController {

    @Autowired
    CalculateService calculateService;

    @Autowired
    TestService testService;

    @RequestMapping("/hello")
    public String getHello(){

        String testList = testService.getList("code123","name456");
        String calculateResult = calculateService.getResult("测试");
        return (testList + "," +calculateResult);
    }
}
