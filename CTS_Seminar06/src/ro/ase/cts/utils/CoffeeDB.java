package ro.ase.cts.utils;
import ro.ase.cts.models.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CoffeeDB {
	public static List<Coffee> coffeeNames;
	
	public static void connectDB(String user, String pw) throws IOException {
		coffeeNames = new ArrayList<Coffee>();
		BufferedReader reader = new BufferedReader(new FileReader("coffee.txt"));
		String line = "";
		
		while((line = reader.readLine()) != null) {
			String[] values = line.split(",");
			Coffee c = new Coffee(values[0], CoffeeType.valueOf(CoffeeType.class, values[1]), Double.parseDouble(values[2]));
			coffeeNames.add(c);
		}
		reader.close();
		System.out.println("Succesfully connected to database");
		
	}
	
	public static Coffee selectCoffeeByName(String name) {
		return coffeeNames.get(coffeeNames.indexOf(name));
	}
	
	public static Coffee selectCoffeeByIndex(int index) {
		return coffeeNames.get(index);
	}
	
	public static void closeDB(String user, String pw) {
		coffeeNames.removeAll(coffeeNames);
	}
}
