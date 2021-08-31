package com.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-26 14:21
 **/
@WebListener
public class AppSessionListener implements HttpSessionListener, ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("userCounter",new Integer(0));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        ServletContext servletContext = session.getServletContext();
        Integer userCounter = (Integer) servletContext.getAttribute("userCounter");
        servletContext.setAttribute("userCounter",userCounter+1);
        System.out.println(servletContext.getAttribute("userCounter"));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        ServletContext servletContext = session.getServletContext();
        Integer userCounter = (Integer) servletContext.getAttribute("userCounter");
        servletContext.setAttribute("userCounter",userCounter-1);
        System.out.println(servletContext.getAttribute("userCounter"));
    }
}
