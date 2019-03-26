package ro.ase.cts.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Optional;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.ase.cts.models.Coffee;
import ro.ase.cts.models.Order;
import ro.ase.cts.utils.CoffeeDB;
import ro.ase.cts.utils.CoffeeType;

public class OrderTest {

		private Order order;
		
		@BeforeClass
		public void beforeAll() {
			try {
				CoffeeDB.connectDB("admin", "password");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@AfterClass
		public void afterAll() {
			CoffeeDB.closeDB("admin", "password");
		}
		
		@Before
		public void setUp() {
		 order = new Order();
		}
	
		@Test
		public void testPrintOrderSingleProduct() {
			Coffee c1 = new Coffee("Late", CoffeeType.BRAZIl, 15.0);
			this.order.addProduct(c1);
			String value = String.join("\n", c1.getBeverageName() + " " + c1.getCoffeeType() + " " + c1.getPrice(),"TOTAL: 15.0");

			assertEquals(value, this.order.printOrder());
		}

		
		@Test
		public void testPrintOrderTwoProducts() {
			Coffee c1 = new Coffee("Late", CoffeeType.BRAZIl, 15.0);
			Coffee c2 = new Coffee("Cappuccino", CoffeeType.ETIOPIA, 12.0);
			String value = String.format("%s \n%s\n%s", c1.getBeverageName() + " " + c1.getCoffeeType() + " " + c1.getPrice(),
														c2.getBeverageName() + " " + c2.getCoffeeType() + " " + c2.getPrice(),
														"TOTAL: 27.0");
			
			this.order.addProduct(c1);
			this.order.addProduct(c2);
			assertEquals(value, this.order.printOrder());
					
		} 
		
		@Test
		public void testMultipleProducts() {
				for(Coffee c : CoffeeDB.coffeeNames) {
					this.order.addProduct(c);
				}
				Optional<String> productsOptional = CoffeeDB.coffeeNames.stream().map(product -> { String value = product.getBeverageName() + " " + product.getCoffeeType() + " " + product.getPrice() + "\n";
				return value;
				}).reduce((finalValue, currentValue) -> {
					finalValue += currentValue;
					return finalValue;
				});
				Optional<Double> totalPriceOptional = CoffeeDB.coffeeNames.stream().map(product -> {
					return product.getPrice();
				}).reduce((total, current) -> {
					total += current;
					return total;
				});
			
				if(productsOptional.isPresent() && totalPriceOptional.isPresent()) {
					String finalOrder = productsOptional.get() + "TOTAL: " + totalPriceOptional.get();
					assertEquals(finalOrder, this.order.printOrder());
				}
				
			}
}
