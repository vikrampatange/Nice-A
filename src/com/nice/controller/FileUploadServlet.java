package com.nice.controller;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



/*
 * Admin file upload Servlet 
 * 
 * */

public class FileUploadServlet extends HttpServlet {
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		    /* HttpSession session=request.getSession();
		     String userName=(String )session.getAttribute("userName");*/
		  
	        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	 
	        if (isMultipart) {
	        	// Create a factory for disk-based file items
	        	FileItemFactory factory = new DiskFileItemFactory();
              
	        	// Create a new file upload handler
	        	ServletFileUpload upload = new ServletFileUpload(factory);
	        	String uploadpath="c:/nice/uploads";
	        	File path = new File(uploadpath);
	        	 String fileName = "";
	            try {
	            	// Parse the request
	            	/* FileItem */
	            	List  items = upload.parseRequest(request);
	                Iterator iterator = items.iterator();
	                while (iterator.hasNext()) {
	                    FileItem item = (FileItem) iterator.next();
	                    if (!item.isFormField()) {
	                        fileName = item.getName();	 
	                      //  String root = getServletContext().getRealPath("/");
	                       // File path = new File(root + "/uploads");
	                        //File path = new File("c:/uploads");
	                        if (!path.exists()) {
	                        	
	                            boolean status = path.mkdirs();
	                            System.out.println("Status  " +status);
	                            
	                        }
	 
	                        File uploadedFile = new File(path + "/" + fileName);
	                       
	                        System.out.println(uploadedFile.getAbsolutePath());
	                        item.write(uploadedFile);
	                        
	                        
	                        
	                        
	                    }
	                }
	                
	               
	              
	       
	            } catch (FileUploadException e) {
	                e.printStackTrace();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	       
	        }
	        
	        
	        String message="Image uploaded Sucessfully";
	        RequestDispatcher rd = getServletContext().getRequestDispatcher("/fileupload.jsp?message=" +message);
	        rd.forward(request, response);
	    }
	 
	
  
    
		

}