package com.zhuoyue.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.zhuoyue.core.annotation.MyBatisDao;

@EnableAutoConfiguration
@Configuration
@ComponentScan
@MapperScan(basePackages = {"com.zhuoyue"}, annotationClass = MyBatisDao.class)
@SpringBootApplication
public class AntzApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntzApplication.class, args);
    }
}
