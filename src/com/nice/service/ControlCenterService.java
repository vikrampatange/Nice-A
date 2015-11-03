package com.nice.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nice.util.VMStatusMode;

public class ControlCenterService {
	
	 private Connection conn;
	
	public  ControlCenterService()
	{
		 conn = ConnectionProvider.getConnection();
		// System.out.println("In ControlCenterService "+ConnectionProvider.getConnection());
	}
	
	
	 
	 /*######################################################################################*/
	
	
	
	
	
	
	
	

	
	 
	 
	 public String addvm(String vm,String status) {                        //add changes from vikram
		 
		 try {
			 String sql = "INSERT INTO vmstatus (vm, status) VALUES (?,?)";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, vm );
	             ps.setString(2, status);
	             
	           
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return vm ;
	    }
		 
		 
		 
	/*######################################################################################*/
		 
		 
	                     
	 public void  updateVMStatus(String vm , String status  )  
		{
		
			 try {
				  String sql = "update vmstatus set status= ? WHERE vm= ?";
		            PreparedStatement ps = conn.prepareStatement(sql);
		             ps.setString(1, status );
		             ps.setString(2, vm);
		             
		           
		             ps.executeUpdate();
		            
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			
			
		}
	 /*#######################################################################################################*/
	 
	 
	 public List<VMachine> getAllVMachine() {
	        List<VMachine> vMachineList = new ArrayList<VMachine>();
	        try {
	        	 String sql = "select * from vmstatus";
	        	 PreparedStatement ps = conn.prepareStatement(sql);
	        	 ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	VMachine vMachine = new VMachine();
	            	vMachine.setId(rs.getInt("id"));
	            	vMachine.setVm(rs.getString("vm"));
	            	vMachine.setStatus(rs.getString("status"));
	                
	             
	            	vMachineList.add(vMachine);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 
	        return vMachineList;
	    }
	 
	 
	 
	 
	 public List<String> getAllLockedUsers() {
	        List<String> users = new ArrayList<String>();
	        try {
	                String sql = "SELECT distinct userName  FROM userinfo where lockstatus='yes'";
	                
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                                       
	                users.add(rs.getString("userName"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return users;
	    } 
	 
	 
	 
	 /*######################################################################################*/ 
	
	 public boolean isZombieVm(String vm)  
		{
			System.out.println("In VM Status check   ");
			boolean valid=false;
			 try {
				 String sql = "select  status from vmstatus WHERE vm= ? ";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            
		            ps.setString(1, vm);
		           
		            
		            ResultSet rs = ps.executeQuery();
		            //valid= rs.next();
		            if(rs.next())
		            {
		            	
		            	//final int count=rs.getInt(1);
		            	String status= rs.getString(1);
		            	
		            	System.out.println("status" +status);
		            	
		            	if(status.equals(VMStatusMode.ZOMBIE)){
		            		
		            		valid=true;
		            	}
		            	
		            }

		        } catch (SQLException e) {
		        	
		            e.printStackTrace();
		        }
			
			return valid;
		}
	 /*##################################################################################*/
	 
	 
	 
	 
	 
	 /*######################################################################################*/ 
	 public boolean isExploited(String vm)  
		{
			System.out.println("In VM Status check   ");
			boolean valid=false;
			 try {
				 String sql = "select  status from vmstatus WHERE vm= ?  ";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            
		            ps.setString(1, vm);
		           
		            
		            ResultSet rs = ps.executeQuery();
		            //valid= rs.next();
		            if(rs.next())
		            {
		            	
		            	//final int count=rs.getInt(1);
		            	String status= rs.getString(1);
		            	//System.out.println("status" +status);
		            	System.out.println("iam from Vm status checking status" +status);
		            	if(status.equals(VMStatusMode.EXPLOITED)){
		            		
		            		valid=true;
		            		
		            		
		            	}
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			
			return valid;
		}
	 /*##################################################################################*/
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public boolean isValidClientIp(String clientIp)  
		{
		
			boolean valid=false;
			 try {
				 String sql = "select  count(*) from SQLInjection WHERE clientIp= ? ";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            
		            ps.setString(1, clientIp);
		           
		            
		            ResultSet rs = ps.executeQuery();
		            //valid= rs.next();
		            if(rs.next())
		            {
		            	
		            	final int count=rs.getInt(1);
		            	System.out.println("this count from sqlinjection count" +count);
		            	if(count==0){
		            		
		            		valid=true;
		            	}
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			
			return valid;
		}
	 
	 /*##################################################################################*/	 
	 public void addSqlInjection(String clientIp,String attackType  ) {
	        try {
	        	String sql = "INSERT INTO SQLInjection(clientIp, attackType) VALUES (?,?)";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            
	            ps.setString(1, clientIp);
	            ps.setString(2, attackType);
	          
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 /*#################################################################################*/ 
	 
	 public void deleteSqlInjection(String clientIp  ) {
	        try {
	        	String sql = "DELETE FROM  SQLInjection WHERE clientIp=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            
	            ps.setString(1, clientIp);
	           
	          
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 /*#######################################################################################################*/ 
	 
	 
	 public List<SQLInj> getAllVSqlAttack() {
	        List<SQLInj> sQLInjList = new ArrayList<SQLInj>();
	        try {
	        	 String sql = "select * from sqlinjection";
	        	 PreparedStatement ps = conn.prepareStatement(sql);
	        	 ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	SQLInj sQLInj = new SQLInj();
	            	sQLInj.setClientIp((rs.getString("clientIp")));
	            	sQLInj.setAttackType((rs.getString("attackType")));
	                
	             
	            	sQLInjList.add(sQLInj);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 
	        return sQLInjList;
	    }
	 
	 /*#################################################################################*/
	 
	 public void addXssAtack(String clientIp  ) {
	        try {
	        	String sql = "INSERT INTO XssAtack(clientIp) VALUES (?)";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            
	            ps.setString(1, clientIp);
	          
	          
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 /*###################################################################################*/ 
	 
	 public boolean isValidClientIpForXss(String clientIp)  
		{
		
			boolean valid=false;
			 try {
				 String sql = "select  count(*) from XssAtack WHERE clientIp= ? ";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            
		            ps.setString(1, clientIp);
		           
		            
		            ResultSet rs = ps.executeQuery();
		            //valid= rs.next();
		            if(rs.next())
		            {
		            	
		            	final int count=rs.getInt(1);
		            	System.out.println("count" +count);
		            	if(count==0){
		            		
		            		valid=true;
		            	}
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			
			return valid;
		}
	 /*################################################################################*/ 
	 
	 
	 public List<String> getAllXssAtackIp() {
	        List<String> clientIpList = new ArrayList<String>();
	        try {
	                String sql = "SELECT distinct clientIp  FROM xssatack";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                                       
	            	clientIpList.add(rs.getString("clientIp"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return clientIpList;
	    } 
	 
	 /*###############################################################################*/ 
	 
	 public void deleteXssAtackIp(String clientIp  ) {
	        try {
	        	String sql = "DELETE FROM  xssatack WHERE clientIp=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            
	            ps.setString(1, clientIp);
	           
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
   /*####################################################################################*/ 
	 
	 public int getLoginAttackCount()
	   {
		 int count=0;
		 try {
             String sql = "SELECT acCount  FROM attackcount where attackType=?";
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, "loginattack");
              ResultSet rs = ps.executeQuery();
         while (rs.next()) {
                                    
        	 count= rs.getInt(1);
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
		return count ; 
	   }
	
 /*#####################################################################################*/ 
			 
	 public void  updateLoginAttackCount()
	   {
		  int count=getLoginAttackCount()+1;
		 try {
           String sql = "update attackcount SET acCount =? where attackType=? ";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setInt(1,count);
           ps.setString(2, "loginattack");
           ps.executeUpdate();
         } catch (SQLException e) {
        	 e.printStackTrace();
          }
		
	   }
/*#####################################################################################*/ 
	 
	 	 
	 
	 
/*####################################################################################*/ 
	 
	 public int getSqlAttackCount()
	   {
		 int count=0;
		 try {
             String sql = "SELECT acCount  FROM attackcount where attackType=?";
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, "sqlattack");
              ResultSet rs = ps.executeQuery();
         while (rs.next()) {
                                    
        	 count= rs.getInt(1);
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
		return count ; 
	   }
	
 /*#####################################################################################*/ 
			 
	 public void  updateSql()
	   {
		  int count=getSqlAttackCount()+1;
		 try {
           String sql = "update attackcount SET acCount =? where attackType=? ";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setInt(1,count);
           ps.setString(2, "sqlattack");
           ps.executeUpdate();
         } catch (SQLException e) {
        	 e.printStackTrace();
          }
		
		 	 
}
	 

/*#####################################################################################*/ 


/*####################################################################################*/ 

public int getScriptAttackCount()
  {
	 int count=0;
	 try {
        String sql = "SELECT acCount  FROM attackcount where attackType=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "scriptattack");
         ResultSet rs = ps.executeQuery();
    while (rs.next()) {
                               
   	 count= rs.getInt(1);
    }
} catch (SQLException e) {
    e.printStackTrace();
}
	return count ; 
  }

/*#####################################################################################*/ 
		 
public void  updateScriptAttackCount()
  {
	  int count=getScriptAttackCount()+1;
	 try {
      String sql = "update attackcount SET acCount =? where attackType=? ";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1,count);
      ps.setString(2, "scriptattack");
      ps.executeUpdate();
    } catch (SQLException e) {
   	 e.printStackTrace();
     }
	
  }
/*#####################################################################################*/ 




public boolean isOneOfTheZombie()  
{

	boolean valid=false;
	 try {
		 String sql = "select  count(*) from vmstatus WHERE status= ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, VMStatusMode.ZOMBIE);
           
            
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






/*#####################################################################################*/ 




public boolean isOneOfTheExploited()  
{

	boolean valid=false;
	 try {
		 String sql = "select  count(*) from vmstatus WHERE status= ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, VMStatusMode.EXPLOITED);
           
            
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


/*#####################################################################################*/ 


public void  resetAll()
{
	 String resetallproc = "{ call resetallproc() }";
	 try {
		 CallableStatement cs = conn.prepareCall(resetallproc);
		 cs.execute();
  } catch (SQLException e) {
 	 e.printStackTrace();
   }
	
}
/*#####################################################################################*/ 
}