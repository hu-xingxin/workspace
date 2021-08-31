package com.springboot.demo2.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

/**
 * @author huxingxin
 * @createTime 2021年08月13日 09:35:22
 * @Description
 */
@Component
public class WebConfig implements WebMvcConfigurer {
    /**
     * 静态资源访问目录配置
     * 对静态资源路径  /static/** 放行
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();

        ArrayList<String> excludePath = new ArrayList<>();
        excludePath.add("/static/**");//项目静态资源
        excludePath.add("/login");//登录
        excludePath.add("/doc.html");//swagger-bootstrap-ui
        excludePath.add("/swagger-resources/**");
//        excludePath.add("/v2/api-docs/**");
        excludePath.add("/webjars/bycdao-ui/**");
        registry.addInterceptor(loginInterceptor)
                //拦截路径
                .addPathPatterns("/**")
                //放行路径
                .excludePathPatterns(excludePath);
    }
}