package com.servlet.demo2.app01;

import com.servlet.demo2.app01.pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author huxingxin
 * @createTime 2021年08月08日 23:21:48
 * @Description
 */
@WebServlet(name = "AddOrderServlet", urlPatterns = {"/addOrder"})
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        Order order = new Order();
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String parameterName = parameterNames.nextElement();
            String[] parameterValues = req.getParameterValues(parameterName);

            //其他服务
            if (parameterName.equals("otherService")){
                String[] otherService = new String[parameterValues.length];
                for (int i=0; i< parameterValues.length; i++){
                    otherService[i]=parameterValues[i];
                }
                order.setOtherService(otherService);
            }

            for (String value : parameterValues){
                //姓名
                if (parameterName.equals("name")){
                    order.setName(value);
                }
                //地址
                if (parameterName.equals("address")){
                    order.setAddress(value);
                }
                //城市
                if (parameterName.equals("cities")){
                    order.setCities(value);
                }
                //快递
                if (parameterName.equals("expresses")){
                    order.setExpresses(value);
                }
                //备注
                if(parameterName.equals("remark")){
                    order.setRemark(value);
                }
            }
        }
        req.setAttribute("order",order);
        req.getRequestDispatcher("/WEB-INF/jsp/editOrder.jsp").forward(req,resp);
    }
}
