package com.app.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Stock implements Serializable{
	private String id;
	private String name;
	private String cname;
	private double price;
	private LocalDate cdate;
	private int quantity;
	
	
	public Stock(String id,String name, String cname, double price, LocalDate cdate, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.cname = cname;
		this.price = price;
		this.cdate = cdate;
		this.quantity = quantity;
		
	}
	
	
	

	public Stock(String cname) {
		this.cname = cname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getCdate() {
		return cdate;
	}

	public void setCdate(LocalDate cdate) {
		this.cdate = cdate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", name=" + name + ", cname=" + cname + ", price=" + price + ", cdate=" + cdate
				+ ", quantity=" + quantity + "]";
	}




	@Override
	public int hashCode() {
		return Objects.hash(id);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	

}
