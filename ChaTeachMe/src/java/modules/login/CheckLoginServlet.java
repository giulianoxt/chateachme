/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modules.login;

import controller.CTLServlet;

import controller.CTLServlet;
import dao.IAdministradorDAO;
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
public class CheckLoginServlet extends CTLServlet {

    public String getServletInfo() {
        return "Short description";
    }

    protected void handleControllerNotFound(HttpServletRequest request, HttpServletResponse response) {

    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter out = response.getWriter();
            try {
                HttpSession sess = request.getSession(true);
                String tipo = request.getParameter("tipo");
                if (tipo == null) {
                    IUsuarioDAO usuario = business.Facade.login(
                        request.getParameter("usuario"), request.getParameter("senha"));
                    sess.setAttribute("usuario_obj", usuario);
                    out.print("true");
                }
            } catch (Exception e_login) {
                out.print("false");
            }
        } catch (Exception ex) {
            System.out.println("CheckLoginServlet::handleRequest");
            ex.printStackTrace();
        }
    }

}
