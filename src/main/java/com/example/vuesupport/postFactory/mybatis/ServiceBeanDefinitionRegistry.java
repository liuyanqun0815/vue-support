package com.example.vuesupport.postFactory.mybatis;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @description:
 * @author: lyq
 * @createDate: 2020/6/26
 */
public class ServiceBeanDefinitionRegistry implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Set<Class<?>> set =new LinkedHashSet<>();
        set.add(TestService.class);
        set.add(CalculateService.class);
        for(Class beanClass : set){
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
            AbstractBeanDefinition rawBeanDefinition = builder.getRawBeanDefinition();
            rawBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanClass);
            rawBeanDefinition.setBeanClass(ServiceFactory.class);
            rawBeanDefinition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
            registry.registerBeanDefinition(beanClass.getSimpleName(),rawBeanDefinition);
        }


    }
    private static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

    private Set<Class<?>> scannerPackages(String basePackage){
        Set<Class<?>> set =new LinkedHashSet<>();

        return null;
    }
}
