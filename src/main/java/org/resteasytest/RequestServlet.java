/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.resteasytest;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

/**
 *
 * @author Andrej Galád <agalad@redhat.com>
 */
public class RequestServlet extends HttpServlet {

	/**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = request.getRequestURL().toString() + "rest/content_type";
        String acceptHeader = request.getParameter("accept");
        
        ClientRequest clientRequest = new ClientRequest(url);
        if (!acceptHeader.equals(""))
            clientRequest.header("Accept", acceptHeader);
        
        ClientResponse<String> clientResponse = null;
        try {
            clientResponse = clientRequest.get(String.class);
            
            try (PrintWriter writer = response.getWriter()) {
                writer.println("<div>Response Status:" + clientResponse.getResponseStatus() + "</div>");
                for (Object object : clientResponse.getHeaders().keySet())
                    writer.print("<div>Response Headers:" + object + " : " + clientResponse.getHeaders().get(object) + "</div>");
                writer.println("Response:<pre>" + clientResponse.getEntity() + "</pre>");            
            }
        } catch (Exception e) {
            response.getWriter().println(e);
        } finally {
            clientResponse.releaseConnection();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Tests RESTEasy MimeType";
    }
}
