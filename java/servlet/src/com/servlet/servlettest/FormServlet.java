package com.servlet.servlettest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-21 15:39
 **/
@WebServlet(name = "FormServlet", urlPatterns = {"/form"})
public class FormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String TITLE = "Order Form";


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html>");
        writer.print("<head>");
        writer.print("<title>"+TITLE+"</title>");
        writer.print("</head>");

        writer.print("<body>");
        writer.print("<h1>" + TITLE + "</h1>");
        writer.print("<form method='post'>");
        writer.print("<table>");

        writer.print("<tr>");
        writer.print("<td>Name:</td>");
        writer.print("<td><input name='name'/></td>");
        writer.print("</tr>");

        writer.print("<tr>");
        writer.print("<td>Address:</td>");
        writer.print("<td><textarea name='address' cols='40' rows='5'></textarea></td>");
        writer.print("</tr>");

        writer.print("<tr>");
        writer.print("<td>Country:</td>");
        writer.print("<td>" +
                "<select name='country'>" +
                    "<option>China</option>"+
                    "<option>Canada</option>"+
                    "<option>United States</option>"+
                "</select>" +
                "</td>");
        writer.print("</tr>");

        writer.print("<tr>");
        writer.print("<td>Delivery Method:</td>");
        writer.print("<td>" +
                        "<input type='radio' name='deliveryMethod' value='First Class' />First Class" +
                        "<input type='radio' name='deliveryMethod' value='Second Class' />Second Class" +
                    "</td>");
        writer.print("</tr>");

        writer.print("<tr>");
        writer.print("<td>Shipping Instructions:</td>");
        writer.print("<td><textarea name='instructions' cols='40' rows='5'></textarea></td>");
        writer.print("</tr>");

        writer.print("<tr>");
        writer.print("<td>&nbsp:</td>");
        writer.print("<td><textarea name='instructions' cols='40' rows='5'></textarea>  </td>");
        writer.print("</tr>");

        writer.print("<tr>");
        writer.print("<td>Please send me the latest product catalog:</td>");
        writer.print("<td><input type='checkbox' name='catalogRequest'/></td>");
        writer.print("</tr>");

        writer.print("<tr>");
        writer.print("<td>&nbsp:</td>");
        writer.print("<td>" +
                "<input type='reset'/>" +
                "<input type='submit'/>" +
                "</td>");
        writer.print("</tr>");

        writer.print("</table>");
        writer.print("</form>");
        writer.print("</body>");
        writer.print("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html>");
        writer.print("<head>");
        writer.print("<title>"+TITLE+"</title>");
        writer.print("</head>");

        writer.print("<body>");
        writer.print("<h1>" + TITLE + "</h1>");
        writer.print("<form method='post'>");
        writer.print("<table>");

        writer.print("<tr>");
        writer.print("<td>Name:</td>");
        writer.print("<td>" + request.getParameter("name") + "</td>");
        writer.print("</tr>");

        writer.print("<tr>");
        writer.print("<td>Address:</td>");
        writer.print("<td>" + request.getParameter("address") + "</td>");
        writer.print("</tr>");

        writer.print("<tr>");
        writer.print("<td>Country:</td>");
        writer.print("<td>" + request.getParameter("country") + "</td>");
        writer.print("</tr>");

        writer.print("<tr>");
        writer.print("<td>Delivery Method:</td>");
        writer.print("<td>" + request.getParameter("deliveryMethod") + "</td>");
        writer.print("</tr>");

        writer.print("<tr>");
        writer.print("<td>Shipping Instructions:</td>");
        writer.print("<td>");
        String[] instructions = request.getParameterValues("instructions");
        if(instructions!=null){
            for (String instruction: instructions){
                writer.print(instruction + "</br>");
            }
        }
        writer.print("</td>");
        writer.print("</tr>");

        writer.print("<tr>");
        writer.print("<td>Please send me the latest product catalog:</td>");
        writer.print("<td>");
        if(request.getParameter("catalogRequest")!=null){
            writer.print("Yes");
        }else {
            writer.print("No");
        }
        writer.print("</td>");
        writer.print("</tr>");

        writer.print("</table>");
        writer.print("</form>");

        writer.print("<div style='border: 1px solid #ddd; margin-top:40xp;font-size:90%'>");
        writer.print("Debug Info</br>");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String paramName = parameterNames.nextElement();
            String[] parameterValues = request.getParameterValues(paramName);
            writer.print(paramName+":");
            for (String value:parameterValues){
                writer.print(value+"</br>");
            }
        }
        writer.print("</div>");

        writer.print("</body>");
        writer.print("</html>");
    }
}
