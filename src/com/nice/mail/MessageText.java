package com.nice.mail;


//import com.mail.service.ConnectionProvider;
import java.sql.*;

import com.nice.service.ConnectionProvider;
public class MessageText {

	
	 private Connection conn;
	public MessageText()
	{
		 conn = ConnectionProvider.getConnection();
		 System.out.println("In Service connnection is "+ConnectionProvider.getConnection());
	}
	

	public  String  getMessage(String email)
	{ 
		
		String result=getEmailId(email);
		
		
		return result;
	}
	
	public  String getEmailId(String email)
	{
		boolean status=false;
		String tempPass="";
		 String sql = "select  userEmail,password from userinfo WHERE userEmail= ?";
         
		 PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			 ps.setString(1, email);
			 ResultSet rs=ps.executeQuery();
			 status=rs.next();
			 if(status==true)
			 {
				 tempPass=rs.getString(2);
			 }
			 System.out.println(tempPass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            
            return tempPass;
            
           
	}
}
