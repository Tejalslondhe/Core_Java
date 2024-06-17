package com.app.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.app.entity.Stock;

public interface IOUtils {
	
	static void writeDetails(List<Stock> list,String fileName) throws FileNotFoundException, IOException {
	try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
		out.writeObject(list);
	}
	}
	
	static List<Stock> readDetails(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException{
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
			return (List<Stock>) in.readObject();
		}
	}

}
