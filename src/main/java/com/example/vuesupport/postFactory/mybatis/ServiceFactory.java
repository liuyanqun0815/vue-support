package com.example.vuesupport.postFactory.mybatis;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: lyq
 * @createDate: 2020/6/26
 */
public class ServiceFactory<T> implements FactoryBean<T> {

    private Class<T> interfaceType;

    ServiceFactory(Class<T> interfaceType){
        this.interfaceType = interfaceType;
    }
    @Override
    public T getObject() throws Exception {

        InvocationHandler handler = new ServiceProxy<>(interfaceType);
        Object o = Proxy.newProxyInstance(interfaceType.getClassLoader(), new Class[]{interfaceType}, handler);
        return (T) o;
    }

    @Override
    public Class<?> getObjectType() {
        return interfaceType;
    }
}
