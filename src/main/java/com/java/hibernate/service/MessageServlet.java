package com.java.hibernate.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
  
@WebServlet("/MessageServlet")  
public class MessageServlet extends HttpServlet {  
    private static final long serialVersionUID = 1L;  
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                            throws ServletException, IOException {  
          
    	ResteasyClient client = new ResteasyClientBuilder().build();
    	ResteasyWebTarget target = client.target("http://localhost:8080/HibernatePro/persist"+"/message from servlet");
    	Response respons = target.request().get();
    	String resp = respons.readEntity(String.class); 
    	response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.print("<html><body>");  
        out.print("<h3>"+resp+"</h3>");  
        out.print("</body></html>");  
    }  
}  