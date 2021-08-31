package com.servlet.keepstate.urloverwrite;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-22 23:41
 **/
@WebServlet(name = "Top10CityServlet",urlPatterns = {"/top10Main"})
public class Top10CityServlet extends HttpServlet {
    private static final long serialVersionUID=1L;

    private List<String> londonAttractions = new ArrayList<>();
    private List<String> parisAttractions = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        londonAttractions.add("Buckingham Palace");
        londonAttractions.add("London Eye");
        londonAttractions.add("British Museum");
        londonAttractions.add("National Gallery");
        londonAttractions.add("Big Ben");
        londonAttractions.add("Tower of London");
        londonAttractions.add("Natural History Museum");
        londonAttractions.add("Canary Wharf");
        londonAttractions.add("2012 Olympic Park");
        londonAttractions.add("St Paul's Cathedral");

        parisAttractions.add("Eiffel Tower");
        parisAttractions.add("Notre Dame");
        parisAttractions.add("The Louvre");
        parisAttractions.add("Champs Elysees");
        parisAttractions.add("Arc de Triomphe");
        parisAttractions.add("Sainte Chapelle Church");
        parisAttractions.add("Les Invalides");
        parisAttractions.add("Musee d'orsay");
        parisAttractions.add("Montmarte");
        parisAttractions.add("Sacre Couer Basilica");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("city");
        if(city!=null && (city.equals("london") || city.equals("paris"))){
            showAttractions(request,response,city);
        }else {
            showMain(request,response,city);
        }
    }

    public void showAttractions(HttpServletRequest request, HttpServletResponse response,String city) throws IOException {
        int page = 1;
        String pageParam = request.getParameter("page");
        if(pageParam != null){
            page = Integer.parseInt(pageParam);
            if(page>2){
                page=1;
            }
        }
        List<String> attractions = new ArrayList<>();
        if(city.equals("london")){
            attractions = londonAttractions;
        }else if(city.equals("paris")){
            attractions = parisAttractions;
        }

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html>");
        writer.print("<head>");
        writer.print("<title>Top 10 Tourise Attractions</title>");
        writer.print("</head>");
        writer.print("<body>" +
                "<a href='top10Main'>Select City</a>" +
                "<hr/>Page" + page + "<hr/>");

        int start = page * 5 -5;
        for (int i = start; i < start + 5; i++) {
            writer.print(attractions.get(i) + "</br>");
        }
        writer.print("<hr style='color:blue'/>" +
                "<a href='?city=" + city + "&page=1'>Page 1</a>"+
                "&nbsp;&nbsp;<a href='?city=" + city + "&page=2'>Page 2</a>"
        );
        writer.print("</body></html>");
    }

    public void showMain(HttpServletRequest request, HttpServletResponse response,String city) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html>");
        writer.print("<head>");
        writer.print("<title>Top 10 Tourise Attractions</title>");
        writer.print("</head>");
        writer.print("<body>" +
                "Please select a city:" +
                "</br><a href='?city=london'>London</a>" +
                "</br><a href='?city=paris'>Paris</a>" +
                "</body>");
        writer.print("</html>");
    }
}
