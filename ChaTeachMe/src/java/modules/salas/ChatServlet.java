/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modules.salas;

import sun.misc.BASE64Decoder;
import controller.CTLServlet;
import dao.DAOFactory;
import dao.IMensagemDAO;
import dao.ISalaDAO;
import dao.IUsuarioDAO;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author max
 */
public class ChatServlet extends CTLServlet {
    // mudar isso depois, quando tiver usando o BD
    private static int msgCount = 5;

    public String getServletInfo() {
        return "Short description";
    }

    protected void handleControllerNotFound(HttpServletRequest request, HttpServletResponse response) {
    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession sess;
            Boolean login_ok, sala_ok;
            ISalaDAO sala;
            Collection msgs;
            DAOFactory daoFactory;

            RequestDispatcher dispatcher = getServletContext().
                    getRequestDispatcher("/chat.jsp");

            sess = request.getSession(false);
            login_ok = Boolean.valueOf(false);
            sala_ok = Boolean.valueOf(false);
            daoFactory = DAOFactory.getDAOFactory();
            if (sess != null) {
                IUsuarioDAO usuario = (IUsuarioDAO) sess.getAttribute("usuario_obj");
                if (usuario != null) {
                    login_ok = Boolean.valueOf(true);
                    getServletContext().setAttribute("usuario_login", usuario.getLogin());

                    sala = daoFactory.findSala(request.getParameter("sala"));
                    if (sala != null) {
                        sala_ok = Boolean.valueOf(true);
                        
                        msgs = business.Facade.getMensagensNaoLidas(usuario, sala, new Date(0));

                        business.Facade.entrarEmSala(usuario, sala);

                        getServletContext().setAttribute("titulo", sala.getTitulo());
                        getServletContext().setAttribute("mensagens", msgs);

                        sess.setAttribute("sala_obj", sala);
                        //TODO: Mudar linha abaixo ( Data )
                        sess.setAttribute("data_atualizacao", new Date());
                    }
                }
            }
            getServletContext().setAttribute("login_ok", login_ok);
            getServletContext().setAttribute("sala_ok", sala_ok);

            dispatcher.forward(request, response);
        } catch (Exception ex) {
            System.out.println("ChatServlet::handleRequest");
            ex.printStackTrace();
        }
    }

    public void EnviarMensagem(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession sess;
            PrintWriter out;
            IUsuarioDAO usuario;
            ISalaDAO sala;
            IMensagemDAO msg;

            out = response.getWriter();
            sess = request.getSession(false);
            if (sess == null || sess.getAttribute("sala_obj") == null || sess.getAttribute("usuario_obj") == null)
            {
                out.print("false");
            }
            else
            {
                usuario = (IUsuarioDAO) sess.getAttribute("usuario_obj");
                sala = (ISalaDAO) sess.getAttribute("sala_obj");
                msg = DAOFactory.getDAOFactory().newMensagem();
                msg.setDataEnvio(new Date());
                msg.setSala(sala);

                //TODO: Mudar linha abaixo ( O valor de id é incrementado automaticamente )
                msg.setId(new Integer(++msgCount));

                String msg_base64 = request.getParameter("texto");

                BASE64Decoder decoder = new BASE64Decoder();
                byte[] msg_bytes = decoder.decodeBuffer(msg_base64);
                String msg_text = new String(msg_bytes, "ASCII");
                msg.setMensagem(msg_text);
                
                msg.setTipo(request.getParameter("tipo_texto"));
                msg.setUsuario(usuario);
                business.Facade.enviarMensagem(usuario, msg);
                out.print("true");
            }
        } catch (Exception e) {
            System.out.println("ChatServlet::EnviarMensagem");
            e.printStackTrace();
        }
    }

    public void GetMensagens(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession sess;
            PrintWriter out;
            IUsuarioDAO usuario;
            ISalaDAO sala;
            IMensagemDAO msg;
            Collection msgs;
            Date atualiza;
            Iterator it_msg;

            out = response.getWriter();
            sess = request.getSession(false); 
            if (sess == null || sess.getAttribute("sala_obj") == null || sess.getAttribute("usuario_obj") == null)
            {
                out.print("false");
            }
            else
            {
                usuario = (IUsuarioDAO) sess.getAttribute("usuario_obj");
                sala = (ISalaDAO) sess.getAttribute("sala_obj");
                atualiza = (Date) sess.getAttribute("data_atualizacao");

                ArrayList arr = new ArrayList();

                Date last = (Date)sess.getAttribute("data_atualizacao");
                if (last == null)
                  last = new Date(0);

                //MUDAR LINHA ABAIXO
                msgs = business.Facade.getMensagensNaoLidas(usuario, sala, last);
                //MUDAR LINHA ABAIXO
                sess.setAttribute("data_atualizacao", new Date());

                it_msg = msgs.iterator();
                while (it_msg.hasNext())
                { 
                    msg = (IMensagemDAO) it_msg.next();
                    arr.add(msg.getUsuario().getLogin());
                    if (msg.getTipo().equals("texto"))
                    {
                        arr.add(msg.getMensagem());
                    }
                    else if (msg.getTipo().equals("latex"))
                    {
                        arr.add("<img src=\"http://www.codecogs.com/gif.latex?" + msg.getMensagem() + "\">");
                    }
                    
                }

                org.json.JSONArray array = new org.json.JSONArray();
                array.put(arr);
                out.print(array);
            }
        } catch (Exception e) {
            System.out.println("ChatServlet::getMensagens");
            e.printStackTrace();
        }
    }
}
