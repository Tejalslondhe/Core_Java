package com.app.utility;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.CredentialException;

import com.app.entities.Cricketers;
import com.app.exception.CricketerException;

public class CricketerValidations {
	
	
	
	public static void checkDupEmail(String email,Map<String,Cricketers>map) throws CricketerException
	{
		if(map.containsKey(email))
			throw new CricketerException("Duplicate email...");
		
		
	}
	
	public static Cricketers addCricketers(String name, int age, String email, String phone, int rating,Map<String,Cricketers>map) throws  CricketerException
	{
		checkDupEmail(email, map);
		return new Cricketers(name, age, email, phone, rating);
		
	}
	
	
	
	
	
	

}
