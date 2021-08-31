package com.servlet.simpletag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-25 17:29
 **/
public class SelectElementTag extends SimpleTagSupport {
    private String[] countries = {"Australia","Brazil","China"};

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print("<select>");
        for (int i = 0; i < 3; i++) {
            getJspContext().setAttribute("value",countries[i]);
            getJspContext().setAttribute("text",countries[i]);
            getJspBody().invoke(null);
        }
        out.print("</select>");
    }
}
