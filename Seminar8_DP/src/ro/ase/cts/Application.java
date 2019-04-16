package ro.ase.cts;

import ro.ase.cts.exceptions.DatabaseException;
import ro.ase.cts.helpers.DatabaseConnection;
import ro.ase.cts.helpers.UserBuilder;
import ro.ase.cts.models.User;

public class Application {

	public static void main(String[] args) {
		User user1 = new UserBuilder("John Doe", "test@test.com", "password1234")
				.withOptionalCity("Bucharest")
				.withOptionalAddress("Calea Dorobanti")
				.withOptionalAge(21)
				.withOptionalIsPasswordExpired(false)
				.build();
		
		User user2 = new UserBuilder("Jane Doe", "test2@testes.com", "Passwordabcd")
				.withOptionalAge(25)
				.withOptionalCity("Bucharest")
				.build();
	
		
		try {
			DatabaseConnection connection = DatabaseConnection.getInstance();
			connection.connect();
			connection.addUser(user1);
			//connection.close();
			//connection.printUsers();
			DatabaseConnection connection2 = DatabaseConnection.getInstance();
			connection2.addUser(user2);
			connection2.printUsers();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
