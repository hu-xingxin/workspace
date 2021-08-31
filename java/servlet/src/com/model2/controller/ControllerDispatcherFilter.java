package com.model2.controller;

import com.model2.action.ProductAction;
import com.model2.model.Product;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-27 14:09
 **/
@WebFilter(filterName = "ControllerDispatcherFilter", urlPatterns = {"/filter/input","/filter/save"})
public class ControllerDispatcherFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String dispatcherUrl = null;

        String requestURI = httpServletRequest.getRequestURI();
        int lastIndex = requestURI.lastIndexOf("/");
        String action = requestURI.substring(lastIndex+1);

        if(action.equals("input")){
            dispatcherUrl="/jsp/productForm.jsp";
        }else if (action.equals("save")){
            Product product = new Product();
            String name = httpServletRequest.getParameter("name");
            String description = httpServletRequest.getParameter("description");
            Float price = null;
            if(httpServletRequest.getParameter("price")!=""){
                price = Float.parseFloat(httpServletRequest.getParameter("price"));
            }
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);

            ProductAction productAction = new ProductAction();
            productAction.save(product);
            System.out.println(product);
            httpServletRequest.setAttribute("product",product);
            dispatcherUrl="/jsp/productDetails.jsp";
        }

        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(dispatcherUrl);
        requestDispatcher.forward(httpServletRequest,servletResponse);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
