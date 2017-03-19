package com.snapdeal.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class Category_mobileController
 */
@WebServlet("/Category_mobileController")
public class Category_mobileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Category_mobileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SortJSON getData = new SortJSON();
		try {
			Map<Integer, MobileBean> obj =null;//= getData.sendData();
			
			request.setAttribute("mobileDataSnapdeal", obj);
			// TODO Auto-generated method stub
			RequestDispatcher rd=request.getRequestDispatcher("/test.jsp");  
			//servlet2 is the url-pattern of the second servlet  
			  
			rd.forward(request, response);//method may be include or forward }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
