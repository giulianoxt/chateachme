/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modules.admin;

import controller.CTLServlet;
import dao.DAOFactory;
import dao.IAdministradorDAO;
import dao.IUsuarioDAO;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author max
 */
public class AdminServlet extends CTLServlet {
    private DAOFactory daoFactory = DAOFactory.getDAOFactory();

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
                getServletContext().setAttribute("administrador", admin.getLogin());
            } else {
                getServletContext().setAttribute("administrador", null);
            }

            getServletContext().setAttribute("usuarios", daoFactory.findAllUsuarios());
            getServletContext().setAttribute("salas", daoFactory.findAllSalas());
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            System.out.println("AdminServlet::handleRequest");
            ex.printStackTrace();
        }
    }

    public void Up(HttpServletRequest request, HttpServletResponse response) {
        handleRequest(request, response);
    }
}
