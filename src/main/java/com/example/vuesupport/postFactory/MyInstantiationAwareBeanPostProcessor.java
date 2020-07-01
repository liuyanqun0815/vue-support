package com.example.vuesupport.postFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * @description:
 * @author: lyq
 * @createDate: 2020/6/25
 */
//@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.print("beanName:" + beanName + "执行..postProcessAfterInstantiation\n");

        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.print("beanName:" + beanName + "执行..postProcessBeforeInstantiation\n");

        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.print("beanName:" + beanName + "执行..postProcessProperties\n");
//        if(bean instanceof Bean){
//                         //修改bean中name 的属性值
//                         PropertyValue value = pvs.getPropertyValue("name");
//                         System.out.print("修改之前 name 的value是："+value.getValue()+"\n");
//                         value.setConvertedValue("我修改啦");
//                         return pvs;
//                    }
        return null;
    }

    /**
     * @deprecated
     */
    @Override
    @Deprecated
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        return pvs;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.print("beanName:" + beanName + "执行..postProcessAfterInitialization\n");
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.print("beanName:" + beanName + "执行..postProcessBeforeInitialization\n");
        return bean;
    }

}
