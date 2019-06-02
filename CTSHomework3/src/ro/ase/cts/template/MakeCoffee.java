package ro.ase.cts.template;

import ro.ase.cts.utils.makeCofee;

public abstract class MakeCoffee implements makeCofee{
		
	protected String coffeeName;
	protected float cost;
	public abstract void print();
	public abstract void boilWater();
	public abstract void addCoffeeBeans();
	public abstract void stirCoffee();
	public abstract void addSugar();
	public abstract void pourInCup();
	public abstract void serve();;
	
	public final void makeCoffee () {
		boilWater();
		addCoffeeBeans();
		stirCoffee();
		addSugar();
		pourInCup();
		serve();	
	}
	
	
}
