package com.snapdeal.data;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flipkart.data.HttpURLConnectionExample;
import com.flipkart.data.ProductInfo;

/**
 * Servlet implementation class SnapdealController
 */
@WebServlet("/SnapdealController")
public class SnapdealController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SnapdealController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		HttpURLConnectionSnapdeal getData = new HttpURLConnectionSnapdeal();
		Map<Integer, ProductInfoSnapdeal> obj = null;
		try {
			obj = getData.sendGet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//iterating over values only
		
		request.setAttribute("productmapsnap", obj);
		// TODO Auto-generated method stub
		RequestDispatcher rd=request.getRequestDispatcher("/snapdeal.jsp");  
		//servlet2 is the url-pattern of the second servlet  
		  
		rd.forward(request, response);//method may be include or forward }

}}
