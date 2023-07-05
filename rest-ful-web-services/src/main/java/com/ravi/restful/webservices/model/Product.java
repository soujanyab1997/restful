package com.ravi.restful.webservices.model;

public class Product {

	private int id;
	private String name;
	private String longDescription;
	private long price;
	private String color;
	private String sellerName;
	public Product() {
		super();
	}
	public Product( String name, String longDescription, long price, String color, String sellerName) {
		super();
		this.name = name;
		this.longDescription = longDescription;
		this.price = price;
		this.color = color;
		this.sellerName = sellerName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", longDescription=" + longDescription + ", price=" + price
				+ ", color=" + color + ", sellerName=" + sellerName + "]";
	}
	
	
}
