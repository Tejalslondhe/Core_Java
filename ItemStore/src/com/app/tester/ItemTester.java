package com.app.tester;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.entity.Item;
import com.app.ordering.sortByPrice;
import com.app.utils.IOUtils;
import com.app.utils.ItemValidations;

public class ItemTester {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in))
		{
			boolean Exit = false;
			Map<String, Item> map = new HashMap<>();
			while(!Exit)
			{
				System.out.println("Option:\n 1.Add a item \n 2.Display the item \n 3.Order by code \n 4.Order by price \n 5.Write in file \n 6.Read the details \n 7.Exit \n");
				try {
					switch(sc.nextInt())
					{
					case 1:
						System.out.println("Enter the details: code,description,price,shipmentDate");
						Item item = ItemValidations.addItem(sc.next(), sc.next(), sc.nextDouble(), sc.next());
						System.out.println("Added successfully...");
						map.put(item.getCode(), item);
						break;
						
					case 2:
						
						System.out.println("Display all items");	
						for(Item i:map.values())
							System.out.println(i);
						break;
						
					case 3:
						
						TreeMap<String,Item> sortedItem = new TreeMap<>(map);
						System.out.println("Sorting by code");
						for(Item i : sortedItem.values())
							System.out.println(i);
						break;
						
					case 4:
						System.out.println("Sorting by price");
						LinkedList<Item> list = new LinkedList<>(map.values());
						Collections.sort(list,new sortByPrice());
						for(Item i : list)
							System.out.println(i);
						break;	
						
					case 5:
						System.out.println("Enter file name in which you want to write");
						IOUtils.writeDetails(map,sc.next());
						
						break;
						
					case 6:
						System.out.println("Enter File name which u want to read ");
						Map<String, Item> map1 = IOUtils.readDetails(sc.next());
						System.out.println("Student details -");
						map1.forEach((k, v) -> System.out.println(v));
						break;
						
					case 7:
						Exit = true;
						break;
						
					}
				}catch(Exception e)
				{
					sc.nextLine();
					System.out.println(e);
				}
			}
		}

	}

}
