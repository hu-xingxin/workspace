package com.springboot.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author huxingxin
 * @createTime 2021年08月12日 17:15:52
 * @Description 测试 @Component @ConfigurationProperties @value @Configuration @Bean
 */
@Controller
public class ConfigController {
    @Autowired
    private User user;

    @Autowired
    private Order order;

    @Autowired
    private ApplicationContext context;

    /**
     * 测试 用ConfigurationProperties 从配置文件取值注入User
     * @return
     */
    @RequestMapping("user")
    @ResponseBody
    public User getUser(){
        return user;
    }

    /**
     * @Autowired @Qualifier("userOne")Person personOne 只能在同一个Configuration 中使用
     * 在这里使用 personOne 里面的属性没有注入值
     * @param personOne
     * @return
     */
    @RequestMapping("personOne")
    @ResponseBody
    public Person getUserOne(@Autowired @Qualifier("userOne")Person personOne){
        return personOne;
    }

    /**
     * 可以用 ApplicationContext 获取别的Configuration 里面的 @Bean
     * @return
     */
    @RequestMapping("personTwo")
    @ResponseBody
    public Person getUserTwo(){
        Person person = (Person)(context.getBean("personTwo"));
        return person;
    }

    @RequestMapping("personThree")
    @ResponseBody
    public Person getUserThree(){
        Person person = (Person)(context.getBean("personThree"));
        return person;
    }

    /**
     * 测试 用 @Value 注入值
     * @return
     */
    @RequestMapping("order")
    @ResponseBody
    public Order getOrder(){
        return order;
    }
}
