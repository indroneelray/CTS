package ro.ase.cts.tests;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import ro.ase.cts.exceptions.EmployeeTitleNotSupportedException;
import ro.ase.cts.exceptions.InvalidSalaryException;
import ro.ase.cts.model.Employee;
import ro.ase.cts.model.EmployeeTitle;

public class EmployeeTests {
	@Test
	public void testBonusForCEO() {
		Employee emp = new Employee("John Doe", EmployeeTitle.CEO, 10000);
		try {
			assertEquals(2000, emp.computeBonus(), 0.0001);
		} catch (EmployeeTitleNotSupportedException ex) {
			System.out.println(ex.getMessage());
		} catch (InvalidSalaryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBonusForCTO() {
		Employee emp = new Employee("John Doe", EmployeeTitle.CTO, 10000);
		try {
			assertEquals(1500, emp.computeBonus(), 0.0001);
		} catch (EmployeeTitleNotSupportedException ex) {
			System.out.println(ex.getMessage());
		} catch (InvalidSalaryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void testBonusForCFO() {
		Employee emp = new Employee("John Doe", EmployeeTitle.CFO, 10000);
		try {
			assertEquals(1000, emp.computeBonus(), 0.0001);
		} catch (EmployeeTitleNotSupportedException ex) {
			System.out.println(ex.getMessage());
		} catch (InvalidSalaryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void testBonusForMANAGER() {
		Employee emp = new Employee("John Doe", EmployeeTitle.MANAGER, 10000);
		try {
			assertEquals(700, emp.computeBonus(), 0.0001);
		} catch (EmployeeTitleNotSupportedException ex) {
			System.out.println(ex.getMessage());
		} catch (InvalidSalaryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@Test
	public void testBonusForTEAMLEAD() {
		Employee emp = new Employee("John Doe", EmployeeTitle.TEAM_LEAD, 10000);
	try {
		assertEquals(500, emp.computeBonus(), 0.0001);
	} catch (EmployeeTitleNotSupportedException ex) {
		System.out.println(ex.getMessage());
	} catch (InvalidSalaryException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	@Test
	public void testBonusForJUNIOR() {
		Employee emp = new Employee("John Doe", EmployeeTitle.JUNIOR, 10000);
		try {
			assertEquals(1000, emp.computeBonus(), 0.0001);
		} catch (EmployeeTitleNotSupportedException ex) {
			System.out.println(ex.getMessage());
		} catch (InvalidSalaryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void testBonusForSenior() {
		Employee emp = new Employee("John Doe", EmployeeTitle.SENIOR, 10000);
		try {
			emp.computeBonus();
			fail("The program should not work with the specified title");
		} catch (EmployeeTitleNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidSalaryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBonusForNegativeSalary() {
		Employee emp = new Employee("John Doe", EmployeeTitle.CEO, -100);
		try {
			emp.computeBonus();
			fail("The method should not support negative values");
		} catch (EmployeeTitleNotSupportedException | InvalidSalaryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
