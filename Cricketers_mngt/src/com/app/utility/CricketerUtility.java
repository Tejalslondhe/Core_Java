package com.app.utility;

import java.util.Map;

import com.app.entities.Cricketers;
import com.app.exception.CricketerException;

public class CricketerUtility {
	
	public static Cricketers checkEmail(String email,Map<String, Cricketers>map) throws CricketerException
	{
		Cricketers c = map.get(email);
				if(c == null)
					throw new CricketerException("Invalid email...");
				return c;
	}
	
	//search by name
	public static Cricketers searchByName(String name, Map<String,Cricketers> map) throws CricketerException
	{
		for(Cricketers c1:map.values())
		if(c1.getName().equalsIgnoreCase(name))
		{
			return c1;
		}
		throw new CricketerException("Name not found...");
		
	}
		
		
		
		
		
	

}
