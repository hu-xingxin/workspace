package com.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-31 11:21
 **/
public class AsyncCompleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        final PrintWriter writer = resp.getWriter();
        writer.print("<html><head><title>AsyncCompleteServlet</title></head>");
        writer.print("<body><div id='progress'></div>");
        final AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(60000);
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                System.out.println("new Thread:" + Thread.currentThread());
                for (int i = 0; i < 10; i++) {
                    writer.print("<script type='text/javascript'>" +
                            "document.getElementById('progress').innerHTML='" + (i*10) + "% complete'" +
                            "</script>");
                    writer.flush();

                }
            }
        });
        writer.print("<script>document.getElementById('progress').innerHtml='DONE'</script>");
        writer.print("</body></html");
        asyncContext.complete();
    }
}
