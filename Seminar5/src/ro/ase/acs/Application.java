package ro.ase.acs;

import ro.ase.cts.models.Coffee;
import ro.ase.cts.models.Order;
import ro.ase.cts.util.CoffeeType;
import ro.ase.cts.util.PaymentOption;

public class Application {
	public static void main(String[] args) {
		Coffee c1 = new Coffee("Cappucino", CoffeeType.ARABIC, 16.5);
		Coffee c2 = new Coffee("Espresso", CoffeeType.ETHIOPIA, 13);
		
		Order order = new Order();
		order.addProduct(c1);
		order.addProduct(c2);
		order.setPaymentOption(PaymentOption.CASH);
		order.displayOrderDetails();

	}

}
