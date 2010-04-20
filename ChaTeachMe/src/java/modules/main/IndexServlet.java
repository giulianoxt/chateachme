/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modules.main;

import controller.CTLServlet;

import controller.CTLServlet;
import dao.IUsuarioDAO;
import dao.memory.MemoryDAOFactory;
import dao.memory.UsuarioDAO;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author max
 */
public class IndexServlet extends CTLServlet {

    public String getServletInfo() {
        return "Short description";
    }

    protected void handleControllerNotFound(HttpServletRequest request, HttpServletResponse response) {

    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/main.jsp");

            HttpSession sess = request.getSession();
            if (sess != null && sess.getAttribute("usuario_obj") != null) {
                IUsuarioDAO usuario = (IUsuarioDAO) sess.getAttribute("usuario_obj");
                getServletContext().setAttribute("usuario", usuario.getLogin());
            } else {
                getServletContext().setAttribute("usuario", null);
            }

            dispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void Sair(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession sess = request.getSession();
            if (sess != null) {
                sess.setAttribute("usuario_obj", null);
            }
            handleRequest(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
