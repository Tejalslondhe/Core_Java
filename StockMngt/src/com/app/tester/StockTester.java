package com.app.tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.entity.Stock;
import com.app.utils.IOUtils;
import com.app.utils.StockUtils;
import com.app.utils.StockValidations;

public class StockTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			List<Stock> slist = new ArrayList<>();
			while (!exit) {
				try {
					System.out.println(
							"1.Add new stock \n 2.Display all stocks \n 3.View available stocks by cname \n 4.Purchase stocks \n 5.Sell stock \n 6.Save n exit \n");

					System.out.println("Enter your choice...");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter new stock details: id ,name, comp_name,price,closing_date,quantity");
						Stock s = StockValidations.addStock(sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(),
								sc.nextInt(), slist);
						slist.add(s);
						System.out.println("Adding stocks successfully");
						break;

					case 2:
						System.out.println("Display all stocks:");
						for (Stock s1 : slist) {
							System.out.println(s1);
						}
						break;

					case 3:
						System.out.println("Enter the company name");
						Stock s1 = StockUtils.searchByCName(sc.next(), slist);
						System.out.println(s1);
						break;

					case 4:
						System.out.println("Enter id,oldqty,newqty");
						StockUtils.PurchaseStock(sc.next(), sc.nextInt(), sc.nextInt(), slist);
						System.out.println("Successfully purchased the stocks!!!");
						break;

					case 5:
						System.out.println("Enter id,oldqty,newqty");
						StockUtils.SellStock(sc.next(), sc.nextInt(), sc.nextInt(), slist);
						System.out.println("Successfully sold the stocks!!!");

						break;

					case 6:
						System.out.println("Enter the file name in which u want to save");
						IOUtils.writeDetails(slist, sc.next());
						System.out.println("Details save successfully..");
						System.out.println("Enter the file name to read details");
						List<Stock> list = IOUtils.readDetails(sc.next());
						for (Stock i : list) {
							System.out.println(i);
						}

						exit = true;

						break;

					}
				} catch (Exception e) {
					sc.nextLine();
					System.out.println(e);
				}
			}
		}

	}

}
