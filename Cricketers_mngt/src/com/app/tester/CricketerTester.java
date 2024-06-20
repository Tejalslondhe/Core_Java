package com.app.tester;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import com.app.entities.Cricketers;
import com.app.ordering.OrderByRatings;
import com.app.utility.CricketerUtility;
import com.app.utility.CricketerValidations;

public class CricketerTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			Map<String, Cricketers> cmap = new HashMap<>();
			while (!exit) {
				System.out.println(
						"Options: \n 1.Add new Cricketer's details \n 2.Modify Cricketer's rating \n 3.Search Cricketer by name \n"
								+ " 4.Display all Cricketers added in collection \n 5.Display All Cricketers in sorted form by rating \n 6.Exit \n");
				System.out.println("Enter the choice");

				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter the details: name,age,email,phone,ratings");

						Cricketers c = CricketerValidations.addCricketers(sc.next(), sc.nextInt(), sc.next(), sc.next(),
								sc.nextInt(),cmap);
						cmap.put(c.getEmail(), c);
						System.out.println("Added successfully!!!!");
						break;

					case 2:
						System.out.println("Enter the email whose rating want wants to change");
						Cricketers c1 = CricketerUtility.checkEmail(sc.next(), cmap);
						System.out.println("Enter new rating");
						c1.setRating(sc.nextInt());
						System.out.println("Updated successfully!!!!");
						break;

					case 3:
						System.out.println("Enter the name");
						Cricketers c2 = CricketerUtility.searchByName(sc.next(), cmap);
						System.out.println(c2);
						break;

					case 4:

						System.out.println("Details of all cricketers are:");
						for(Cricketers ct : cmap.values())
							System.out.println(ct);
						break;

					case 5:
						LinkedList<Cricketers> list = new LinkedList<>(cmap.values());
						System.out.println("Sorting by rating");
						Collections.sort(list,new OrderByRatings());
						for(Cricketers ct1: list)
							System.out.println(ct1);
						break;

					case 6:
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
