package ro.ase.cts.observer;

import java.util.ArrayList;

import ro.ase.cts.utils.makeCofee;

public abstract class CoffeeNotification{
	
	ArrayList<makeCofee> observers = new ArrayList<makeCofee>();
	
	public void addObserver(makeCofee addObserver){
		if(observers!=null)
			observers.add(addObserver);
	}
	
	public void removeObserver(makeCofee removeObserver){
		if(observers!=null)
			observers.remove(removeObserver);	
		}
	
	
	public void notifiyObserver(){
		if(observers!=null)
			for(int i = 0;i<observers.size();i++)
				observers.get(i).makeCofee();
	}
	
}
