package com.app.utils;

import java.util.List;

import com.app.entity.Stock;
import com.app.exception.StockException;

public class StockUtils {

	public static Stock searchByCName(String cname, List<Stock> list) throws StockException {

		for (Stock s : list)
			if (s.getCname().equals(cname)) {
				return s;
			}
		throw new StockException("Invalid company name...");

	}

	public static void PurchaseStock(String id, int quantity, int newquantity, List<Stock> list) throws StockException {
		boolean stockFound = false;
		for (Stock s : list) {
			if (s.getId().equals(id)) {
				s.setQuantity(quantity + newquantity);
				stockFound = true;
				break;
			}
		}
		if (!stockFound) {
			throw new StockException("Invalid id...");
		}
	}

	public static void SellStock(String id, int quantity, int newquantity, List<Stock> list) throws StockException {
		boolean stockFound = false;
		for (Stock s : list) {
			if ((s.getId().equals(id)) && (s.getQuantity()==(quantity))) {
				if(s.getQuantity()<newquantity) {
					throw new StockException("Insufficient stock quantity...");
				}
				s.setQuantity(quantity - newquantity);
				stockFound = true;
				break;
			}
		}
		if (!stockFound) {
			throw new StockException("Invalid id or quantity...");
		}
	}

}
