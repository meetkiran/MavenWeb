package com.flipkart.data;



import java.lang.Double;
import java.lang.Float;
import java.lang.String;

public class ProductInfo {

    /**
     * Below fields list is not a comprehensive one.
     *
     */

    private String title;
    private String description;
    private String inStock;
    private String imgurl;
    private String productUrl;
	public String getProductUrl() {
		return productUrl;
	}
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}
	public String getInStock() {
		return inStock;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String isInStock() {
		return inStock;
	}
	public void setInStock(String inStock) {
		this.inStock = inStock;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
    }
