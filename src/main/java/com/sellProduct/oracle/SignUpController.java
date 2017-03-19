package com.sellProduct.oracle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet implementation class SignUpController
 */
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
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
		SessionFactory factory=new ConnectionProvider().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tr=session.beginTransaction();
		
		Users user=new Users();
		user.setFirstName(request.getParameter("firstname"));
		user.setSeller_id(Integer.parseInt(request.getParameter("mobile")));
		user.setLastName(request.getParameter("lastname"));
		user.setMobileNo(Integer.parseInt(request.getParameter("mobile")));
		user.setPassword(request.getParameter("password"));
		System.out.println(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setAddress(request.getParameter("address"));
		session.save(user);
		tr.commit();
		session.close();
		HttpSession httpsession = request.getSession();
		 httpsession.setAttribute("username", request.getParameter("firstname"));
		RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");  
		//servlet2 is the url-pattern of the second servlet  
		  
		rd.forward(request, response);
	}

}
