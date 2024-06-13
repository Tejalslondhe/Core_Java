package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.app.core.Customer;
import com.app.core.ServicePlan;
import com.app.cust_exceptions.CustomerException;

public class CustomerUtils {

	// login using email and password
	public static Customer login(String email,String password,Map<String,Customer> map)throws CustomerException
	{

	Customer b = map.get(email);
	if(b == null)
		throw new CustomerException("Invalid Email!!! Please login again...");
	if(b.getPassword().equals(password))
		throw new CustomerException("Invalid Password!!! Please login again...");
	return b;
	
	
	
}

	public static String Deletecust(String email, Map<String, Customer> map) throws CustomerException {

		Customer a = map.remove(email);
		if (a == null)
			throw new CustomerException("Can't unsubscribe - Invalid email!!!");

		return "Deleted successfully...";
	}

	public static String DeleteByPlannDOB(String plan, String ndob, Map<String, Customer> map)
			throws CustomerException {

		Iterator<Customer> itr = map.values().iterator();
		while (itr.hasNext()) {
			Customer cust = itr.next();
			ServicePlan pn = ServicePlan.valueOf(plan.toUpperCase());
			LocalDate d = LocalDate.parse(ndob);
			if (cust.getPlan() == pn && cust.getDob().isAfter(d))
				itr.remove();
		}
		return null;

	}

}
