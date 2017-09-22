package Servlet;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import Customer.*;
import java.lang.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class modifyCustomer extends HttpServlet {
    public static final String VUE = "/WEB-INF/modifyCustomer.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        modifyCustomers App = new modifyCustomers();

        request.setAttribute( "customer", App.getSingleCustomer(Integer.parseInt(request.getParameter("id"))));
        request.setAttribute("idCustomer", Integer.parseInt(request.getParameter("id")));
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        int idCustomer = Integer.parseInt(request.getParameter("id"));
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String returned = request.getParameter("return");
        String itemName = request.getParameter("itemName");
        String itemType = request.getParameter("itemType");
        String itemDate = request.getParameter("itemDate");

        modifyCustomers App = new modifyCustomers();
        App.modifyCustomer(idCustomer, fname, lname, itemType, itemName, itemDate, returned);
        this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response );
    }
}
