package com.nice.mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.nice.mail.EmailSend1.SMTPAuthenticator;

/**
 * Servlet implementation class EmailSend1
 */
public class EmailSend1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailSend1() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
     protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

    	
    	
//    	PrintWriter out=response.getWriter();
//    	out.println("Hii iam from EmailSend1");
    	
    	
    	
		final String err = "/Error.jsp";
		final String succ = "/login.jsp";

		String from ="niceproject830@gmail.com";// request.getParameter("from");
		String to = request.getParameter("userEmail");
		String subject = "Your Password detail";//request.getParameter("subject");
		//String message = request.getParameter("message");
		/*String login = request.getParameter("login");
		String password = request.getParameter("password");*/
		
		MessageText msg1=new MessageText();
		
		String message=msg1.getMessage(to);
		String login="niceproject830@gmail.com";  //change according
		String password="niceproject";//change
		
		try {
			Properties props = new Properties();
			props.setProperty("mail.host", "smtp.gmail.com");//change accordingly
			props.setProperty("mail.smtp.port", "587"); //change port according
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.starttls.enable", "true");

			Authenticator auth = new SMTPAuthenticator(login, password);

			Session session = Session.getInstance(props, auth);

			MimeMessage msg = new MimeMessage(session);
			msg.setText(message);
			msg.setSubject(subject);
			msg.setFrom(new InternetAddress(from));
			
			
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(msg);
			

		} catch (AuthenticationFailedException ex) 
		{
			request.setAttribute("ErrorMessage", "Authentication failed");

			RequestDispatcher dispatcher = request.getRequestDispatcher(err);
			dispatcher.forward(request, response);

		} catch (AddressException ex) {
			request.setAttribute("ErrorMessage", "Wrong email address");

			RequestDispatcher dispatcher = request.getRequestDispatcher(err);
			dispatcher.forward(request, response);

		} catch (MessagingException ex) {
			request.setAttribute("ErrorMessage", ex.getMessage());

			RequestDispatcher dispatcher = request.getRequestDispatcher(err);
			dispatcher.forward(request, response);
		}
		
		message="Your password send to your registerd email id";
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp?message=" +message);
		rd.forward(request, response);

	}

	public class SMTPAuthenticator extends Authenticator {

		private PasswordAuthentication authentication;

		public SMTPAuthenticator(String login, String password)
{
			authentication = new PasswordAuthentication(login, password);
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return authentication;
		}
	}

	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		   processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}


	
    
    
    
    
    