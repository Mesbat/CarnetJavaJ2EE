package Servlet;

import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.IOException;
import Customer.*;
import java.lang.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class xmlTest extends HttpServlet {
    public static final String VUE = "/xmlTest.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        try {
            File file = new File("carnet.xml");
            if (file.delete()) {
                System.out.println("CARNET RESET");
                addCustomer App = new addCustomer();
                App.addCustomer("Michel", "Le testeur", "Art", "Test World", "2017-03-16", "");
                App.addCustomer("Jean", "testeur", "Book", "Test World Premium", "2017-02-15", "");
                App.addCustomer("Igor", "OnTest", "Book", "Test World 3", "2017-01-06", "");
                App.addCustomer("MichMich", "QuiTest", "Movie", "WETEST-World", "2017-03-12", "");
                App.addCustomer("Mich", "TuPeuxPasTest", "Game", "Test", "2017-03-14", "");
            } else {
                System.out.println("CARNET NOT RESET");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
