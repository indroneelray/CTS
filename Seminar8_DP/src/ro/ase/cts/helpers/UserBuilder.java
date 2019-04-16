package ro.ase.cts.helpers;

import ro.ase.cts.models.User;

public class UserBuilder implements GenericBuilder{

	private String completeName;
	private String email;
	private String password;
	private String city;
	private String address;
	private String telephone;
	private int age;
	private boolean isPasswordExpired;
	
	
	public UserBuilder(String name, String email, String pass) {
		this.completeName = name;
		this.email = email;
		this.password = pass;
	}
	
	public UserBuilder withOptionalCity(String city) {
		this.city = city;
		return this;
	}
	
	public UserBuilder withOptionalAddress(String address) {
		this.address = address;
		return this;
	}
	
	
	public UserBuilder withOptionalTelephone(String telephone) {
		this.telephone = telephone;
		return this;
	}
	
	
	public UserBuilder withOptionalAge(int age) {
		this.age = age;
		return this;
	}
	
	public UserBuilder withOptionalIsPasswordExpired(boolean isPasswordExp) {
		this.isPasswordExpired = isPasswordExpired;
		return this;
	}
	
	
	public User build() {
		User user = new User();
		user.setCompleteName(this.completeName);
		user.setPassword(this.password);
		user.setEmail(this.email);
		user.setAddress(this.address);
		user.setCity(this.city);
		user.setTelephone(this.telephone);
		user.setIsPasswordExpired(this.isPasswordExpired);
		user.setAge(this.age);
		return user;
	}
				
}
