package com.sellProduct.oracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="smart_seller")
public class Users {
	public Users(){}
	@Id
	@GeneratedValue
	@Column(name="Seller_id")
	int seller_id;
public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int id) {
		this.seller_id = id;
	}
	@Column(name="firstname")
String firstName;
	@Column(name="lastname")
String lastName;
	
	@Column(name="email")
String email;
	@Column(name="address")
String address;
	@Column(name="mobileno")
int mobileNo;

public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getMobileNo() {
	return mobileNo;
}
public void setMobileNo(int mobileNo) {
	this.mobileNo = mobileNo;
}

String password;



public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
