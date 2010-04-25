/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modules.login;

import controller.CTLServlet;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author max
 */
public class CadastroServlet extends CTLServlet {

    public String getServletInfo() {
        return "Short description";
    }

    protected void handleControllerNotFound(HttpServletRequest request, HttpServletResponse response) {
    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/cadastro.jsp");

            dispatcher.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Cadastrar(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            PrintWriter out;
            String nome, email, login, senha;

            out = response.getWriter();

            nome = request.getParameter("nome");
            email = request.getParameter("email");
            login = request.getParameter("login");
            senha = request.getParameter("senha");

            if (nome == null || nome.length() < 5)
            {
                out.print("Valor do campo Nome inválido");
            }
            else if (email == null || email.length() < 5) //TODO: Checar e-mail com regex
            {
                out.print("Endereço de e-mail inválido");
            }
            else if (login == null || login.length() < 5)
            {
                out.print("Login inválido");
            }
            else if (senha == null || senha.length() < 5)
            {
                out.print("Senha inválida");
            }
            else
            {
                business.Autenticacao.cadastrarUsuario(nome, email, login, senha);
                out.print("true");
            }            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
