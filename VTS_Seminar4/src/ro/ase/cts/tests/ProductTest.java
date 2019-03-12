package ro.ase.cts.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.ase.cts.exceptions.InvalidDiscountException;
import ro.ase.cts.models.Product;

public class ProductTest {

		private Product product;
		
		@Before
		public void setUp() {
			this.product = new Product();
			System.out.println("Set-up was called");
		}
		
		@After
		public void tearDown() {
			System.out.println("Tear-down called");
			this.product.setProductName("");
			this.product.setPrice(0);
		}
	
		@Test
		public void testApplyDiscountMethod() {
			
			this.product.setProductName("Apple Airpods 2");
			this.product.setPrice(1000);
			try {
				this.product.applyDiscount(0.5);
				assertEquals(500, this.product.getPrice(), 0.0001);
			} catch (InvalidDiscountException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		@Test
		public void testNegativePercentage() {
			this.product.setProductName("Huawei P30");
			this.product.setPrice(4000);
			try {
				this.product.applyDiscount(-0.5);
				fail("Discount percentage value cannot be negative");
			} catch (InvalidDiscountException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		}
		
		@Test
		public void testGreaterPercentage() {
			this.product.setProductName("Macbook Pro");
			this.product.setPrice(15000);
			try {
				this.product.applyDiscount(1.5);
				fail("Value cannot be more than 1");
			}
			catch(InvalidDiscountException e) {
				System.out.println(e.getMessage());
			}
		}
		
	
	
	
}
