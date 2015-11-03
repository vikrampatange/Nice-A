//package com.nice.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.nice.service.ControlCenterService;
//import com.nice.service.UserService;
//
///**
// * Servlet implementation class SendResetLink1
// */
//public class SendResetLink1 extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	
//	
//	    private UserService userService;
//	 	private ControlCenterService controlCenterService ;
//	
//	
//	public SendResetLink1() throws Exception 
//    {
//		
//	        
//	          userService=new UserService();
//	          controlCenterService = new ControlCenterService();
//	        
//        
//    }
//	
//	
//	
//	
//	
//
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		
//   try {
//			
//			
//			
//			               PrintWriter out = response.getWriter();
//			   
//			               String useremail = request.getParameter("cus_email");
//			
//			               System.out.println(useremail);
//			
//			
//			
//			          
//			
//		  
//			           Map<String, String> data = userService.insertData(useremail);  //passing mail from here
//			  
//			  
//			
//			
//		 	if (data.get("RESULT").toString().equalsIgnoreCase("SUCCESS")) 
//			{
//				
//				out.println("<html><head/><body><center><div style='color: #4F8A10;background-color: #DFF2BF;'><b>" + data.get("REASON").toString() + "</b></div></center></body></html>");
//				
//				
//			}
//			
//			
//           else
//        	   if (data.get("RESULT").toString().equalsIgnoreCase("FAILURE"))
//				
//			   {
//        		   
//        		   
//				out.println("<html><head/><body><center><div style='color: #D8000C;background-color: #FFBABA;'><b>" + data.get("REASON").toString() + "</b></div></center></body></html>");
//				
//			  }
//			  else
//				if (data.get("RESULT").toString().equalsIgnoreCase("EXCEPTION")) 
//				{
//					
//				out.println("<html><head/><body><center><div style='color: #D8000C;background-color: #FFBABA;'><b>Internal Exception Occured! Please try Later<br/>Reason:-" + data.get("REASON").toString() + "</b></div></center></body></html>");
//			    }
//
//		}
//		catch (Exception e) 
//		{
//			response.getWriter().println("<html><head/><body><center><div style='color: #D8000C;background-color: #FFBABA;'><b>Internal Exception Occured! Please try Later<br/>Reason:-" + e.getMessage() + "</b></div></center></body></html>");
//		}
//
//	}
//
//}
