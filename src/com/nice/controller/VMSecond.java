package com.nice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VMSecond
 */
public class VMSecond extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public VMSecond() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  System.out.println("In VM Second ");
			
		/*  RequestDispatcher rd = getServletContext().getRequestDispatcher("/userdashbord.jsp");
		  rd.forward(request, response);*/
		  response.sendRedirect("VM2");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
