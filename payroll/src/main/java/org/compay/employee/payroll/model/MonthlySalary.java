package org.compay.employee.payroll.model;


public class MonthlySalary {
	
	private int id;
	private int salaryMonth;
	private int salaryYear;
	private double monthWages;

	

	public MonthlySalary()  {	
	}
	
	
	public MonthlySalary(int id, int salaryMonth, int salaryYear, double monthWages)  {
		this.id=id;
		this.salaryMonth=salaryMonth;
		this.salaryYear=salaryYear;
		this.monthWages=monthWages;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalaryMonth() {
		return salaryMonth;
	}
	public void setSalaryMonth(int salaryMonth) {
		this.salaryMonth = salaryMonth;
	}
	public double getMonthWages() {
		return monthWages;
	}
	public void setMonthWages(double monthWages) {
		this.monthWages = monthWages;
	}
	
	public int getSalaryYear() {
		return salaryYear;
	}

	public void setSalaryYear(int salaryYear) {
		this.salaryYear = salaryYear;
	}

}
