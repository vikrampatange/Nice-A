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
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;
 	private ControlCenterService controlCenterService ;
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        
          userService=new UserService();
        controlCenterService = new ControlCenterService();
        
        
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
		
		
		
		
		
		
		
		
		
		

		  String action = request.getParameter("action");
		 
 
		 System.out.println("The action is:"+action);
		
		
		
		
		
		
		
		
		
		
		
		
		
		

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
			userService.addLoginAttempt(userName);
			
			
			String message="You are Successfully Register :) ";
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/userregistration.jsp?message=" +message);
			rd.forward(request, response);
			
		}
		
	else
		
		
		
		
		
		 if(action.equals("userLogin"))
		 {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String vm = request.getParameter("vm");
			String clientIp = request.getParameter("clientIp");
			
		    //System.out.println("Client Ip :" +clientIp);
		    
		    System.out.println("VM= "+vm );
			String message="";
			
			
			
			//UserService userService=new UserService();
			//ControlCenterService controlCenterService = new ControlCenterService();
			
			 
			boolean valid= userService.isValidUser(userName, password);
			
			int loginAttempt=userService.getLoginAttempt(userName);
			
			boolean lockUser=userService.isLockedUser(userName);
			
			
		//controlCenterService.addvm(vm,VMStatusMode.VULNERABLE);//add from vikram  pasing (vm & status mode)
			
			
			boolean isZombieVm=controlCenterService.isZombieVm(vm);
            
              

	
			
			System.out.println("Valid= " +valid);
			System.out.println("loginAttempt= " +loginAttempt);
			System.out.println("loginAttempt= " +isZombieVm);
			
			if(isZombieVm==true)
			{
				message="Selected Virtul Matchine "+vm+" infected by ZOMBIE Attack  Please select other ";
				
		        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp?message=" +message);
				rd.forward(request, response);
			}
			
			else if(lockUser==true){
				
				message="User Locked Due to invalid Login Attempt  Please Try After Some time !!!!";
				
		    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp?message=" +message);
				rd.forward(request, response);
			}
			
			else if(valid==true && loginAttempt <1)
			 {      
				    userService.updateLoginAttempt(userName, 0);
				    

               	    if(vm.equals("VM1"))
					  {
						  response.sendRedirect("VMFirst");  
					  }
					  else if(vm.equals("VM2")){
						  
						  response.sendRedirect("VMSecond");
					  }
				   /* RequestDispatcher rd = getServletContext().getRequestDispatcher("/userdashbord.jsp");
					rd.forward(request, response);*/
			 }
			
			  else if(valid==true && loginAttempt<=3)
			    {
				             userService.updateLoginAttempt(userName, 0);
				             
				                  if(controlCenterService.isExploited(vm)==false)
				                  {
				                	  controlCenterService.updateVMStatus(vm,VMStatusMode.VULNERABLE);     
				                  }
				                   
				             
			    	               if(vm.equals("VM1"))
					                 {
						              response.sendRedirect("VMFirst");  
					                }
					               else if(vm.equals("VM2")){
						  
						               response.sendRedirect("VMSecond");
					               }
			    	               
			    	             //  controlCenterService.updateVMStatus(vm, VMStatusMode.EXPLOITED);
			    	
			    	/*RequestDispatcher rd = getServletContext().getRequestDispatcher("/userdashbord.jsp");
					rd.forward(request, response);*/
			    }
			
			
			  /*  else if(valid==true && loginAttempt<=3){
			    	
			    	userService.updateLoginAttempt(userName, 0);
			    	controlCenterService.updateVMStatus(vm, VMStatusMode.EXPLOITED);
			    	
			    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/userdashbord.jsp");
					rd.forward(request, response);
			    	
			    }*/
			 
			    else if(valid==true &&loginAttempt>3)
			    {
			    	
			    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/usersec.jsp?userName="+userName+"&vm="+vm);
					rd.forward(request, response);
			    }
			    
			 else{
			    	
			    	int logat=userService.getLoginAttempt(userName);
			    	 
			    	
			    	 if(controlCenterService.isExploited(vm)==false)
	                  {
	                	  controlCenterService.updateVMStatus(vm,VMStatusMode.VULNERABLE);   
	                  }
			    	userService.updateLoginAttempt(userName, logat+1);//update  atttemptng number
			    	
			    	controlCenterService.updateLoginAttackCount();//set count & login attack
			    	message="Invalid user Details";
			    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp?message=" +message);
					rd.forward(request, response);
			    }
		          
		       
		}
		
		
		
		
		
		
		
		
		
		
		
		
	  else if(action.equals("userSec"))
	  {
		
		String userName = request.getParameter("userName");
		String vm = request.getParameter("vm");
		String secQues=request.getParameter("secQues");
		String answer=request.getParameter("answer");
		
		
		
		System.out.println("**********************************************");
		System.out.println("userName="+ userName);
		System.out.println("secQues="+ secQues);
		System.out.println("answer="+ answer);
		System.out.println("**********************************************");
		
		//UserService userService=new UserService();
		//ControlCenterService controlCenterService = new ControlCenterService();
		
		
		boolean valid= userService.isValidUserByQuestion(userName, secQues, answer); 
		  if(valid==true)
		  {
			  userService.updateLoginAttempt(userName, 0);
			  
			 
			  
			  
			/*  if(vm.equals("VM1"))
			  {
				  response.sendRedirect("VMFirst");  
			  }
			  else if(vm.equals("VM2")){
				  
				  response.sendRedirect("VMSecond");
			  }
			  
			   controlCenterService.updateVMStatus(vm,VMStatusMode.ZOMBIE);
			  */
			  
			  RequestDispatcher rd = getServletContext().getRequestDispatcher("/userdashbord.jsp");
			  rd.forward(request, response);
			  
		 }
		  else
		  {
			  
			    userService.lockUser(userName);
			    
			    userService.updateLoginAttempt(userName, 0);
			    
			    String message="User Locked Due to invalid Login Attempt !!!!";
			    
		    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp?message=" +message);
		    	
				rd.forward(request, response);
			  
		  }
		
		
		
		
	}
		
	
	}
}
