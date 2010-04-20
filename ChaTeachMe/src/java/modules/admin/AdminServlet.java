/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modules.admin;

import controller.CTLServlet;
import dao.IAdministradorDAO;
import dao.IUsuarioDAO;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author max
 */
public class AdminServlet extends CTLServlet {

    public String getServletInfo() {
        return "Short description";
    }

    protected void handleControllerNotFound(HttpServletRequest request, HttpServletResponse response) {

    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/admin.jsp");

            HttpSession sess = request.getSession();
            if (sess != null && sess.getAttribute("usuario_obj") != null) {
                IUsuarioDAO admin = (IUsuarioDAO) sess.getAttribute("usuario_obj");
                // TODO: CHECAR SE É ADMINISTRADOR
                getServletContext().setAttribute("administrador", admin.getLogin());
            } else {
                getServletContext().setAttribute("administrador", null);
            }

            dispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void Up(HttpServletRequest request, HttpServletResponse response) {
        handleRequest(request, response);
    }
}
