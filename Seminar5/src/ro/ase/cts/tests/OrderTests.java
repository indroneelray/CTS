package ro.ase.cts.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.ase.cts.util.CoffeeDB;

public class OrderTests {
	
	@BeforeClass
	public static void beforeAll() {
		System.out.println("Connecting to database....");
		try {
			CoffeeDB.connect();
			System.out.println("Connection Successful");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test		//RIGHT Testing Concept
	public void testDatabaseSet() {
			assertEquals("Cappucino", CoffeeDB.queryDBByIndex(1));
	}
	
	@Test
	public void testForCrossCheck() {
		assertEquals("Cappucino", CoffeeDB.queryDBByValue("Cappucino"));
	}
	
	@AfterClass
	public static void afterAll() {
		System.out.println("Closing database connection....");
		CoffeeDB.close();
		System.out.println("Connection closed");
	}
	
	
	
}
