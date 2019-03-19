package ro.ase.cts.models;

import ro.ase.cts.util.CoffeeType;

public class Coffee {
		private String beverageName;
		private CoffeeType coffeType;
		private double price;
		
		
		public Coffee() {}
		
		public Coffee(String name, CoffeeType type, double price) {
			this.beverageName = name;
			this.coffeType = type;
			this.price = price;
		}

		public String getBeverageName() {
			return beverageName;
		}

		public void setBeverageName(String beverageName) {
			this.beverageName = beverageName;
		}

		public CoffeeType getCoffeType() {
			return coffeType;
		}

		public void setCoffeType(CoffeeType coffeType) {
			this.coffeType = coffeType;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
		
		
}
