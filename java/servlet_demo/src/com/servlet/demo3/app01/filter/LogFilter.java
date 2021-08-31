package com.servlet.demo3.app01.filter;

import javax.annotation.processing.Filer;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;

/**
 * @author huxingxin
 * @createTime 2021年08月09日 22:50:14
 * @Description 用Filter 拦截器 监听请求的url和参数  打印记录日志
 */
@WebFilter(filterName = "LogFilter", urlPatterns = {"/*"})
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //得到HttpServletRequest对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //设置请求数据的字符格式为utf-8  防止乱码
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //日志路径
        String ctx =  request.getSession().getServletContext().getRealPath("/")+"log"+File.separator+"listenerLog.txt";
//        System.out.println(request.getSession().getServletContext().getRealPath("\\"));
//        System.out.println("ctx: " + ctx);
//        System.out.println("URI: " + request.getRequestURI());
//        System.out.println("URL: " + request.getRequestURL());
//        System.out.println(ctx);
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(ctx,true),"utf-8"));){
            String url = request.getRequestURL().toString();//http://localhost:18089/servlet/login

            bw.write(formatData(url));
            bw.newLine();

            //请求的参数
            Enumeration<String> parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()){
                String parameter = parameterNames.nextElement();
                String[] values = request.getParameterValues(parameter);
                bw.write(formatData(parameter));
                bw.newLine();
                bw.write(formatData(Arrays.asList(values).toString()));
                bw.newLine();
                bw.flush();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        filterChain.doFilter(request,servletResponse);//
    }

    @Override
    public void destroy() {

    }

    /**
     * 格式化日志打印格式
     * @param data
     * @return
     */
    private String formatData(String data){
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return date + "-->" + data;
    }
}
