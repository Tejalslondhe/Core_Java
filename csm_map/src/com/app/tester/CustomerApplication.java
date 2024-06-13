package com.app.tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.core.Customer;
import com.app.cust_ordering.OrderingByDobAndLname;
import com.app.utils.CustomerUtils;
import com.app.utils.CustomerValidation;

public class CustomerApplication {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in))
		{
			boolean exit = false;
						
			
			Map<String,Customer> customerMap = new HashMap<>();
			//List<Customer> customerList = CustomerUtils.populateCustomer();
			while(!exit)
			{
				System.out.println("Options : \n 1.Customer Sign Up \n 2.Login \n 3.Change password \n 4.Delete customer details \n "
						+ "5.Display all \n 6.Sorting by EmailID \n 7.Sorting by DOB and last name \n 8.Sorting (Custome) \n 9.Delete (given plan and DOB) \n 0.Exit");
				System.out.println("Enter the choice");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter customer details : firstName,  lastName,  email,  password, regAmount,  dob,  plan ");
						
						Customer cust = CustomerValidation.validateCustomerInputs(sc.next(), sc.next(), sc.next(),
								sc.next(),sc.nextDouble(), sc.next(), sc.next(), customerMap);
						
						customerMap.put(cust.getEmail(),cust);
						
						System.out.println("Registration successfull....");
						break;
						
					case 2:
						
						System.out.println("Enter the email and password:");
						
						Customer cust1 = CustomerUtils.login(sc.next(),sc.next(),customerMap);
						
						System.out.println("Your details are: "+cust1);
						
						
						break;
						
					case 3:
						
						System.out.println("Enter the email, password");
						Customer cust3 = CustomerUtils.login(sc.next(),sc.next(),customerMap);
						System.out.println("Enter the new password");
						cust3.setPassword(sc.next());
						System.out.println("Password change successfully!!! \n" + cust3);
						
						break;
						
					case 4:
						System.out.println("Enter the email of customer which you want to remove");
						String cust5 = CustomerUtils.Deletecust(sc.next(),customerMap);
						System.out.println("Unsubscribe successfully....");
						
						break;
						
					case 5:
						
						System.out.println("Display all details");
						for(Customer a:customerMap.values())
							System.out.println(a);
						break;
						
					case 6:
						TreeMap<String,Customer> sortedCust = new TreeMap<>(customerMap);
						System.out.println("Sorted customers as per Email");
						for(Customer c:sortedCust.values())
							System.out.println(c);
						break;
						
					case 7:
						
						LinkedList<Customer>list = new LinkedList<>(customerMap.values());
						Collections.sort(list, new OrderingByDobAndLname());
						System.out.println("Sorting by DOB and lastName");
						for(Customer c : list)
							System.out.println(c);
						break;
						
					case 8:
						
						LinkedList<Customer>list1 = new LinkedList<>(customerMap.values());
						Collections.sort(list1, new Comparator<Customer>() {

							@Override
							public int compare(Customer c1, Customer c2)
							{
								System.out.println("Compare DOB and Last name");
								int retVal  = c1.getDob().compareTo(c2.getDob());
								if (retVal == 0)
								{
									return (c1.getEmail().compareTo(c2.getEmail()));
										
								}
								return retVal;
							}
							
						});
						
						for(Customer c : list1)
							System.out.println(c);
						
						break;
											
												
					case 9:
						
						System.out.println("Enter the plan and birthdate you want to remove");
						CustomerUtils.DeleteByPlannDOB(sc.next(),sc.next(),customerMap);
						System.out.println("Deleted successfully!!!");
						
						break;
						
					case 0:
						
						exit = true;
						break;
					}
			}catch (Exception e) {
				sc.nextLine();
				System.out.println(e);
			}
		}
	}
	}
}
