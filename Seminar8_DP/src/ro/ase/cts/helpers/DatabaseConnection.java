package ro.ase.cts.helpers;

import java.util.ArrayList;
import java.util.List;

import ro.ase.cts.exceptions.DatabaseException;
import ro.ase.cts.models.User;

			//SINGLETON

public class DatabaseConnection {
	private static DatabaseConnection dbInstance;
	private boolean isConnectionOpen;
	private List<User> users;
	
	private DatabaseConnection() {
		this.users = new ArrayList<>();
	}
	
	public static DatabaseConnection getInstance() {
		if(dbInstance == null)
		dbInstance = new DatabaseConnection();
		return dbInstance;
	}
	
	public void connect() throws DatabaseException {
		if(this.isConnectionOpen)
			throw new DatabaseException("Connection already open..");
		this.isConnectionOpen = true;
		System.out.println("Succesfully connected to database!");
	}
	
	public void close() throws DatabaseException {
		if(!this.isConnectionOpen)
			throw new DatabaseException("Connection already closed...");
		this.isConnectionOpen = false;
		System.out.println("Succesfully closed  connection!");		
	}
	
	public void addUser(User user) throws DatabaseException {
		if(!this.isConnectionOpen)
			throw new DatabaseException("No connection to database to add user");
		this.users.add(user);
	}
	
	public void printUsers() {
		for(User u : this.users) {
			System.out.println(u.getCompleteName() + " " + u.getEmail() + ".");
		}
	}
}
