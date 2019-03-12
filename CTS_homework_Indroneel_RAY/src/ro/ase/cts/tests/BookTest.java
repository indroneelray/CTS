package ro.ase.cts.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.ase.cts.exceptions.EmptyBookNameException;
import ro.ase.cts.exceptions.InvalidAuthorNameException;
import ro.ase.cts.exceptions.InvalidDiscountException;
import ro.ase.cts.exceptions.InvalidMaximumNumberOfPagesException;
import ro.ase.cts.exceptions.InvalidMinimumNumberOfPagesException;
import ro.ase.cts.exceptions.InvalidPublicationDateExcption;
import ro.ase.cts.models.Book;

public class BookTest {

	Book book;
	
	
	@Before
	public void setUp() {
		this.book = new Book();
	}
	
	@Test
	public void testForInvalidAuthorName() {
		try {
			this.book.setAuthor("he");
			fail("Author naem cannot be less than three letters or more than 20");

		} catch (InvalidAuthorNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testInvalidDiscountPercentage() {
		try {
			this.book.setDiscountPercentage(0);
			fail("Discount percentage cannot be less than 0 or more than 1");
		} catch (InvalidDiscountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void testCostAfterDiscountCalculation() {
		this.book.setCost(100);
		try {
			this.book.setDiscountPercentage(0.3);
			assertEquals(book.calculateDiscountedPrice(book.getCost(), book.getDiscountPercentage()),
					70, 0.001);
		} catch (InvalidDiscountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testEmptyBookName() {
		try {
			this.book.setBookName("");
			assertTrue(this.book.getBookName().isEmpty());
		} catch (EmptyBookNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testMinimumNumberOfPages() {
		try {
			this.book.setNoPages(3);
			fail("Book cannot contain less that 100 pages");
		} catch (InvalidMinimumNumberOfPagesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidMaximumNumberOfPagesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testMaxNumberofPages() {
		try {
			this.book.setNoPages(10000);
			fail("Book cannot contain more than 1300 pages");
		} catch (InvalidMinimumNumberOfPagesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidMaximumNumberOfPagesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void testAgeOfBookCalculation() {
		try {
			this.book.setYearOfPublishing(1990);
		} catch (InvalidPublicationDateExcption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(this.book.ageOfBook(), 29, 0.01);
	}
	
	@Test
	public void testInvalidDateOfPublishing() {
		try {
			this.book.setYearOfPublishing(2020);
			fail("Book cannot have a publication date beyond the current year");
		} catch (InvalidPublicationDateExcption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
