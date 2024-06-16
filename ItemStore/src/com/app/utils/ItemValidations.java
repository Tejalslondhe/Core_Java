package com.app.utils;

import java.time.LocalDate;
import java.util.Map;

import com.app.entity.Item;
import com.app.exception.ItemExceptions;

public class ItemValidations {
	
	public static void checkDupCode(String code, Map<String,Item>map) throws ItemExceptions
	{
		if(map.containsKey(code))
		throw new ItemExceptions("Duplicate code...");
	}
	
	public static LocalDate parseDate(String shipmentDate)
	{
		return LocalDate.parse(shipmentDate);
		
	}
	
	public static Item addItem(String code, String description, double price, String shipmentDate)
	{
		LocalDate sdate = parseDate(shipmentDate);
		
		return new Item(code,description,price,sdate);
		
	}

}
