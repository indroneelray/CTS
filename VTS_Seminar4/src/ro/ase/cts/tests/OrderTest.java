package ro.ase.cts.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.ase.cts.exceptions.EmptyCartException;
import ro.ase.cts.models.Order;
import ro.ase.cts.models.Product;
import ro.ase.cts.utils.DeliveryOption;
import ro.ase.cts.utils.PaymentMethod;


public class OrderTest {
	private Order testOrder;
	
	@Before
	public void setUp() {
		System.out.println("Set up called from " + OrderTest.class);
		this.testOrder = new Order();
	}
	
	@After
	public void tearDown() {
		System.out.println("Teardown called from " + OrderTest.class);
		this.testOrder.setDeliveryOption(null);
		this.testOrder.setPaymentMethod(null);
	}
	
	@Test
	public void testIfOrderCartIsEmpty() {
		assertTrue(this.testOrder.getOrderBasket().isEmpty());
	}
	
	@Test
	public void testFinishOrder() {
		Product p = new Product("Samsung Galaxy Fold", 8000);
		this.testOrder.addProductToCart(p);
		this.testOrder.setDeliveryOption(DeliveryOption.HOME_DELIVERY);
		this.testOrder.setPaymentMethod(PaymentMethod.CASH);
		try {
			assertEquals(8000, this.testOrder.finishOrder(), 0.0001);
		} catch (EmptyCartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFinishOrderWithEmptyCart() {
		this.testOrder.setDeliveryOption(DeliveryOption.HOME_DELIVERY);
		this.testOrder.setPaymentMethod(PaymentMethod.CASH);
		try {
			this.testOrder.finishOrder();
			fail("finishOrder method should not accept any order cart");
		} catch (EmptyCartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
