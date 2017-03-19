package com.sellProduct.oracle;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name="smart_timeslot")
public class Timeslot {
@Id
@GeneratedValue
@Column(name="booking_id")
String booking_id;


private ProductBean product_id;


Seller seller_id;

@Column(name="booking_date")
Date booking_date;

public String getBooking_id() {
	return booking_id;
}

public void setBooking_id(String booking_id) {
	this.booking_id = booking_id;
}

public Date getBooking_date() {
	return booking_date;
}

public void setBooking_date(Date booking_date) {
	this.booking_date = booking_date;
}
@ManyToOne(cascade=CascadeType.ALL)
public ProductBean getProd_id() {
	return product_id;
}

public void setProd_id(ProductBean prod_id) {
	this.product_id=prod_id;
}


}
