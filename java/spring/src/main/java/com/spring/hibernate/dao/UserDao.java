package com.spring.hibernate.dao;

import com.spring.hibernate.pojo.SysUser;
import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-11 22:45
 **/
public class UserDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
        this.hibernateTemplate = hibernateTemplate;
    }

    public Integer insertUser(SysUser user){
        return (Integer) hibernateTemplate.save(user);
    }
}
