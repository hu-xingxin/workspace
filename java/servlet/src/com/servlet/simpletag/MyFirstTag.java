package com.servlet.simpletag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-25 14:57
 **/
public class MyFirstTag implements SimpleTag {
    private String items;
    private String header;
    JspContext jspContext;

    public void setItems(String items) {
        this.items = items;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("doTag");
        JspWriter out = jspContext.getOut();
        out.print("<table style='border:1px solid black'>" +
                    "<tr><td>" + header + "</td></tr>");
        StringTokenizer tokenizer = new StringTokenizer(items, ",");
        while(tokenizer.hasMoreTokens()){
            String item = tokenizer.nextToken();
            out.print( "<tr><td>" + item + "</td></tr>");
        }
        out.print( "</table>");
    }

    @Override
    public void setParent(JspTag parent) {
        System.out.println("setParent");
    }

    @Override
    public JspTag getParent() {
        System.out.println("getParent");
        return null;
    }

    @Override
    public void setJspContext(JspContext jspContext) {
        System.out.println("setJspContext");
        this.jspContext = jspContext;
    }

    @Override
    public void setJspBody(JspFragment body) {
        System.out.println("setJspBody");
    }
}
