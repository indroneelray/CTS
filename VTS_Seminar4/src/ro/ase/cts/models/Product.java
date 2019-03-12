package ro.ase.cts.models;

import ro.ase.cts.exceptions.InvalidDiscountException;

public class Product {
	
	private String productName;
	private double price;
	
	public Product() {
		
	}
	
	public Product(String name, double price) {
		this.productName  = name;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void applyDiscount(double percentage) throws InvalidDiscountException {
		if(percentage<=0 || percentage>=1)
			throw new InvalidDiscountException("Discount percentage value cannot be 0 or less");
		this.price -= this.price*percentage;
	}
	
}
