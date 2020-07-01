package com.example.vuesupport;

import com.example.vuesupport.postFactory.mybatis.ServiceBeanDefinitionRegistry;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@MapperScan({"com.example.vuesupport.home.mapper","com.example.vuesupport.user.mapper"})
@Import(ServiceBeanDefinitionRegistry.class)

public class VueSupportApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueSupportApplication.class, args);
    }

}
