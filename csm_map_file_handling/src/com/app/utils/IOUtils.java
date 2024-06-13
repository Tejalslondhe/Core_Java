package com.app.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.core.Customer;

public interface IOUtils {

	static void writeDetails(Map<String, Customer> customerMap, String fileName) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(customerMap);
		}
	}

	static Map<String, Customer> readDetails(String fileName) throws IOException, ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			return (Map<String, Customer>) in.readObject();
		}
	}

}
