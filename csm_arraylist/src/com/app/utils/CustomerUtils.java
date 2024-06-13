package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.core.Customer;
import com.app.core.ServicePlan;
import com.app.cust_exceptions.CustomerException;

public class CustomerUtils {
	
	public static Customer login(String email,String password,List<Customer> acct)throws CustomerException
	{

	Customer accts = new Customer(email);
	int index = acct.indexOf(accts);
	if(index == -1)
		throw new CustomerException("Invalid Email!!! Please login again...");
	
	Customer customer = acct.get(index);
	if(customer.getPassword().equals(password))
	
		
	{
		//return "Login successfull!!!!";
		return customer;
	}
	throw new CustomerException("Invalid password!!! Please login again...");
	
}
	
	

	
	
	public static String Deletecust(String email,List<Customer> acct)throws CustomerException
	{

	Customer accts = new Customer(email);
	int index = acct.indexOf(accts);
	if(index == -1)
		throw new CustomerException("Can't unsubscribe - Invalid email!!!");
	return acct.remove(index).getFirstName();
	
	}
	
	public static void DeleteByPlannDOB(String plan, String ndob, List<Customer> acct)
	{
		
		Iterator<Customer> itr = acct.iterator();
		while(itr.hasNext())
		{
				Customer cust = itr.next();
				ServicePlan pn = ServicePlan.valueOf(plan.toUpperCase());
				LocalDate d = LocalDate.parse(ndob);
				if(cust.getPlan()==pn && cust.getDob().isAfter(d))
				itr.remove();
		}
		
	}
	
	
	
	
	public static List<Customer> populateCustomer() {
		Customer a1 = new Customer("a1", "b1","londhe@gmail","abc11", 1000, LocalDate.parse("1991-10-27"),ServicePlan.SILVER);
		Customer a2 = new Customer("a2", "b2","patil@gmail.com","abc22", 1000, LocalDate.parse("2000-05-17"),ServicePlan.SILVER);
		Customer a3 = new Customer("a3", "b3","dashpute@gmail.com","abc33", 2000, LocalDate.parse("2002-01-06"),ServicePlan.GOLD);
		Customer a4 = new Customer("a4", "b4","mhetre@gmail.com","abc44", 1000, LocalDate.parse("1991-10-27"),ServicePlan.SILVER);
		Customer a5 = new Customer("a5", "b5","kaiche@gmail.com","abc55", 5000, LocalDate.parse("1991-10-27"),ServicePlan.DIAMOND);
		Customer[] accts = { a1, a2, a3, a4, a5};
		List<Customer> list = new ArrayList<>();// up casting
		for (Customer a : accts)
			list.add(a);
		return list;
	
}
}