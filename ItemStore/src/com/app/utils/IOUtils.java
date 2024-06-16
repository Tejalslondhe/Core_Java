package com.app.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.entity.Item;

public class IOUtils {
	
	public static void writeDetails (Map<String , Item> map,String fileName) throws IOException{
	try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName)))
	{
	out.writeObject(map);	
	}
}
	
	
	public static Map<String, Item> readDetails(String fileName) throws IOException,ClassNotFoundException
	{
		try(ObjectInputStream in= new ObjectInputStream(new FileInputStream(fileName)))
		{
			return (Map<String,Item>) in.readObject();
		}
	}
	
	

}
