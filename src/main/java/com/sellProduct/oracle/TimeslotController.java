package com.sellProduct.oracle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/**
 * Servlet implementation class TimeslotController
 */
@WebServlet("/TimeslotController")
public class TimeslotController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeslotController() {
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
		System.out.println(request.getParameter("test"));
		Timeslot obj=new Timeslot();
		obj.setBooking_id("1");
		ProductBean prodBean=(ProductBean) session.get(ProductBean.class, "101");
		obj.setProd_id(prodBean);
		Seller sellerBean=(Seller)session.get(Seller.class, "1001");
		
		prodBean.setSellerId(sellerBean);
		Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now()+" 11:00:00AM");
			obj.setBooking_date(date1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
		
		/*SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date today = dateFormat.parse(dateFormat.format(new Date()));
			System.out.println("------"+LocalDate.now());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		session.save(obj);
		tr.commit();
		
		session.close();
	}

}
