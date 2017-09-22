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

public class registerCustomer extends HttpServlet {
    public static final String VUE = "/WEB-INF/registerCustomer.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        getCustomer App = new getCustomer();
        request.setAttribute( "nodeList", App.getCustomer());
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        Map<String, String> errors = new HashMap<String, String>();
        String result;

        /* Traitement des données du formulaire */
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String returned = request.getParameter("return");
        String itemName = request.getParameter("itemName");
        String itemType = request.getParameter("itemType");
        String itemDate = request.getParameter("itemDate");

        addCustomer App = new addCustomer();
        App.addCustomer(fname, lname, itemType, itemName, itemDate, returned);

        if ( errors.isEmpty() ) {
            result = "Success registering new customer.";
        } else {
            result = "Error while registering new customer.";
        }

        /* Stockage du résultat et des messages d'erreur dans l'objet request */
        getCustomer App2 = new getCustomer();
        request.setAttribute( "nodeList", App2.getCustomer());
        request.setAttribute( "Fail", errors );
        request.setAttribute( "Success", result );

        /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
