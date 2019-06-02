package ro.ase.cts.decorator;

import ro.ase.cts.template.MakeCoffee;

public abstract class CoffeeDecorator extends MakeCoffee {
	
	protected final MakeCoffee coffee;
	
	
	public CoffeeDecorator(MakeCoffee coffee) {
		this.coffee = coffee;
	}
	
	@Override
	public void print() {
		System.out.println("added ");
	}
	
}
