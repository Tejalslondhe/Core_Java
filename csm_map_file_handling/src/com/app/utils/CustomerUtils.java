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
	public static Customer loginEmail(String email, Map<String, Customer> map) throws CustomerException {
		boolean a1 = map.containsKey(email);
		if (a1 == false)
			throw new CustomerException("Invalid Email!!! Please login again...");
		return null;
	}

		public static Customer loginPassword(String password, Map<String, Customer> map) throws CustomerException {
		boolean a2 = map.containsValue(password);
		if (a2 == false)
		throw new CustomerException("Invalid password!!! Please login again...");
		return null;

	}

	public static String Deletecust(String email, Map<String,Customer> map) throws CustomerException {

		
		Customer a = map.remove(email);
		if (a == null)
			throw new CustomerException("Can't unsubscribe - Invalid email!!!");
		
		return "Deleted successfully..."; 
	}

	public static String DeleteByPlannDOB(String plan, String ndob, Map<String,Customer> map) throws CustomerException {
			
			
			Iterator<Customer> itr = map.values().iterator();
			while(itr.hasNext())
			{
					Customer cust = itr.next();
					ServicePlan pn = ServicePlan.valueOf(plan.toUpperCase());
					LocalDate d = LocalDate.parse(ndob);
					if(cust.getPlan()==pn && cust.getDob().isAfter(d))
					itr.remove();
			}
			return null;
				
		}

	}

	
