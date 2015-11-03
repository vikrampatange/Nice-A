package com.nice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.fpwd.common.SendMail;
//import com.fpwd.util.Utility;
//import com.nice.util.*;



public class UserService {

	 private Connection conn;

	 public UserService()
	 {
		 conn = ConnectionProvider.getConnection();
		 System.out.println("In Service connnection is "+ConnectionProvider.getConnection());

	 }
	 
	 /**
	  * 
	  * 
	  * Save <b>User</b> in database <br> 
	  * 
	  * @param String userName
	  * @param String password
	  * @param String userEmail
	  * @param String userMobile
	  * 
	  * @return void 
	  * 
	  * */
	 /*##############################Save User Details to  Database###################################*/ 
	 public void addUser(String userName,String password,String userEmail,String userMobile,String secQues ,String answer  ) {
	        try {
	        	SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
	        	Date d=new Date();
	        	String st=format.format(d);
	        	String sql = "INSERT INTO userinfo(userName, password,userEmail,userMobile,secQues,answer,lockstatus,lastacess) VALUES (?,?,?,?,?,?,?,?)";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            
	            ps.setString(1, userName);
	            ps.setString(2, password);
	          	ps.setString(3, userEmail);
	            ps.setString(4, userMobile);
	            ps.setString(5, secQues);
	            ps.setString(6, answer);
	            ps.setString(7, "no");
	            ps.setString(8, st);
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	 /*###########################################################################################*/ 

	 
	 /**
	  * @param String userName 
	  * @param String password
	  * 
	  * @return boolean false or true 
	  * */
	  
	 /*###########################################################################################*/ 
	 public boolean isValidUser(String userName,String password)  
		{
			System.out.println("In User valid Check");
			boolean valid=false;
			 try {
				 String sql = "select  count(*) from userinfo WHERE userName= ? and password=?";
		            
				 PreparedStatement ps = conn.prepareStatement(sql);
		            
		            
		            
		            ps.setString(1, userName);
		            ps.setString(2, password);
		            
		            ResultSet rs = ps.executeQuery();
		            //valid= rs.next();
		            if(rs.next())
		            {
		            	
		            	final int count=rs.getInt(1);
		            	
		            	System.out.println("count" +count);
		            	
		            	if(count>0){
		            		
		            		valid=true;
		            	}
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			
			return valid;
		}
	 /*#######################################################################################################*/
	 
	 /**
	  * Tracking Login attempt by user
	  * @param String userName
	  * @return void 
	  * 
	  * */
	 
	 /*############################## Track login attempt By user###################################*/ 
	 public void addLoginAttempt(String userName ) {
	        try {
	        	String sql = "INSERT INTO loginattempt (userName,loginattempt) VALUES (?,?)";
	        	//String sql = "INSERT INTO loginattempt (userName, loginattempt) VALUES (?,?)";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            
	            ps.setString(1, userName);
	            ps.setInt(2, 0);
	          
	           
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	 /*###########################################################################################*/ 

	 
	 
	 
	 
	 
	 /**
	  * Tracking Login attempt by user
	  * @param String userName
	  * @return int loging attempt 
	  * 
	  * */
	 
	 
	 /*######################################################################################*/ 
	 public int getLoginAttempt(String userName)  
		{
			System.out.println("In login attenpt service Check");
			int count=0;
			 try {
				 String sql = "select  loginattempt from loginattempt WHERE userName= ?";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            
		            ps.setString(1,userName);
		           
		            
		            ResultSet rs = ps.executeQuery();
		            //valid= rs.next();
		            if(rs.next())
		            {
		            	
		                count=rs.getInt(1);
		            	System.out.println("count" +count);
		            	
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			
			return count;
		}
	 /*#######################################################################################################*/
	 
	 
	 /**
	  * Method for update login attempt 
	  * 
	  * @param  String  userName 
	  * @param  String  loginAttempt 
	  * 
	  * @return void
	  * 
	  * **/
	 
	 /*######################################################################################*/ 
	 public void  updateLoginAttempt(String userName ,int loginAttempt)  
		{
		
			 try {
				 String sql = "update   loginattempt set loginattempt= ? WHERE userName= ?";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            
		             ps.setInt(1, loginAttempt);
		             ps.setString(2, userName);
		           
		             ps.executeUpdate();

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			
			
		}
	 /*#######################################################################################################*/
	 
	 
	 
	 
	 /**
	  * Method for check user after 3 or more than 3 login attempt to check user 
	  * by providing Security Question  
	  * @param  String  userName 
	  * @param String  loginAttempt 
	  * @param String secQues
	  * @param String answer
	  * @return boolean {@value =true| false } 
	  * 
	  * **/
	 
	 /*##############################User Login########################################################*/ 
	 public boolean isValidUserByQuestion(String userName,String secQues,String answer)  
		{
			System.out.println("In Check Question ");
			boolean valid=false;
			 try {
				 String sql = "select  count(*) from userinfo WHERE userName= ? and secQues=? and answer=? ";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            
		            ps.setString(1, userName);
		            ps.setString(2, secQues);
		            ps.setString(3, answer);
		            
		            ResultSet rs = ps.executeQuery();
		            //valid= rs.next();
		            if(rs.next())
		            {
		            	
		            	final int count=rs.getInt(1);
		            	System.out.println("count" +count);
		            	if(count>0){
		            		
		            		valid=true;
		            	}
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			
			return valid;
		}
	 /*#######################################################################################################*/
	 
	 
	 
	 /**
	  * Method for check user is lock or not  
	  * by providing Security Question  
	  * @param  String  userName 
	  * 
	  * @return boolean {@value =true| false } 
	  * 
	  * **/
	 

	 /*##############################User Login########################################################*/ 
	 public boolean isLockedUser(String userName)  
		{
			System.out.println("In Check User Lock ");
			boolean valid=false;
			 try {
				 String sql = "select  lockstatus from userinfo WHERE userName= ?  ";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            
		            ps.setString(1, userName);
		           
		            
		            ResultSet rs = ps.executeQuery();
		            //valid= rs.next();
		            if(rs.next())
		            {
		            	
		            	//final int count=rs.getInt(1);
		            	String lockstatus= rs.getString(1);
		            	
		            	System.out.println("count lockstatus" +lockstatus);
		            	if(lockstatus.equals("yes")){
		            		
		            		valid=true;
		            	}
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			
			return valid;
		}
	 
	 

	 /*#######################################################################################################*/ 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
		 
	




	
	
	 /*#######################################################################################################*/
	 
	 
	 
	 /**
	  * Method for lock user after wrong Security Question  answer 
	  * @param  String  userName 
	  * 
	  * @return void 
	  * 
	  * **/
	 
	 
	 /*######################################################################################*/ 
	 public void  lockUser(String userName)  
		{
		
			 try { 
				 String sql = "update   userinfo set lockstatus= ?,lastacess=? WHERE userName= ?";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		           
		             ps.setString(1, "yes");
		             ps.setTimestamp(2, date);
		             ps.setString(3, userName);
		           
		             ps.executeUpdate();

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		}
			
			
		
	 /*#######################################################################################################*/

	 
	 
	 
	 
	 
	 
	 
	 /*#######################################################################################################*/

	 
//	public Map<String, String> insertData(String emailId)
//	{
//		
//		
//       System.out.println( "this is from insert data method body:"+ emailId);  
//		
//		
//		
//		HashMap<String, String> dataMap = new HashMap<String, String>();
//		
//		
//		try {
//			
//			ResultSet rset;
//
//			String token = Utility.getInstance().generateRandomToken();
//			
//			//System.out.println("Iam from FPDao:"+token);
//			
//			
//			
//			String sql = "select * from userinfo WHERE userEmail= ?  ";
//			
//            PreparedStatement ps = conn.prepareStatement(sql);
//            
//            
//             ps.setString(1, emailId);
//            
//            
//            ResultSet rs = ps.executeQuery();
//            
//            
//            
//            
//			 if(rs.next())
//				
//			{
//				
//				
//				int updatecount = ps.executeUpdate("update Forgetpasslinktab set Fp_token='" + token + "',status='REQ',Fp_accessedtime='" + Utility.getInstance().getDate() + "' where Fp_email='" + emailId + "'");
//				
//				
//
//				System.out.println("This is after update:"+emailId);
//				
//				
//				
//				
//				
//
//				
//				
//				
//				
//				
//			
//				
//				
//				if (updatecount >= 1) 
//				{
//					
//					mail = new SendMail();
//					
//					Boolean b = mail.sendMail(emailId,null,"New Password for Account",Utility.getInstance().frameResetLink(token,forgetpasswordlink, emailId), null);
//					
//					if (b) 
//					{
//						dataMap.put("RESULT", "SUCCESS");
//						dataMap.put("REASON","Your password reset link is send to your registred Email id");
//					} 
//					else 
//					{
//						dataMap.put("RESULT", "FAILURE");
//						dataMap.put("REASON","Problem in resetting the password. Please try after sometime");
//					}
//				} 
//				else
//				{
//					dataMap.put("RESULT", "FAILURE");
//					dataMap.put("REASON", "Unable to update in DataBase");
//				}
//			}
//			else
//			{
//				dataMap.put("RESULT", "FAILURE");
//				dataMap.put("REASON", "Email ID does not exist");
//			}
//
//		} 
//		catch (Exception e) 
//		{
//			dataMap.put("RESULT", "EXCEPTION");
//			dataMap.put("REASON", e.getMessage());
//		} finally {
//			con.close();
//		}
//
//		return dataMap;
//	 
//	 
//	 
//}//insert block
	
	
	
	
	
	
}
	
	 /*#######################################################################################################*/

