package com.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-26 14:02
 **/
@WebListener
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        HashMap<String, Object> countries = new HashMap<>();
        countries.put("加拿大","Canada");
        countries.put("美国","United States");
        servletContext.setAttribute("countries",countries);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextDestroyed");
    }
}
