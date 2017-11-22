package com.zhuoyue.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan
@MapperScan("com.zhuoyue.core.dao") // 不能扫描子包
@SpringBootApplication
public class AntzApplication {

	public static void main(String[] args) {
		SpringApplication.run(AntzApplication.class, args);
	}
}
