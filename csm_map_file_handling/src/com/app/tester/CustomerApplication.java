package com.app.tester;

//import static utils.IOUtils.writeDetails;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.core.Customer;
import com.app.cust_ordering.OrderingByDobAndLname;
import com.app.utils.CustomerUtils;
import com.app.utils.CustomerValidation;
import com.app.utils.IOUtils;

public class CustomerApplication {

	public static void main(String[] args) throws IOException {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;

			Map<String, Customer> customerMap = new HashMap<>();

			// List<Customer> customerList = CustomerUtils.populateCustomer();
			while (!exit) {
				System.out.println(
						"Options : \n 1.Customer Sign Up \n 2.Write File \n 3.Read the data from file \n 4.Login \n 5.Change password \n 6.Delete customer details \n "
								+ "7.Display all \n 8.Sorting by EmailID \n 9.Sorting by DOB and last name \n 10.Sorting (Custome) \n 11.Delete (given plan and DOB) \n 0.Exit");
				System.out.println("Enter the choice");

				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter customer details : firstName,  lastName,  email,  password, regAmount,  dob,  plan ");

						Customer cust = CustomerValidation.validateCustomerInputs(sc.next(), sc.next(), sc.next(),
								sc.next(), sc.nextDouble(), sc.next(), sc.next(), customerMap);

						customerMap.put(cust.getEmail(), cust);
						System.out.println("Registration successfull....");
						break;

					case 2:
						System.out.println("Enter File name in which you want to write");
						IOUtils.writeDetails(customerMap, sc.next());
						break;

					case 3:
						System.out.println("Enter File name which u want to read ");
						Map<String, Customer> map = IOUtils.readDetails(sc.next());
						System.out.println("Student details -");
						map.forEach((k, v) -> System.out.println(v));
						break;
						
					case 4:

						System.out.println("Enter the email and password:");

						Customer cust1 = CustomerUtils.loginEmail(sc.next(), customerMap);
						Customer cust2 = CustomerUtils.loginPassword(sc.next(), customerMap);
						System.out.println("Your details are:" + cust1 + " " + cust2);

						break;

					case 5:

						System.out.println("Enter the email, password");
						Customer cust3 = CustomerUtils.loginEmail(sc.next(), customerMap);
						Customer cust4 = CustomerUtils.loginPassword(sc.next(), customerMap);
						System.out.println("Enter the new password");
						cust4.setPassword(sc.next());
						System.out.println("Password change successfully!!! \n" + cust4);

						break;

					case 6:
						System.out.println("Enter the email of customer which you want to remove");
						String cust5 = CustomerUtils.Deletecust(sc.next(), customerMap);
						System.out.println("Unsubscribe successfully....");

						break;

					case 7:
						System.out.println("Display all details");
						for (Customer a : customerMap.values())
							System.out.println(a);
						break;

					case 8:
						TreeMap<String, Customer> sortedCust = new TreeMap<>(customerMap);
						System.out.println("Sorted customers as per Email");
						for (Customer c : sortedCust.values())
							System.out.println(c);
						break;

					case 9:

						LinkedList<Customer> list = new LinkedList<>(customerMap.values());
						Collections.sort(list, new OrderingByDobAndLname());
						System.out.println("Sorting by DOB and lastName");
						for (Customer c : list)
							System.out.println(c);
						break;

					case 10:

						LinkedList<Customer> list1 = new LinkedList<>(customerMap.values());
						Collections.sort(list1, new Comparator<Customer>() {

							@Override
							public int compare(Customer c1, Customer c2) {
								System.out.println("Compare DOB and Last name");
								int retVal = c1.getDob().compareTo(c2.getDob());
								if (retVal == 0) {
									return (c1.getEmail().compareTo(c2.getEmail()));

								}
								return retVal;
							}

						});

						for (Customer c : list1)
							System.out.println(c);

						break;

//					case 11:
//						
//						System.out.println("Enter the plan and birthdate you want to remove");
//						CustomerUtils.DeleteByPlannDOB(sc.next(),sc.next(),customerList);
//						System.out.println("Deleted successfully!!!");
//						
//						break;

					case 0:

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
