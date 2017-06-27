package com.tz.entity;

public class Productinfo {
	//productid productname price p_typeid pic description qty
	private int productid;
	private String productname;
	private double price;
	private int p_typeid;
	private String pic;
	private String description;
	private int qty;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getP_typeid() {
		return p_typeid;
	}
	public void setP_typeid(int p_typeid) {
		this.p_typeid = p_typeid;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "Productinfo [productid=" + productid + ", productname="
				+ productname + ", price=" + price + ", p_typeid=" + p_typeid
				+ ", pic=" + pic + ", description=" + description + ", qty="
				+ qty + "]";
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
}
