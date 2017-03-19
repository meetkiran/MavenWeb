package com.sellProduct.oracle;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="smart_product")
public class ProductBean {
@Id
@Column(name="prod_id", nullable = false)
String prod_id;
@Column(name="prod_name")
String prod_name;
@Column(name="prod_desc")
String prod_desc;
@Column(name="photo_name")
String photo_name;
@Column(name="prod_age")
String prod_age;

@ManyToOne(cascade=CascadeType.ALL)
Seller sellerId;
public Seller getSellerId() {
	return sellerId;
}

public void setSellerId(Seller sellerId) {
	this.sellerId = sellerId;
}

public String getProd_id() {
	return prod_id;
}
public void setProd_id(String prod_id) {
	this.prod_id = prod_id;
}
public String getProd_name() {
	return prod_name;
}
public void setProd_name(String prod_name) {
	this.prod_name = prod_name;
}
public String getProd_desc() {
	return prod_desc;
}
public void setProd_desc(String prod_desc) {
	this.prod_desc = prod_desc;
}
public String getPhoto_name() {
	return photo_name;
}
public void setPhoto_name(String photo_name) {
	this.photo_name = photo_name;
}
public String getProd_age() {
	return prod_age;
}
public void setProd_age(String prod_age) {
	this.prod_age = prod_age;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
int price;
}
