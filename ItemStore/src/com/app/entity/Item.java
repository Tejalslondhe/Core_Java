package com.app.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Item implements Serializable {
	
	private String code;
	private String description;
	private double price;
	private LocalDate shipmentDate;
	
	public Item(String code, String description, double price, LocalDate shipmentDate) {
		super();
		this.code = code;
		this.description = description;
		this.price = price;
		this.shipmentDate = shipmentDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(LocalDate shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	@Override
	public String toString() {
		return "Item [code=" + code + ", description=" + description + ", price=" + price + ", shipmentDate="
				+ shipmentDate + "]";
	}
	
	
	
	
	

}
