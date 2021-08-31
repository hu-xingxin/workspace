package com.springmvc.app01;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huxingxin
 * @createTime 2021年08月11日 15:05:39
 * @Description 使用HttpRequestHandlerAdapter适配器
 */
public class OrderController implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int[] ints = {1, 2, 3, 4};
        request.getRequestDispatcher("/jsp/addOrder").forward(request,response);
        request.setAttribute("data",ints);
    }
}
