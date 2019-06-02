package ro.ase.cts.factory;

import ro.ase.cts.template.MakeCoffee;

public abstract class BeverageInterface extends MakeCoffee {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	};
	
	
	public abstract void print();
}
