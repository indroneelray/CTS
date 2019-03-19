package ro.ase.cts.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CoffeeDB {
	private static List<String> coffeeNames;
	
	public static void connect() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("coffee.txt"));
		String line = "";
		coffeeNames = new ArrayList<>();
		while((line = reader.readLine())!=null) {
			coffeeNames.add(line);
		}
		reader.close();
	}
	
	public static void close() {
		coffeeNames.removeAll(coffeeNames);
	}
	
	public static List<String> getData(){
		return coffeeNames;
	}
	
	public static String queryDBByValue(String value) {
		return coffeeNames.get(coffeeNames.indexOf(value));
	}
	
	public static String queryDBByIndex(int index) {
		return coffeeNames.get(index);
	}
}
