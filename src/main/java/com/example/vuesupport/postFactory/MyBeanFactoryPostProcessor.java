package com.example.vuesupport.postFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @description:
 * @author: lyq
 * @createDate: 2020/6/26
 */
//@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
//        Teacher bean = configurableListableBeanFactory.getBean(Teacher.class);
//        BeanDefinition teacherDef = configurableListableBeanFactory.getBeanDefinition("teacher");
        System.out.println("MyBeanFactoryPostProcessor.postProcessBeanFactory");
        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(s -> System.out.println(s));
    }
}
