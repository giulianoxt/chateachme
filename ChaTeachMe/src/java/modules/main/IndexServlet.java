/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modules.main;

import controller.CTLServlet;
import dao.IUsuarioDAO;
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
        } catch (Exception ex) {
            System.out.println("IndexServlet::handleRequest");
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
            System.out.println("IndexServlet::Sair");
            e.printStackTrace();
        }
    }

}
