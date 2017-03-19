package com.sellProduct.oracle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		// TODO Auto-generated method stub
		String username=request.getParameter("email_mobile");
		String password=request.getParameter("pwd");
		   
				SessionFactory factory=new ConnectionProvider().buildSessionFactory();
				Session session=factory.openSession();
				session.beginTransaction();
				Criteria cr = session.createCriteria(Users.class);
				List<Users> results = cr.list();
				if((results.get(0).getEmail().equals(username))
						&&results.get(0).getPassword().equals(password)){
					 HttpSession httpsession = request.getSession();
					 httpsession.setAttribute("username", username);
					
				}
				RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");  
				//servlet2 is the url-pattern of the second servlet  
				  
				rd.forward(request, response);
		
	}

}
