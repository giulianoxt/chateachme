/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modules.login;

import controller.CTLServlet;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author max
 */
public class LoginServlet extends CTLServlet {
   
    public String getServletInfo() {
        return "Short description";
    }

    protected void handleControllerNotFound(HttpServletRequest request, HttpServletResponse response) {

    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            System.out.println("LoginServlet::handleRequest");
            ex.printStackTrace();
        }
    }
    
    public void Error(
            HttpServletRequest request,
            HttpServletResponse response)
    {
        try {
            request.setAttribute("Example", "Exemplo1");
            getServletContext().setAttribute("ex", "S");
            RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/login_error.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            System.out.println("LoginServlet::Error");
            e.printStackTrace();
        }
    }
}
