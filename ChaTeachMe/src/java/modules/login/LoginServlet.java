/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modules.login;

import controller.CTLServlet;
import java.io.*;
import java.net.*;

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
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void Error(
            HttpServletRequest request,
            HttpServletResponse response)
    {
        try {
            RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/login_error.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
