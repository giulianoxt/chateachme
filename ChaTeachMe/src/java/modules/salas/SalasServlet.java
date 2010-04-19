/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modules.salas;

import controller.CTLServlet;

import controller.CTLServlet;
import dao.memory.MemoryDAOFactory;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author max
 */
public class SalasServlet extends CTLServlet {

    public String getServletInfo() {
        return "Short description";
    }

    protected void handleControllerNotFound(HttpServletRequest request, HttpServletResponse response) {

    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/salas.jsp");

            MemoryDAOFactory md = MemoryDAOFactory.getInstance();
            getServletContext().setAttribute("salas", md.findAllSalas());

            dispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
