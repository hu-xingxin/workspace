package com.springboot.demo3.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import lombok.Data;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huxingxin
 * @createTime 2021年08月15日 06:59:05
 * @Description
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "shiro")
public class ShiroAutoConfiguration {
    private String hashAlgorithmName = "md5";// 加密方式
    private int hashIterations = 2;// 散列次数
    private String targetBeanName = "shiroFilter";
    private boolean targetFilterLifecycle = true;
    private String loginUrl = "/menu";// 未登陆跳转
    private String unauthorizedUrl = "/menu";// 未授权跳转


    private String[] anonUrls;
    private String[] authcUrls;

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.timeout}")
    private int timeout;
    @Value("${spring.redis.password}")
    private String password;

    /**
     * 配置shiro redisManager
     * 使用的是shiro-redis开源插件
     * @return
     */
    @Bean
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setExpire(1800);// 配置缓存过期时间
        redisManager.setTimeout(timeout);
        return redisManager;
    }
    @Bean
    public RedisSessionDAO redisSessionDAO(RedisManager redisManager) {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager);
        return redisSessionDAO;
    }
    /**
     * shiro session的管理
     */
    @Bean
    public DefaultWebSessionManager redisSessionManager(RedisSessionDAO redisSessionDAO) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO);
        return sessionManager;
    }
    @Bean
    public RedisCacheManager redisCacheManager(RedisManager redisManager) {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager);

        return redisCacheManager;
    }

    /**
     * 声明凭证匹配器
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        // 注入加密方式
        credentialsMatcher.setHashAlgorithmName(hashAlgorithmName);
        // 注入散列次数
        credentialsMatcher.setHashIterations(hashIterations);
        return credentialsMatcher;
    }

    /**
     * 声明userRealm
     */
    @Bean
    public UserRealm userRealm(HashedCredentialsMatcher credentialsMatcher) {
        UserRealm userRealm = new UserRealm();
        // 注入凭证匹配器
        userRealm.setCredentialsMatcher(credentialsMatcher);
        return userRealm;
    }

    /**
     * 声明安全管理器
     */
    @Bean
    public SecurityManager securityManager(UserRealm userRealm,DefaultWebSessionManager redisSessionManager,RedisCacheManager redisCacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 注入realm
        securityManager.setRealm(userRealm);
        securityManager.setSessionManager(redisSessionManager);
        securityManager.setCacheManager(redisCacheManager);
        return securityManager;
    }

    /**
     * 配置shiro的代理过滤器
     */
    @Bean
    public FilterRegistrationBean<DelegatingFilterProxy> filterRegistrationBeanDelegatingFilterProxy() {
        // 创建注册器
        FilterRegistrationBean<DelegatingFilterProxy> registrationBean = new FilterRegistrationBean<>();
        // 创建过滤器
        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
        // 设置过滤器的参数
        proxy.setTargetBeanName(targetBeanName);
        proxy.setTargetFilterLifecycle(targetFilterLifecycle);
        // 注册
        registrationBean.setFilter(proxy);
        Collection<String> servletNames = new ArrayList<>();
        servletNames.add(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME);
        registrationBean.setServletNames(servletNames);
        return registrationBean;
    }

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean(value = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        // 注入安全管理器
        factoryBean.setSecurityManager(securityManager);
        // 设置非登陆跳转的页面
        factoryBean.setLoginUrl(loginUrl);
        // 未授权的跳转页
        factoryBean.setUnauthorizedUrl(unauthorizedUrl);
        //自定义拦截器
        factoryBean.getFilters().put("authc",new AjaxFilter());

        Map<String, String> filterChainDefinitionMap = new HashMap<>();

        //设置放行的url
//        if(anonUrls!=null&&anonUrls.length>0) {
//            for (String url : anonUrls) {
//                filterChainDefinitionMap.put(url, "anon");
//            }
//        }
//        //设置拦击的url
//        if(authcUrls!=null&&authcUrls.length>0) {
//            for (String url : authcUrls) {
//                filterChainDefinitionMap.put(url, "authc");
//            }
//        }
//		filterChainDefinitionMap.put("/", "anon");
//        filterChainDefinitionMap.put("/index", "anon");
        filterChainDefinitionMap.put("/menu", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/bootstrap/**", "anon");
		filterChainDefinitionMap.put("/bootstrap-fileupload/**", "anon");
		filterChainDefinitionMap.put("/img/*", "anon");
		filterChainDefinitionMap.put("/doc.html", "anon");
		filterChainDefinitionMap.put("/swagger-resources/**", "anon");
		filterChainDefinitionMap.put("/webjars/bycdao-ui/**", "anon");
		filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/**", "authc");
        // 设置过滤器
        factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return factoryBean;
    }

    // 这里是为了能在html页面引用shiro标签，上面两个函数必须添加，不然会报错
    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    //开启shiro 注解
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor
                = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass( true );
        return defaultAAP;
    }
}
