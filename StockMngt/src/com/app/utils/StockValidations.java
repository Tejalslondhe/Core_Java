package com.app.utils;

import java.time.LocalDate;
import java.util.List;

import com.app.entity.Stock;
import com.app.exception.StockException;

public class StockValidations {

	public static LocalDate parseCDate(String cdate) throws StockException {
		if (LocalDate.parse(cdate).isBefore(LocalDate.now()))
			throw new StockException("Invalid Date");
		return LocalDate.parse(cdate);
	}

	public static void chkDupId(String id, List<Stock> list) throws StockException {
		for(Stock s:list)
			if((s.getId().equals(id)))
				throw new StockException("Duplicate id");

}
	

	public static Stock addStock(String id, String name, String cname, double price, String cdate, int quantity,
			List<Stock> list) throws StockException {
		
		LocalDate d = parseCDate(cdate);
		chkDupId(id, list);
		return new Stock(id, name, cname, price, d, quantity);
	}

}
