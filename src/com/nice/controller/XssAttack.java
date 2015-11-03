package com.nice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nice.service.ControlCenterService;
import com.nice.util.VMStatusMode;

/**
 * Servlet implementation class XssAttack
 */
public class XssAttack extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ControlCenterService controlCenterService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XssAttack() {
        super();
        controlCenterService = new ControlCenterService();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
		
		
		String userName = cleanXSS(request.getParameter("userName"));
		String password = request.getParameter("password");
		String vm = request.getParameter("vm");
		String clientIp = request.getParameter("clientIp");
		
		String para=userName+password+vm+clientIp;
		
		
		
		

		System.out.println(getStatementType(userName));
		String message="";
		boolean isZombieVm=controlCenterService.isZombieVm(vm);
		if(isZombieVm==true)
		{
			message="Selected Virtul Matchine "+vm+" infected by ZOMBIE Attack  Please select other ";
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/xssattack.jsp?message=" +message);
			rd.forward(request, response);
		}
		
		
		else if(controlCenterService.isValidClientIpForXss(clientIp)==true)
			
		{

			

		if(getStatementType(userName)==true)
		{
			controlCenterService.addXssAtack(clientIp);
			controlCenterService.updateScriptAttackCount();
			controlCenterService.updateVMStatus(vm, VMStatusMode.EXPLOITED);
			 message="Xss Scripting Detected";
		    response.sendRedirect("xssattack.jsp?message="+message);
		}
		else{
	
		//userName :<%=userName %><br>
		//clientIp :<%=clientIp%><br>
			
			 message="normal";
		    response.sendRedirect("xssattack.jsp?message="+message);


		} 
		}
		else{
			 message="Ip Locked due try Xss Scripting attack !";
		    response.sendRedirect("xssattack.jsp?message="+message);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	
	
	
	
	
	public  String cleanXSS(String value) {
		//You'll need to remove the spaces from the html entities below
		value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "& #41;");
		value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript : ( .* )[\\\"\\\']", "\"\"");
		//value = value.replaceAll("&", "&amp;");
		//value = value.replaceAll("&", "&amp;");
		//value = value.replaceAll("script", "");
		return value;
		}


	public  boolean getStatementType(String username) {

		if (username.contains("script") == true)
			 {
			return true;
		}

		else if (username.contains("META") == true)
				 {
			return true;
		}

		else if (username.contains("IMG") == true)
				{
			return true;
		}
		else if (username.contains("document") == true)
		{
	       return true;
	    }
		else if (username.contains("onload") == true)
		{
	       return true;
	    }

		
		else if (username.contains("div") == true||username.contains("DIV") )
				 {
			return true;
		} else {
			return false;
		}
	}

}
