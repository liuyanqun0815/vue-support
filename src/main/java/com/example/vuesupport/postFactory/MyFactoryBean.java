package com.example.vuesupport.postFactory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @description:
 * @author: lyq
 * @createDate: 2020/6/25
 */
public class MyFactoryBean implements FactoryBean {

    private String message;

    public MyFactoryBean(){
        this.message = "通过构造方法初始化实例";
    }
    @Override
    public Object getObject() throws Exception {
        System.out.println("MyFactoryBean.getObject");
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        System.out.println("MyFactoryBean.getObjectType");
        return null;
    }
}
