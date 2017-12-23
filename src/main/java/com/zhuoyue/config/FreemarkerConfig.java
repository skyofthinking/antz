package com.zhuoyue.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Freemarker配置
 */
public class FreemarkerConfig {

    @Autowired
    protected freemarker.template.Configuration configuration;

    @Bean
    public FreeMarkerViewResolver getFreemarkViewResolver() {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setCache(false);
        freeMarkerViewResolver.setSuffix(".html");
        freeMarkerViewResolver.setRequestContextAttribute("request");
        freeMarkerViewResolver.setContentType("text/html; charset=UTF-8");
        freeMarkerViewResolver.setViewClass(FreeMarkerView.class);
        return freeMarkerViewResolver;
    }

}
