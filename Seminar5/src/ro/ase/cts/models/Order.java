package ro.ase.cts.models;

import java.util.ArrayList;
import java.util.List;

import ro.ase.cts.util.PaymentOption;

public class Order {
		private List<Coffee> products;
		private PaymentOption option;
		private boolean applyDiscount;
		
		public Order() {
			this.products = new ArrayList<>();
		}
		
		public void addProduct(Coffee c) {
			this.products.add(c);
		}
		
		public void removeProduct(Coffee coffee) {
			this.products.remove(coffee);
		}
		
		public void displayOrderDetails() {
			for(Coffee c : this.products) {
				System.out.println(c.getBeverageName() + " "
						+ c.getCoffeType() + " "
						+ c.getPrice());
			}
		System.out.println("------------------------------");
		System.out.println("Discount: " + this.applyDiscount);
		System.out.println("Payment method: " + this.option);
		System.out.println("Total: " + this.getOrderPrice());
		}
		
		public void setApplyDiscount(boolean value) {
			this.applyDiscount = value;
		}
		
		public void setPaymentOption(PaymentOption option) {
			this.option = option;
		}
		
		public double getOrderPrice() {
			double totalPrice = 0;
			for(Coffee c : this.products) {
				totalPrice += c.getPrice();
			}
			return totalPrice;
		}
}
