package ro.ase.cts.models;

import ro.ase.cts.exceptions.EmptyBookNameException;
import ro.ase.cts.exceptions.InvalidAuthorNameException;
import ro.ase.cts.exceptions.InvalidDiscountException;
import ro.ase.cts.exceptions.InvalidMaximumNumberOfPagesException;
import ro.ase.cts.exceptions.InvalidMinimumNumberOfPagesException;
import ro.ase.cts.exceptions.InvalidPublicationDateExcption;
import ro.ase.cts.utils.Category;

public class Book {
	
	private String bookName;
	private int noPages;
	private float cost;
	private String author;
	private double discountPercentage;
	private int yearOfPublishing;
	private Category category;
	
	
	public static int CURRENT_YEAR = 2019;

//Constructors
	public Book() {}



	
	public Book(String bookName, int noPages, float cost, String author, double discountPercentage, int yearOfPublishing,
		Category category) {
	super();
	this.bookName = bookName;
	this.noPages = noPages;
	this.cost = cost;
	this.author = author;
	this.discountPercentage = discountPercentage;
	this.yearOfPublishing = yearOfPublishing;
	this.category = category;
}





//Access methods
	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) throws EmptyBookNameException {
		if(bookName.isEmpty())
			throw new EmptyBookNameException("Book name cannot be empty");
		this.bookName = bookName;
	}


	public int getNoPages() {
		return noPages;
	}


	public void setNoPages(int noPages) throws InvalidMinimumNumberOfPagesException, InvalidMaximumNumberOfPagesException {
		if(noPages<100)
			throw new InvalidMinimumNumberOfPagesException("Book cannot have less than 100 pages");
		if(noPages>1300)
			throw new InvalidMaximumNumberOfPagesException("Book cannot be more than 1300 pages");
		this.noPages = noPages;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) throws InvalidAuthorNameException {
		if(author.length()<3 || author.length()>20)
			throw new InvalidAuthorNameException("Author name does not match requirements!");
		this.author = author;
	}


	public double getDiscountPercentage() {
		return discountPercentage;
	}


	public void setDiscountPercentage(double discountPercentage) throws InvalidDiscountException {
		if(discountPercentage<=0 || discountPercentage>=1)
			throw new InvalidDiscountException("Discount value does not match criteria");
		this.discountPercentage = discountPercentage;
	}


	public int getYearOfPublishing() {
		return yearOfPublishing;
	}


	public void setYearOfPublishing(int yearOfPublishing) throws InvalidPublicationDateExcption {
		if(yearOfPublishing > 2019)
			throw new InvalidPublicationDateExcption("Publication date cannot be after 2019, duh!");
		
		this.yearOfPublishing = yearOfPublishing;
	}
	
		
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	//Class methods



	public float calculateDiscountedPrice(float cost, double discountPercentage) {
		this.cost -= this.cost*this.discountPercentage;
		
		return this.cost;
	}
	
	
	public int ageOfBook() {
		return CURRENT_YEAR -=  this.yearOfPublishing ;
	}
	
	
}
