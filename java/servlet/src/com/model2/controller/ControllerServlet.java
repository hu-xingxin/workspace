package com.model2.controller;

import com.model2.action.ProductAction;
import com.model2.model.Product;
import com.model2.model.ProductFrom;
import com.model2.validator.ProductValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-27 09:25
 **/
@WebServlet(name = "ControllerServlet", urlPatterns = {"/servlet/input","/servlet/save"})
public class ControllerServlet extends HttpServlet {
    private static final Long Serializable = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dispatcherUrl = null;

        String requestURI = request.getRequestURI();
        int lastIndex = requestURI.lastIndexOf("/");
        String action = requestURI.substring(lastIndex+1);

        if(action.equals("input")){
            dispatcherUrl="/jsp/productForm.jsp";
        }else if (action.equals("save")){

            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String price = request.getParameter("price");

            ProductFrom productFrom = new ProductFrom();
            productFrom.setName(name);
            productFrom.setDescription(description);
            productFrom.setPrice(price);

            ProductValidator productValidator = new ProductValidator();
            List<String> errors = productValidator.validate(productFrom);
            if(errors.isEmpty()){
                Product product = new Product();
                product.setName(name);
                product.setDescription(description);
                product.setPrice(Float.parseFloat(price));

                ProductAction productAction = new ProductAction();
                productAction.save(product);
                System.out.println(product);
                request.setAttribute("product",product);
                dispatcherUrl="/jsp/productDetails.jsp";
            }else {
                System.out.println(errors);
                System.out.println(productFrom);
                request.setAttribute("productFrom",productFrom);
                request.setAttribute("errors",errors);
                dispatcherUrl="/jsp/productForm.jsp";
            }
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(dispatcherUrl);
        requestDispatcher.forward(request,response);
    }
}
