//package com.springboot.demo2.config.datasource;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import lombok.Data;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author huxingxin
// * @createTime 2021年08月13日 16:35:15
// * @Description  druid 数据源自定义starter
// */
//@Data
//@Configuration
//@ConditionalOnClass(value = {DruidDataSource.class})
//public class DruidAutoConfiguration {
//    @Bean(initMethod="init")
//    @ConfigurationProperties(prefix = "spring.druid")
//    public DruidDataSource druidDataSource(){
//       return new DruidDataSource();
//    }
//}
