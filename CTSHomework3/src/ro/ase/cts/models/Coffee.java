package ro.ase.cts.models;

import java.util.ArrayList;

import ro.ase.cts.observer.CofeeHandler;
import ro.ase.cts.observer.CoffeeNotifier;
import ro.ase.cts.template.MakeCoffee;

public class Coffee extends MakeCoffee{
	
		
		private double volume;
		private ArrayList<String> ingredients;
		private boolean complete = false;
		
		
		
		public String getCoffeeName() {
			return coffeeName;
		}
		public void setCoffeeName(String coffeeName) {
			this.coffeeName = coffeeName;
		}
		public float getCost() {
			return cost;
		}
		public void setCost(float cost) {
			this.cost = cost;
		}
		public double getVolume() {
			return volume;
		}
		public void setVolume(double volume) {
			this.volume = volume;
		}
		public ArrayList<String> getIngredients() {
			return ingredients;
		}
		public void setIngredients(ArrayList<String> ingredients) {
			this.ingredients = ingredients;
		}
		public Coffee() {
			super();
		}
		public Coffee(String coffeeName, float cost, double volume) {
			super();
			this.coffeeName = coffeeName;
			this.cost = cost;
			this.volume = volume;
			this.ingredients.add("Water");
		}
		
		
		@Override
		public void boilWater() {
			// TODO Auto-generated method stub
			System.out.println("boiling water...");
		}
		@Override
		public void addCoffeeBeans() {
			// TODO Auto-generated method stub
			System.out.println("adding coffee beans...");
			
		}
		@Override
		public void stirCoffee() {
			// TODO Auto-generated method stub
			System.out.println("stirring coffee solution...");
			
		}
		@Override
		public void addSugar() {
			// TODO Auto-generated method stub
			System.out.println("adding sugar...");
			
		}
		@Override
		public void pourInCup() {
			// TODO Auto-generated method stub
			System.out.println("pouring in cup...");
			
		}
		@Override
		public void serve() {
			// TODO Auto-generated method stub
			System.out.println("Here is your coffee!");
			this.complete = true;
			if(this.complete) {
				final CofeeHandler notify = new CofeeHandler();
				final CoffeeNotifier notifier = new CoffeeNotifier();
				notifier.addObserver(new CofeeHandler() {
					@Override
					public void makeCofee() {
						// TODO Auto-generated method stub
						System.out.println("Please collect your drink...");
					}
				});
				notifier.done();
				
			}
			
		}
		@Override
		public void makeCofee() {
			
		}
		@Override
		public void print() {
			// TODO Auto-generated method stub
			
		}
		
		
		
}
