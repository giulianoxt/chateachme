/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modules.login;

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
public class CheckLoginServlet extends CTLServlet {

    public String getServletInfo() {
        return "Short description";
    }

    protected void handleControllerNotFound(HttpServletRequest request, HttpServletResponse response) {

    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter out = response.getWriter();
            out.print("true");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
