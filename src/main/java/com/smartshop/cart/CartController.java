package com.smartshop.cart;

 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
public class CartController extends HttpServlet {
  
 //public static final String addToCart
  
 public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
	 
 
  String strAction = request.getParameter("action");
  System.out.println(strAction);
   System.out.println(strAction!=null && !strAction.equals(""));
  if(strAction!=null && !strAction.equals("")) {
	 
   if(strAction.equals("add")) {
	   
    addToCart(request);
   } else if (strAction.equals("Update")) {
    updateCart(request);
   } else if (strAction.equals("Delete")) {
	   System.out.println("in delte");
    deleteCart(request);
   }else if (strAction.equals("addToCart")) {
	   addToCartNotify(request);
	   }
  }
  //-->response.sendRedirect(request.getContextPath()+"/login.jsp");
	//or
	//response.sendRedirect("../login.jsp");
 response.getWriter().print(new CartBean().getCartItemsCount());
 }
  
 protected void addToCartNotify(HttpServletRequest request) {
	 
	 HttpSession session = request.getSession();
	  String strItemIndex = request.getParameter("itemIndex");
	  
	  CartBean cartBean = null;
	   
	  Object objCartBean = session.getAttribute("cart");
	  if(objCartBean!=null) {
	   cartBean = (CartBean) objCartBean ;
	  } else {
	   cartBean = new CartBean();
	  }
	  
 }
 
 protected void deleteCart(HttpServletRequest request) {
  HttpSession session = request.getSession();
  String strItemIndex = request.getParameter("itemIndex");
  System.out.println(strItemIndex);
  CartBean cartBean = null;
   
  Object objCartBean = session.getAttribute("cart");
  if(objCartBean!=null) {
   cartBean = (CartBean) objCartBean ;
  } else {
   cartBean = new CartBean();
  }
  cartBean.deleteCartItem(strItemIndex);
 }
  
 protected void updateCart(HttpServletRequest request) {
  HttpSession session = request.getSession();
  String strQuantity = request.getParameter("quantity");
  String strItemIndex = request.getParameter("itemIndex");
  
  CartBean cartBean = null;
   
  Object objCartBean = session.getAttribute("cart");
  if(objCartBean!=null) {
   cartBean = (CartBean) objCartBean ;
  } else {
   cartBean = new CartBean();
  }
  cartBean.updateCartItem(strItemIndex, strQuantity);
 }
  
 protected void addToCart(HttpServletRequest request) {
  HttpSession session = request.getSession();
  String title = request.getParameter("title");
  String description = request.getParameter("description");
String availability = request.getParameter("availability");
String productUrl = request.getParameter("productUrl");
String imageUrl = request.getParameter("imageUrl");
String siteName=request.getParameter("siteName");
  //String strPrice = request.getParameter("price");
  //String strQuantity = request.getParameter("quantity");
  
  CartBean cartBean = null;
   
  Object objCartBean = session.getAttribute("cart");
 
  if(objCartBean!=null) {
   cartBean = (CartBean) objCartBean ;
  } else {
   cartBean = new CartBean();
   session.setAttribute("cart", cartBean);
  }
   
  cartBean.addCartItem(title, description, availability, productUrl,imageUrl,siteName);
 }
 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
