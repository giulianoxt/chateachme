/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modules.admin;

import controller.CTLServlet;
import dao.DAOFactory;
import dao.ISalaDAO;
import java.io.*;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author max
 */
public class ProfessorServlet extends CTLServlet {

    public String getServletInfo() {
        return "Short description";
    }

    protected void handleControllerNotFound(HttpServletRequest request, HttpServletResponse response) {

    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher;
            HttpSession sess;
            Boolean login_ok;

            dispatcher = getServletContext().
                    getRequestDispatcher("/professor.jsp");

            login_ok = Boolean.valueOf(false);
            sess = request.getSession();
            if (sess != null && sess.getAttribute("usuario_obj") != null) {
                login_ok = Boolean.valueOf(true);
            }
            getServletContext().setAttribute("login_ok", login_ok);
            getServletContext().setAttribute("salas", DAOFactory.getDAOFactory().findAllSalas());

            dispatcher.forward(request, response);
        } catch (Exception ex) {
            System.out.println("ProfessorServlet::handleRequest");
            ex.printStackTrace();
        }
    }

    public void CadastrarSala(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            HttpSession sess;
            PrintWriter out;
            DAOFactory mem;
            ISalaDAO sala;
            String descricao, titulo, ip;

            sess = request.getSession(false);
            out = response.getWriter();
            if (sess == null || sess.getAttribute("usuario_obj") == null)
            {
                out.print("false");
            }
            else
            {
                titulo = request.getParameter("titulo");
                ip = request.getParameter("ip");
                descricao = request.getParameter("descricao");

                mem = DAOFactory.getDAOFactory();
                sala = mem.newSala();
                sala.setDataCriacao(new Date());
                sala.setDescricao(descricao);
                sala.setIpCamera(Integer.getInteger(ip));
                sala.setSalaAberta(Boolean.FALSE);
                sala.setTitulo(titulo);
                business.Facade.cadastrarSala(sala);

                out.print("true");
            }
        }
        catch (Exception e)
        {
            System.out.println("ProfessorServlet::CadastrarSala");
            e.printStackTrace();
        }
    }
}
