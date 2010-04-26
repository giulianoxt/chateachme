/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modules.salas;

import controller.CTLServlet;
import dao.DAOFactory;
import java.io.*;
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

            DAOFactory df = DAOFactory.getDAOFactory();
            getServletContext().setAttribute("salas", df.findAllSalas());

            dispatcher.forward(request, response);
        } catch (Exception ex) {
            System.out.println("SalasServlet::handleRequest");
            ex.printStackTrace();
        }
    }

}
