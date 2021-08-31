package com.springboot.demo2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author huxingxin
 * @createTime 2021年08月13日 11:45:23
 * @Description 是页面通过 #可以正常读取配置文件的数据
 */

@Configuration
public class I18NConfig {
    @Bean
    public ResourceBundleMessageSource messageSource() {
        //创建个资源绑定的信息源
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        //设置可以使用编码访问
        messageSource.setUseCodeAsDefaultMessage(true);
        //禁用系统本地环境
        messageSource.setFallbackToSystemLocale(false);
        //设置资源文件有前缀
//        messageSource.setBasename("student");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(2);
        return messageSource;
    }

}


