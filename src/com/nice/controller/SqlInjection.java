package com.nice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nice.service.ControlCenterService;
import com.nice.service.UserService;
import com.nice.util.VMStatusMode;

/**
 * 
 */
public class SqlInjection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private UserService userService;
	 private ControlCenterService controlCenterService ;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SqlInjection()
	{
		super();
		 userService=new UserService();
	     controlCenterService = new ControlCenterService();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String vm = request.getParameter("vm");
		String clientIp = request.getParameter("clientIp");
		
		
		
		
		String para=userName+password+vm+clientIp;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		String username = userName.toLowerCase();

		String message = "";

		String action = request.getParameter("action");
		
		ControlCenterService controlCenterService = new ControlCenterService();
		boolean isZombieVm=controlCenterService.isZombieVm(vm);
		boolean valid = controlCenterService.isValidClientIp(clientIp);
		
		
		
		
		
		
		
		boolean result=getStatementType1(para);
		
		System.out.println("Check "+result);
		
		
		
		
		
		
		
		
		
		
		
		
		
		if(result==true)
		{
			
			
			 message="Xss Scripting Detected";
			 
			 
			 
			 
			//System.out.println(getStatementType(userName));
			
			/*String message1="";
			boolean isZombieVm1=controlCenterService.isZombieVm(vm);
			if(isZombieVm==true)
			{
				message="Selected Virtul Matchine "+vm+" infected by ZOMBIE Attack  Please select other ";
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/xssattack.jsp?message=" +message);
				//rd.forward(request, response);
			}
			
			
			else if(controlCenterService.isValidClientIpForXss(clientIp)==true)
				
			{

				

			if(getStatementType1(userName)==true)
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
			}*/
			 
			
			 
			 
			 
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/xssattack.jsp?message=" +message);
			rd.forward(request, response);
			
			
			
			
}
		
		
		
		
		
		
		
		else if(action.equals("userLogin"))
		{
//			String userName = request.getParameter("userName");
//			String password = request.getParameter("password");
//			String vm = request.getParameter("vm");
//			String clientIp = request.getParameter("clientIp");
			
		    //System.out.println("Client Ip :" +clientIp);
		    
		    System.out.println("VM= "+vm );
			//String message="";
			
			
			
			//UserService userService=new UserService();
			//ControlCenterService controlCenterService = new ControlCenterService();
			
			 
			boolean valid1= userService.isValidUser(userName, password);
			
			int loginAttempt=userService.getLoginAttempt(userName);
			
			boolean lockUser=userService.isLockedUser(userName);
			
			
		//controlCenterService.addvm(vm,VMStatusMode.VULNERABLE);//add from vikram  pasing (vm & status mode)
			
			
			boolean isZombieVm1=controlCenterService.isZombieVm(vm);
            
              

	
			
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
		          
		       
		}//end of user login else
		
		
		
	else if (action.equals("sqlInjection"))

     {
	
	
	
			if(isZombieVm==true)
			{
				message="Selected Virtul Matchine "+vm+" infected by ZOMBIE Attack  Please select other ";
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/sqlinjection.jsp?message=" +message);
				rd.forward(request, response);
			}
			
			
			else if(valid==true)
			{

				if (username.contains("delete") == true
					&& username.contains("from") == true) {
					message = "delete";
					controlCenterService.addSqlInjection(clientIp, message);
					
					//controlCenterService.getSqlAttackCount();
					
					controlCenterService.updateSql();
					
					controlCenterService.updateVMStatus(vm, VMStatusMode.EXPLOITED);
				}

				else if (username.contains("or") == true
					&& username.contains("=") == true) {
					message = "or";
					controlCenterService.addSqlInjection(clientIp, message);
					
					//controlCenterService.getSqlAttackCount();
					controlCenterService.updateSql();
					controlCenterService.updateVMStatus(vm, VMStatusMode.EXPLOITED);
				}

				else if (username.contains("select") == true
					&& username.contains("from") == true) {
					message = "select";
					controlCenterService.addSqlInjection(clientIp, message);
					//controlCenterService.getSqlAttackCount();
					controlCenterService.updateSql();
					controlCenterService.updateVMStatus(vm, VMStatusMode.EXPLOITED);
				
				}

				else if (username.contains("drop") == true
					&& username.contains("table") == true) {
					message = "drop";
					controlCenterService.addSqlInjection(clientIp, message);
					//controlCenterService.getSqlAttackCount();
					controlCenterService.updateSql();
					controlCenterService.updateVMStatus(vm, VMStatusMode.EXPLOITED);
				}

				else if (username.contains("insert") == true
					&& username.contains("table") == true) {
					message = "insert";
					controlCenterService.addSqlInjection(clientIp, message);
					//controlCenterService.getSqlAttackCount();
					controlCenterService.updateSql();
					controlCenterService.updateVMStatus(vm, VMStatusMode.EXPLOITED);
				}

				else if (username.contains("union") == true
					&& username.contains("select") == true) {
					message = "union";
					controlCenterService.addSqlInjection(clientIp, message);
					//controlCenterService.getSqlAttackCount();
					controlCenterService.updateSql();
					controlCenterService.updateVMStatus(vm, VMStatusMode.EXPLOITED);
				}

				else if (username.contains("update") == true
					&& username.contains("set") == true) {
					message = "update";
					controlCenterService.addSqlInjection(clientIp, message);
					//controlCenterService.getSqlAttackCount();
					controlCenterService.updateSql();
					controlCenterService.updateVMStatus(vm, VMStatusMode.EXPLOITED);
				}

				else if (username.contains("create") == true
					&& username.contains("table") == true) {
					message = "create";
					controlCenterService.addSqlInjection(clientIp, message);
					//controlCenterService.getSqlAttackCount();
					controlCenterService.updateSql();
					controlCenterService.updateVMStatus(vm, VMStatusMode.EXPLOITED);
				}

				else if (username.contains("admin") == true
					&& username.contains("drop") == true) {
					message = "admin";
					controlCenterService.addSqlInjection(clientIp, message);
					//controlCenterService.getSqlAttackCount();
					controlCenterService.updateSql();
					controlCenterService.updateVMStatus(vm, VMStatusMode.EXPLOITED);
			} else {
				message = "nothing";
			}
			
			
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/sqlinjection.jsp?message=" + message);
			rd.forward(request, response);
		}
			else
			{
				message=" IP Blocked due to  try of Sql Injection !!!!!!!!!!!!!!!";
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher(
						"/sqlinjection.jsp?message=" + message);
				rd.forward(request, response);
			}

			
			
}// End Of Action if statement

	else 
	{
		boolean valid1= userService.isValidUser(userName, password);
		
		int loginAttempt=userService.getLoginAttempt(userName);
		
		boolean lockUser=userService.isLockedUser(userName);
		boolean isZombieVm1=controlCenterService.isZombieVm(vm);
        
        

		
		
		System.out.println("Valid= " +valid1);
		System.out.println("loginAttempt= " +loginAttempt);
		System.out.println("loginAttempt= " +isZombieVm1);
		
		if(isZombieVm1==true)
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
		
		else if(valid1==true && loginAttempt <1)
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
		
		  else if(valid1==true && loginAttempt<=3)
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
		 
		    else if(valid1==true &&loginAttempt>3)
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
	
		
	}


//if(action.equals("xssattack"))
//{
	
	
	
	
/*	System.out.println(getStatementType(userName));
	
	String message1="";
	boolean isZombieVm1=controlCenterService.isZombieVm(vm);
	if(isZombieVm==true)
	{
		message="Selected Virtul Matchine "+vm+" infected by ZOMBIE Attack  Please select other ";
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/xssattack.jsp?message=" +message);
		rd.forward(request, response);
	}
	
	
	else if(controlCenterService.isValidClientIpForXss(clientIp)==true)
		
	{

		

	if(getStatementType1(userName)==true)
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
	}*/
	


/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */


	




public  boolean getStatementType1(String username)
{

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






	
	
	
















	
	public static String getStatementType(String username) {

		if (username.contains("delete") == true
				&& username.contains("from") == true) {
			return "delete";
		}

		else if (username.contains("or") == true
				&& username.contains("=") == true) {
			return "or";
		}

		else if (username.contains("select") == true
				&& username.contains("from") == true) {
			return "select";
		}

		else if (username.contains("drop") == true
				&& username.contains("table") == true) {
			return "drop";
		}

		else if (username.contains("insert") == true
				&& username.contains("table") == true) {
			return "insert";
		}

		else if (username.contains("union") == true
				&& username.contains("select") == true) {
			return "union";
		}

		else if (username.contains("update") == true
				&& username.contains("set") == true) {
			return "update";
		}

		else if (username.contains("create") == true
				&& username.contains("table") == true) {
			return "create";
		}

		else if (username.contains("admin") == true
				&& username.contains("drop") == true) {
			return "admin";
		} else {
			return null;
		}

	}

	public static int getscore(String word, String tofind1, String tofind2,int score)
	{

		if ((word.indexOf(tofind1) > -1) && word.indexOf(tofind2) > -1) 
		{
			System.out.println(word.indexOf("jjj" + tofind2));
			return (score);
		} else {
			return (0);
		}
	}

}
