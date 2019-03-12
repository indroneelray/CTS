package ro.ase.cts.models;

import java.util.ArrayList;
import java.util.List;

import ro.ase.cts.exceptions.EmptyCartException;
import ro.ase.cts.utils.DeliveryOption;
import ro.ase.cts.utils.PaymentMethod;

public class Order {
	private List<Product> orderCart;
	private PaymentMethod paymentMethod;
	private DeliveryOption deliveryOption;
	
	public Order() {
		this.orderCart = new ArrayList<>();
	}
	
	public List<Product> getOrderBasket(){
		return this.orderCart;
	}
	
	public void addProductToCart(Product p) {
		this.orderCart.add(p);
	}

	public void setPaymentMethod(PaymentMethod method) {
		this.paymentMethod = method;
	}
	
	public void setDeliveryOption(DeliveryOption option) {
		this.deliveryOption = option;
	}
	
	public double finishOrder() throws EmptyCartException {
		if(this.orderCart.isEmpty())
			throw new EmptyCartException("Please add atleadt one item to your cart to proceed to the payments section");
		double totalPrice = 0;
		for(Product p : this.orderCart) {
			totalPrice += p.getPrice();
		}
		
		System.out.println("Your order contains " 
	+ this.orderCart.size() + " products,"
			+ " with Payment method: " + this.paymentMethod 
				+ " and Delivery option: " + this.deliveryOption);
	return totalPrice;	
	}
}
