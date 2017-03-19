package com.smartshop.cart;

import java.util.ArrayList;

public class CartBean {
	private ArrayList alCartItems = new ArrayList();
	private double dblOrderTotal;
	
	public int getLineItemCount() {
		return alCartItems.size();
	}

	public void deleteCartItem(String strItemIndex) {
		int iItemIndex = 0;
		
		try {
			iItemIndex = Integer.parseInt(strItemIndex);
			alCartItems.remove(iItemIndex );
			//calculateOrderTotal();
		} catch (NumberFormatException nfe) {
			System.out.println("Error while deleting cart item: " + nfe.getMessage());
			nfe.printStackTrace();
		}
	}

	public void updateCartItem(String strItemIndex, String strQuantity) {
		double dblTotalCost = 0.0;
		double dblUnitCost = 0.0;
		int iQuantity = 0;
		int iItemIndex = 0;
		CartItemBean cartItem = null;
		try {
			iItemIndex = Integer.parseInt(strItemIndex);
			iQuantity = Integer.parseInt(strQuantity);
			if (iQuantity > 0) {
				cartItem = (CartItemBean) alCartItems.get(iItemIndex - 1);
				//dblUnitCost = cartItem.getUnitCost();
				dblTotalCost = dblUnitCost * iQuantity;
				//cartItem.setQuantity(iQuantity);
				//cartItem.setTotalCost(dblTotalCost);
				//calculateOrderTotal();
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Error while updating cart: " + nfe.getMessage());
			nfe.printStackTrace();
		}

	}

	public void addCartItem(String title, String description, String availability, String productUrl, String imgUrl,String siteName) {
		
		
		
		
		double dblTotalCost = 0.0;
		// double dblUnitCost = 0.0;
		int iQuantity = 0;
		CartItemBean cartItem = new CartItemBean();
		try {
			// dblUnitCost = Double.parseDouble(strUnitCost);
			// iQuantity = Integer.parseInt(strQuantity);
			// if(iQuantity>0) {
			// dblTotalCost = dblUnitCost*iQuantity;
			cartItem.setTitle(title);
			cartItem.setModelDescription(description);
			cartItem.setAvailability(availability);
			cartItem.setImgUrl(imgUrl);
			cartItem.setProductUrl(productUrl);
			cartItem.setSiteName(siteName);
			System.out.println("zingat-------"+siteName);
			// cartItem.setUnitCost(dblUnitCost);
			// cartItem.setQuantity(iQuantity);
			// cartItem.setTotalCost(dblTotalCost);
			alCartItems.add(cartItem);
			
			CartItemBean bb=(CartItemBean)alCartItems.get(0);
			 
			  /* System.out.println(description);
			   System.out.println(availability);
			   System.out.println(productUrl);
			   System.out.println(imgUrl);*/
			
			//calculateOrderTotal();
			// }

		} catch (NumberFormatException nfe) {
			System.out.println("Error while parsing from String to primitive types: " + nfe.getMessage());
			nfe.printStackTrace();
		}
	}

	public void addCartItem(CartItemBean cartItem) {
		alCartItems.add(cartItem);
	}

	public CartItemBean getCartItem(int iItemIndex) {
		CartItemBean cartItem = null;
		if (alCartItems.size() > iItemIndex) {
			cartItem = (CartItemBean) alCartItems.get(iItemIndex);
		}
		return cartItem;
	}

	public ArrayList getCartItems() {
		return alCartItems;
	}

	public int getCartItemsCount() {
		return alCartItems.size();
	}

	public void setCartItems(ArrayList alCartItems) {
		this.alCartItems = alCartItems;
	}

	public double getOrderTotal() {
		return dblOrderTotal;
	}

	public void setOrderTotal(double dblOrderTotal) {
		this.dblOrderTotal = dblOrderTotal;
	}

	/*protected void calculateOrderTotal() {
		double dblTotal = 0;
		for (int counter = 0; counter < alCartItems.size(); counter++) {
			CartItemBean cartItem = (CartItemBean) alCartItems.get(counter);
			dblTotal += cartItem.getTotalCost();

		}
		setOrderTotal(dblTotal);
	}*/

}