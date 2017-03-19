package com.flipkart.data;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FlipkartController
 */
public class FlipkartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlipkartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpURLConnectionExample getData = new HttpURLConnectionExample();
		Map<Integer, ProductInfo> obj = null;
		try {
			obj = getData.sendGet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//iterating over values only
		
		request.setAttribute("productmap", obj);
		// TODO Auto-generated method stub
		RequestDispatcher rd=request.getRequestDispatcher("/dotd.jsp");  
		//servlet2 is the url-pattern of the second servlet  
		  
		rd.forward(request, response);//method may be include or forward  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
