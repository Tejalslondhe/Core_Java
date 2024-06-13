package com.app.cust_ordering;

import java.util.Comparator;

import com.app.core.Customer;

public class OrderingByDobAndLname implements Comparator<Customer>{
	
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

}
