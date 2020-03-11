package org.compay.employee.payroll.model;

import java.time.LocalDate;

public class HourlySalary {
	
	private int id;
	private LocalDate salaryDate;
	private int workHours;
	private double hourWages;
	
	public HourlySalary()  {	
	}
	
	
	public HourlySalary(int id, LocalDate salaryDate, int workHours, double hourWages)  {
		this.id=id;
		this.salaryDate=salaryDate;
		this.workHours=workHours;
		this.hourWages=hourWages;
	}

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public LocalDate  getSalaryDate() {
		return salaryDate;
	}
	public void setSalaryDate(LocalDate salaryDate) {
		this.salaryDate = salaryDate;
	}
	

	public int getWorkHours() {
		return workHours;
	}
	public void setWorkHours(int workHours) {
		this.workHours = workHours;
	}
	
	
	public double getHourWages() {
		return hourWages;
	}
	public void setHourWages(double hourWages) {
		this.hourWages = hourWages;
	}

		

}
