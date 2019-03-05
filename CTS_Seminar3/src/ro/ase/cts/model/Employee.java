package ro.ase.cts.model;

import ro.ase.cts.exceptions.EmployeeTitleNotSupportedException;
import ro.ase.cts.exceptions.InvalidSalaryException;

public class Employee {
	private String completeName;
	private EmployeeTitle title;
	private double salary;
	
	public Employee() {}
	
	public Employee(String completeName, EmployeeTitle title, double salary ) {
			this.completeName = completeName;
			this.title = title;
			this.salary = salary;
	}

	public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public EmployeeTitle getTitle() {
		return title;
	}

	public void setTitle(EmployeeTitle title) {
		this.title = title;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double computeBonus() throws EmployeeTitleNotSupportedException, InvalidSalaryException {
		
		double bonus = 0;
		if(salary>0) {
		switch(this.title) {
		case CEO: bonus = this.salary*0.2;
			break;
		case CTO: bonus = this.salary*0.15;
			break;
		case CFO: bonus = this.salary*0.1;
			break; 
		case MANAGER: bonus = this.salary*0.07;
			break;
		case TEAM_LEAD: bonus = this.salary*0.05;
			break;
		case JUNIOR: bonus = this.salary*0.1;
			break;
		default:
			throw new EmployeeTitleNotSupportedException(
					"Employee Title logic not implemented for " + this.title.toString());
		}
		return bonus;
		}
		else {
			throw new InvalidSalaryException("SAlary cannot be negative");
		}
	}
}
