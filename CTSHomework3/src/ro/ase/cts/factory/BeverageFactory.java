package ro.ase.cts.factory;

public class BeverageFactory {

	public static BeverageInterface createDrink(BeverageTypes bev, String name){
		
		//referinta obiect generat
		BeverageInterface drink = null;
		
		//verificare tip document solicitat
		switch(bev){
		case SHAKE:
			drink = new Shake();
			drink.setName("Orange Juice");
			drink.print();
			break;
		case JUICE:
			drink = new Shake();
			drink.setName("Orange Juice");
			drink.print();
			break;
		}
		
		return drink;
	}
}
