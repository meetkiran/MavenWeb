package com.sellProduct.oracle;

public class Buyer {
private String buyer_id,firstname,lastname,address,email;
int mobile;
public int getMobile() {
	return mobile;
}

public void setMobile(int mobile) {
	this.mobile = mobile;
}

public String getBuyer_id() {
	return buyer_id;
}

public void setBuyer_id(String buyer_id) {
	this.buyer_id = buyer_id;
}

public String getFirstname() {
	return firstname;
}

public Buyer() {
	super();
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
}
