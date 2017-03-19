package com.smartshop.cart;
 
public class CartItemBean {
    private String strPartNumber;
    private String strModelDescription;
    private double dblUnitCost;
    private int iQuantity;
    //private double dblTotalCost;
    private String imgUrl,title,availability,productUrl,siteName;
    public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getProductUrl() {
		return productUrl;
	}
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	/*public String getPartNumber() {
        return strPartNumber;
    }
    public void setPartNumber(String strPartNumber) {
        this.strPartNumber = strPartNumber;
    }*/
    public String getModelDescription() {
        return strModelDescription;
    }
    public void setModelDescription(String strModelDescription) {
        this.strModelDescription = strModelDescription;
    }
    /* public double getUnitCost() {
        return dblUnitCost;
    }
    public void setUnitCost(double dblUnitCost) {
        this.dblUnitCost = dblUnitCost;
    }
     public int getQuantity() {
        return iQuantity;
    }
    public void setQuantity(int quantity) {
        iQuantity = quantity;
    }
    public double getTotalCost() {
        return dblTotalCost;
    }
    public void setTotalCost(double dblTotalCost) {
        this.dblTotalCost = dblTotalCost;
    }*/
}