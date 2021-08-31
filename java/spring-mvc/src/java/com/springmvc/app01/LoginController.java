package com.springmvc.app01;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author huxingxin
 * @createTime 2021年08月11日 14:40:35
 * @Description 使用SimpleControllerHandlerAdapter适配器
 */
public class LoginController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        int[] ints = {1, 2, 3, 4};
        modelAndView.setViewName("/jsp/login");//==request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        modelAndView.addObject("data",ints);//==request.setAttribute("users",users)
        return modelAndView;
    }
}
