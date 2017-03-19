package com.sellProduct.oracle;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FeedbackController
 */
@WebServlet("/FeedbackController")
public class FeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String to ="kiran.birajdar@atos.net";// request.getParameter("email");//change accordingly  
	    String from = "kiran.birajdar@atos.net";//change accordingly  
	    from=request.getParameter("from");
	    String subject=request.getParameter("subject");
	    
	    		
	    
	    String host = "mail1-int.my-it-solutions.net";//or IP address  

	   //Get the session object  
	    Properties properties = System.getProperties();  
	    properties.setProperty("mail.smtp.host", host);  
	    Session session1 = Session.getDefaultInstance(properties);  

	   //compose the message  
	    try{  
	       MimeMessage message = new MimeMessage(session1);  
	       message.setFrom(new InternetAddress(from));  
	       message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
	       message.setSubject(subject);  
	       message.setContent(request.getParameter("message"), "text/html");  

	       // Send message  
	       Transport.send(message);  
	       System.out.println("message sent successfully....");  

	    }catch (MessagingException mex) {mex.printStackTrace();}
		
	}

}
