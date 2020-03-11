package org.compay.employee.payroll.model;

     public class Payroll { 
    	 
     private StaffMembers staffmember;	 
	 private String salaryType;
	 private String period;
	 private double amount;
	 
	 
	 
	public Payroll()  {	
	}
	 
	public Payroll( StaffMembers staffmember, String salaryType, String period, double amount)  {
		this.staffmember=staffmember;
		this.salaryType=salaryType;
		this.period= period;
		this.amount= amount;
		
	}

	
	public StaffMembers getStaffmember() {
		return staffmember;
	}

	public void setStaffmember(StaffMembers staffmember) {
		this.staffmember = staffmember;
	}


	public String getSalaryType() {
		return salaryType;
	}

	public void setSalaryType(String salaryType) {
		this.salaryType = salaryType;
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
	

}
