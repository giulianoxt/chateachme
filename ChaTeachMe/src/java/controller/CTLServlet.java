/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.StringTokenizer;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author max
 */
abstract public class CTLServlet extends HttpServlet {
    
    static final Class[] formalArgs = {HttpServletRequest.class, HttpServletResponse.class};
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            request.setAttribute("servletPath", request.getServletPath());
            //getController(this, getMethodName(request));
            dispatch(getController(this, getMethodName(request)), this, request, response);
        } catch (Exception e) {
            System.out.println("CTLServlet::processRequest");
            e.printStackTrace();
        }
    }
    
    protected void dispatch(
            Method name,
            Object target,
            HttpServletRequest request,
            HttpServletResponse response)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        name.invoke(target, new Object[] {request, response});
    }
    
    protected Method getController(
            Object target,
            String methodName) throws NoSuchMethodException
    {
        return target.getClass().getMethod(methodName, formalArgs);
    }
    
    protected String getMethodName(
            HttpServletRequest request)
    {
        String methodName = "handleRequest";
        if (request.getQueryString() != null)
        {
            StringTokenizer tokens = new StringTokenizer(request.getQueryString(), "&");
            if (tokens.hasMoreTokens())
            {
                methodName = tokens.nextToken();
            }
        }
        System.out.println("getMethodName " + methodName + " " + request.getQueryString());
        return methodName;
    }
    
    abstract protected void handleControllerNotFound(
            HttpServletRequest request,
            HttpServletResponse response
    );
    
    abstract public void handleRequest(
            HttpServletRequest request,
            HttpServletResponse response);

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
