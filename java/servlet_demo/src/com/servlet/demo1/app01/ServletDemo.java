package com.servlet.demo1.app01;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author huxingxin
 * @createTime 2021年08月08日 14:27:25
 * @Description Servlet类 方法测试  /ServletDemo
 * init service  destroy
 * getServletConfig getServletInfo
 */
public class ServletDemo implements Servlet {
    private transient ServletConfig servletConfig;

    /**
     * 第一次请求 servlet容器会调用该方法 后续不会调用
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println(ServletDemo.class.getName() + "--> init...");
    }

    /**
     * 返回由servlet容器传给init方法的 ServletConfig
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    /**
     * 每次请求servlet时 servlet容器都会调用该方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        /**
         * ServletResponse 接口中的方法
         */
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();

        /**
         * ServletRequest 接口中的方法
         */
        //返回请求出主体中的字节数 如果不知道返回-1
        int contentLength = request.getContentLength();
        writer.println("请求出主体中的字节数: " + contentLength);

        //请求主体中的MIME类型 如果不知道返回 null
        /**
         * MIME的全称是Multipurpose Internet Mail Extensions，即多用途互联网邮件扩展类型。
         * MIME的格式：type/subtype
         */
        String contentType = request.getContentType();
        writer.println("<br/>请求主体中的MIME类型: " + contentType);

        //http请求的协议名称和版本号
        String protocol = request.getProtocol();
        writer.println("<br/>http请求的协议名称和版本号: " + protocol);

        //指定请求参数的值
        //http://localhost:8080/servlet/ServletDemo?id=1
        String id = request.getParameter("id");
        writer.println("<br/>指定请求参数的值: " + id);
    }

    /**
     * 返回servlet的描述
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁servlet时调用 （卸载或者关闭应用程序）
     */
    @Override
    public void destroy() {

    }
}
