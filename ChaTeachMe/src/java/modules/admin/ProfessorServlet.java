/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modules.admin;

import controller.CTLServlet;
import dao.ISalaDAO;
import dao.memory.MemoryDAOFactory;
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

            dispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void CadastrarSala(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            HttpSession sess;
            PrintWriter out;
            MemoryDAOFactory mem;
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

                mem = MemoryDAOFactory.getInstance();
                sala = mem.newSala();
                sala.setDataCriacao(new Date());
                sala.setDescricao(descricao);
                sala.setIpCamera(Integer.getInteger(ip));
                sala.setSalaAberta(Boolean.FALSE);
                sala.setTitulo(titulo);
                business.Administracao.cadastrarSala(sala);

                out.print("true");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
