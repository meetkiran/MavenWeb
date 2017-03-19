package com.sellProduct.oracle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
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
		SessionFactory factory=new ConnectionProvider().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tr=session.beginTransaction();
		
		ProductBean prodBean=new ProductBean();
		prodBean.setPhoto_name("photo");
		prodBean.setPrice(111);
		prodBean.setProd_age("22");
		prodBean.setProd_id("p101");
		
		Seller seller=(Seller)session.get(Seller.class, "1001");
		prodBean.setSellerId(seller);
		System.out.println(seller.getFirstname());
		session.save(prodBean)
;
		tr.commit();
		session.close();
		
	}

}
