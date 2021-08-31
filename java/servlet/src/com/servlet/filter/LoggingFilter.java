package com.servlet.filter;


import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-26 15:41
 **/
@WebFilter(filterName = "LoggingFilter", urlPatterns = {"/*"},
        initParams = {
            @WebInitParam(name = "logFileName",value = "log.txt"),
            @WebInitParam(name = "prefix",value = "URI："),
        })
public class LoggingFilter implements Filter {
    private PrintWriter logger;
    private String prefix;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        prefix = filterConfig.getInitParameter("prefix");
        String logFileName = filterConfig.getInitParameter("logFileName");

        String appPath = "F:\\code\\workspace\\java\\servlet\\";
        System.out.println("logFileName:" + logFileName);

        try {
            File file = new File(appPath, logFileName);
           if(!file.exists()){
               file.createNewFile();
           }
            logger = new PrintWriter(new FileOutputStream(file,true) );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LoggingFilter.doFilter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        logger.print(new Date() + " " + prefix + httpServletRequest.getRequestURI() +"\n");
        logger.flush();
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy filter");
        if(logger != null){
            logger.close();
        }
    }
}
