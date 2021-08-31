package com.servlet.demo3.app01.listener.request;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;

/**
 * @author huxingxin
 * @createTime 2021年08月09日 20:28:39
 * @Description 用ServletRequestListener监听器 监听请求的url和参数  打印记录日志
 */
//@WebListener
public class AppRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        //得到HttpServletRequest对象
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        //设置请求数据的字符格式为utf-8  防止乱码
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //日志路径
        String ctx =  request.getSession().getServletContext().getRealPath("/")+"log"+File.separator+"listenerLog.txt";
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
