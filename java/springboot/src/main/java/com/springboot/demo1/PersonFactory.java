package com.springboot.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @author huxingxin
 * @createTime 2021年08月13日 00:52:12
 * @Description
 */
@Configuration
public class PersonFactory {

    @Bean("personOne")
    public Person getPersonOne(){
        return new Person();
    }

    @Bean("personTwo")
    public Person getPersonTwo(){
        Person person = new Person();
        person.setUserName("personTwo");
        person.setBirthday(new Date());
        return person;
    }

    /**
     * @Autowired @Qualifier("personTwo") Person person 只能在同一个Configuration 中使用
     * @param person
     * @return
     */
    @Bean("personThree")
    public Person getPersonThree(@Autowired @Qualifier("personTwo") Person person){
        person.setAge(20);
        return person;
    }
}
