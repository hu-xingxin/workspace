package com.servlet.demo3.app01;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author huxingxin
 * @createTime 2021年08月09日 16:59:57
 * @Description ServletContextListener会对ServletContext的初始化和解构做出响应
 */
public class AppListener implements ServletContextListener {
    /**
     * 初始化
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //从ServletContextEvent 取到ServletContext
        ServletContext servletContext = servletContextEvent.getServletContext();
        //往ServletContext作用域中 放值 value-listener
        servletContext.setAttribute("value-listener","ServletContextListener");
        System.out.println(ServletContextListener.class.getName() + "--> contextInitialized()");
    }

    /**
     * 销毁
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //从ServletContextEvent 取到ServletContext
        ServletContext servletContext = servletContextEvent.getServletContext();
        //往ServletContext作用域中 放值 value-listener
        String attribute = (String)servletContext.getAttribute("value-listener");
        System.out.println("value-listener : " + attribute);
        System.out.println(ServletContextListener.class.getName() + "--> servletContextEvent()");
    }
}
