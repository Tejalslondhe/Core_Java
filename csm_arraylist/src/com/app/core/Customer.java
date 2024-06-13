package com.app.core;

import java.time.LocalDate;

public class Customer implements Comparable<Customer> {
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double regAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private static int idGenerator=1000;

	public Customer(String firstName, String lastName, String email, String password, double regAmount, LocalDate dob,
			ServicePlan plan) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
		this.customerId = ++idGenerator;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	//add overloaded ctor , to wrap PK (email)
	public Customer(String email) {
		this.email = email;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", Password=" + password + ", regAmount=" + regAmount + ", dob=" + dob + ", plan=" + plan + "]";
	}
	

	//override equals method to replace ref equality by PK based equality
	@Override
	public boolean equals(Object o)
	{
		System.out.println("in customer's equals");
		if(o instanceof Customer)
		{
			Customer c=(Customer)o;
			return this.email.equals(c.email);
		}
		//if the passed arg is not a Customer : ret false
		return false;
		
	}
	
	
	@Override
	public int compareTo(Customer anotherAccount)
	{
		System.out.println("in compareTo");
		
			return this.email.compareTo(anotherAccount.email);
		
	}
	public ServicePlan getPlan() {
		return plan;
	}
	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	

}
