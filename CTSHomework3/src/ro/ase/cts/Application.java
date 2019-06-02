package ro.ase.cts;

import ro.ase.cts.factory.BeverageFactory;
import ro.ase.cts.factory.BeverageInterface;
import ro.ase.cts.factory.BeverageTypes;
import ro.ase.cts.models.Coffee;
import ro.ase.cts.observer.CofeeHandler;
import ro.ase.cts.observer.CoffeeNotifier;

public class Application {
	public static void main(String[] args) {
			Coffee coffee = new Coffee();
			//TEMPLATE
			coffee.makeCoffee();
			
			
			//OBSERVER
			CoffeeNotifier notifier = new CoffeeNotifier();
			
			
			//FACTORY
			BeverageFactory drinksFactory = new BeverageFactory();
			BeverageInterface orangeJuice = drinksFactory.createDrink(BeverageTypes.JUICE, "Orange Juice");
			
			//DECORATOR
			
			
	}
}
