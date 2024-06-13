package com.app.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;

import com.app.core.Customer;
import com.app.core.ServicePlan;
import com.app.cust_exceptions.CustomerException;

public class CustomerValidation {
	
	public static void checkForDupCustomer(String email, Map<String,Customer> map) throws CustomerException
	{
		if(map.containsKey(email))
			throw new CustomerException("Duplicate Email!!!!");	
	}
	
	
	public static ServicePlan parseAndValidatePlanAndCharges(String plan, double regAmount)throws CustomerException {
		
		ServicePlan sp = ServicePlan.valueOf(plan.toUpperCase());
		if(sp.getPlanCost()==regAmount)
			return sp;
		throw new CustomerException("Registration amount does not match to choosen plan");
		
	}
	
	public static void validatepassword(String password)throws CustomerException
	{
		String regEx = "((?=.*\\d)(?=.*[a-z])(?=.*[#@*$]).{5,20})";
		if(!password.matches(regEx))
			throw new CustomerException("Password is not strong!!!");
		
		
	}
	
	public static void valideEmail(String email)throws CustomerException
	{
		String regEx = "^[a-z0-9+_.-]+@(?:[A-Za-z0-9-]+\\.)+(com|org|net)$";
					
		if(!email.matches(regEx))
		
		throw new CustomerException("Email is not correctly entered...");
	}
	
	
	public static LocalDate validateDob(String dob)throws CustomerException
	{
		LocalDate birthDate = LocalDate.parse(dob);
		int age = Period.between(birthDate, LocalDate.now()).getYears();
		if(age<21)
			throw new CustomerException("Age is below 21....");
		return birthDate;
	}
	
	public static Customer validateCustomerInputs(String firstName,String lastName,String email, String password,
			double regAmount, String dob, String plan, Map<String,Customer> customerMap) throws CustomerException
	{
		checkForDupCustomer(email,customerMap);
		ServicePlan servicePlan = parseAndValidatePlanAndCharges(plan,regAmount);
		LocalDate birthDate = LocalDate.parse(dob);
		validatepassword(password);
		validateDob(dob);
		valideEmail(email);
		return new Customer(firstName, lastName, 
				email, password, regAmount, birthDate, servicePlan);
	
	}

}
