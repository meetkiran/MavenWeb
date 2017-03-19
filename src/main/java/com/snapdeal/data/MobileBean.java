package com.snapdeal.data;

public class MobileBean implements Comparable  {
private String imageLink;
private String title;
public String getImageLink() {
	return imageLink;
}
public void setImageLink(String imageLink) {
	this.imageLink = imageLink;
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
public String getAvailability() {
	return availability;
}
public void setAvailability(String availability) {
	this.availability = availability;
}
public String getLink() {
	return link;
}
public void setLink(String link) {
	this.link = link;
}
public String getMrp() {
	return mrp;
}
public void setMrp(String mrp) {
	this.mrp = mrp;
}
private String description;
private String availability;
private String link;
private String mrp;
public int compareTo(Object obj) {return this.mrp.compareTo(((MobileBean)obj).mrp);
}

public String toString() {
    return mrp;
}
}
