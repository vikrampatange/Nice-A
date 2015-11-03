package com.nice.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nice.service.ControlCenterService;
import com.nice.service.UserService;
import com.nice.util.VMStatusMode;

/**
 * Servlet implementation class ControlCenter
 */
public class ControlCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	private ControlCenterService controlCenterService ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlCenter() {
        super();
        
        userService=new UserService();
        controlCenterService = new ControlCenterService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		 //ControlCenterService controlCenterService = new ControlCenterService();
		
		if (action.equals("changestatus")) {
			
			 String vm = request.getParameter("vm"); 
			 //ControlCenterService controlCenterService = new ControlCenterService();
			 controlCenterService.updateVMStatus(vm, VMStatusMode.STABLE);
			/*RequestDispatcher rd = getServletContext().getRequestDispatcher("/controlcenterdash.jsp");
			rd.forward(request, response);*/
			 response.sendRedirect("controlcenterdash.jsp");
		}
		
		else if(action.equals("changeAttack"))
		    {
			 String clientIp = request.getParameter("clientIp"); 
			 controlCenterService.deleteSqlInjection(clientIp);
			/*RequestDispatcher rd = getServletContext().getRequestDispatcher("/controlcenterdash.jsp");
			rd.forward(request, response);*/
			 response.sendRedirect("controlcenterdash.jsp");
			
		    }
		else if(action.equals("changeXssIp"))
	    {
		 String clientIp = request.getParameter("clientIp"); 
		 controlCenterService.deleteXssAtackIp(clientIp);
		/*RequestDispatcher rd = getServletContext().getRequestDispatcher("/controlcenterdash.jsp");
		rd.forward(request, response);*/
		 response.sendRedirect("controlcenterdash.jsp");
		
	    }
		else if(action.equals("resetAll"))
	    {
		
		 controlCenterService.resetAll();
		/*RequestDispatcher rd = getServletContext().getRequestDispatcher("/controlcenterdash.jsp");
		rd.forward(request, response);*/
		 response.sendRedirect("controlcenterdash.jsp");
		
	    }
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		System.out.println(action);
		
		if (action.equals("userReg")) {
			
			//String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			String userName = request.getParameter("userName");
			String userEmail = request.getParameter("userEmail");
			String userMobile = request.getParameter("userMobile");
			String secQues=request.getParameter("secQues");
			String answer=request.getParameter("answer");
			
			
			 String path="c:/nice/users";
        	//File path = new File(uploadpath);
        	
        	new File(path +"/" + userName).mkdirs();
			
			//UserService userService=new UserService();
			userService.addUser(userName, password, userEmail, userMobile, secQues, answer);
			
			
			String message="You are Successfully Register :) ";
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/userregistration.jsp?message=" +message);
			rd.forward(request, response);
			
		}
		else if(action.equals("userLogin"))
		{
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String vm = request.getParameter("vm");
			String clientIp = request.getParameter("clientIp");
			
		    //System.out.println("Client Ip :" +clientIp);
		    
		    //System.out.println("VM= "+vm );
			String message="";
			
			//UserService userService=new UserService();
			boolean valid=   userService.isValidUser(userName, password);
			
			  HttpSession session= request.getSession();
			
				   
				    int loginAttempt;
				   
				    
		            if (session.getAttribute("loginCount") == null)
		            {
		            	System.out.println("First attaempt");
		                session.setAttribute("loginCount", 0);
		                loginAttempt = 0;
		                
		                if(valid==true ){
		                	
		                	 if(vm.equals("VM1"))
							  {
								  response.sendRedirect("VMFirst");  
							  }
							  else if(vm.equals("VM2")){
								  
								  response.sendRedirect("VMSecond");
							  }
		                }
		                
		               
		            }
		            else
		            {
		                 loginAttempt = (Integer) session.getAttribute("loginCount");
		                 
		                 System.out.println("Second part ");
		            }
		            
		            if(valid==true && loginAttempt <2)
		            {
		            	RequestDispatcher rd = getServletContext().getRequestDispatcher("/usersec.jsp?user=" +userName);
						rd.forward(request, response);
		            }
		            
		            if (loginAttempt >= 2 )
		            {        
		                long lastAccessedTime = session.getLastAccessedTime();
		                Date date = new Date();
		                long currentTime = date.getTime();
		                long timeDiff = currentTime - lastAccessedTime;
		                System.out.println("In lock position ");
		                // 20 minutes in milliseconds  
		                if (timeDiff >= 60000)
		                {
		                    //invalidate user session, so they can try again
		                    session.invalidate();
		                }
		                else
		                {
		                     // Error message 
		                     //session.setAttribute("message","You have exceeded the 3 failed login attempt. Please try loggin in in 20 minutes");
		                     message="You have exceeded the 3 failed login attempt. Please try loggin after 1 minutes";
		                     
		                }  

		            }
		            else
		            {
		                 loginAttempt++;
		                 int allowLogin = 3-loginAttempt;
		                 //session.setAttribute("message","loginAttempt= "+loginAttempt+". Invalid username or password. You have "+allowLogin+" attempts remaining. Please try again! <br>Not a registered cusomer? Please <a href=\"register.jsp\">register</a>!");
		                 
		                 message="LoginAttempt= "+loginAttempt+". Invalid username or password. You have "+allowLogin+" attempts remaining. Please try again! <br>Not a registered User ? Please <a href=\"register.jsp\">Register here</a>!";
		            }
		            session.setAttribute("loginCount",loginAttempt);
		     
		            System.out.println("loginAttempt: "+loginAttempt);
				   // String message="Please Enter Valid User Details  ";
				    
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp?message=" +message);
					rd.forward(request, response);
			   }
		}
		
		
	

}
