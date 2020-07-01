package com.example.vuesupport.postFactory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//import javax.annotation.PostConstruct;

/**
 * @description:
 * @author: lyq
 * @createDate: 2020/6/25
 */
@Component
public class Teacher implements InitializingBean {
    public String name;
    public String phone;


    public Teacher() {
        System.out.println("Teacher construct!");
    }
    {
        System.out.println("teacher static method");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("teacher中name值的注入");
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "name=" + name + ";phone=" + phone;
    }

    /**
     * 初始化方法
     */
    @PostConstruct
    public void init() {
        System.out.println("Teacher-init method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet teacher ");

    }
}
