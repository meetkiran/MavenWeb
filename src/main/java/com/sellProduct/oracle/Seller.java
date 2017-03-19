package com.sellProduct.oracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="smart_seller")
public class Seller {
	@Id
	@Column(name="seller_id" , nullable = false)
	private String seller_id;
	
	@Column(name="firstname")
	String firstname;
	@Column(name="lastname")
	String lastname;
	@Column(name="address")
	String address;
	@Column(name="email")
	String email;
	@Column(name="mobileno")
	int mobile;
	
	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getFirstname() {
		return firstname;
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
