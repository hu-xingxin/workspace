package com.dynamic;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-01 16:20
 **/
@WebListener
public class DynamicRegListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        DynamicServlet dynamicServlet = null;
        try {
            dynamicServlet = servletContext.createServlet(DynamicServlet.class);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        dynamicServlet.setName("DynamicServlet registered servlet");
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dynamicServlet", dynamicServlet);
        dynamic.addMapping("/dynamic");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sc) {

    }
}
