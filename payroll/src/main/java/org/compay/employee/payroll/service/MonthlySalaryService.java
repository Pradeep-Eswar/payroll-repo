package org.compay.employee.payroll.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.compay.employee.payroll.database.DatabaseClass;
import org.compay.employee.payroll.model.MonthlySalary;
import org.compay.employee.payroll.model.Payroll;
import org.compay.employee.payroll.resources.PayrollResource;

public class MonthlySalaryService {
	
	
	public MonthlySalaryService(){
	}
	
	private static Logger logger= LogManager.getLogger(PayrollResource.class);
	private Map<Integer, HashMap<YearMonth, MonthlySalary>>  monthlywagesdb = DatabaseClass.getMonthlyWagesDB();
	private static Map<Integer, Payroll> payrolls = DatabaseClass.getPayrolls();

	public Map<Integer, HashMap<YearMonth,MonthlySalary>>  updateMonthlySalary(MonthlySalary monthlysalary ) {
		
		if (monthlysalary.getId() <= 0) {
			return null;
		}
		
        int key=monthlysalary.getId();
		YearMonth yearmonth = YearMonth.of(monthlysalary.getSalaryYear(),monthlysalary.getSalaryMonth());
		 
		YearMonth innerkey=yearmonth;	
	
		monthlywagesdb.putIfAbsent(key, new HashMap<YearMonth,MonthlySalary>());
		monthlywagesdb.get(key).put(innerkey,monthlysalary);
		return monthlywagesdb;
	}
	
	
	
      public Payroll getPayrollMonthlySalary(int id, Date from, Date to) {
      logger.info("Monthly Service for retreiving payroll "+ id + " with date " + from + "-" + to + "has been made");
    	  
		
		HashMap<YearMonth,MonthlySalary> innerhs = new HashMap<YearMonth,MonthlySalary>();	
		innerhs=monthlywagesdb.get(id);
		
		double amount=0;
		
		LocalDate fromLocal = from.toLocalDate();
		LocalDate toLocal = to.toLocalDate();
		
		YearMonth fromYearMonth = YearMonth.from(fromLocal);
		YearMonth toYearMonth = YearMonth.from(toLocal);
		
		for (HashMap.Entry<YearMonth,MonthlySalary> entry : innerhs.entrySet()) {
			
		   if(entry.getKey().isAfter(fromYearMonth) &&  entry.getKey().isBefore(toYearMonth) || entry.getKey().equals(fromYearMonth) || entry.getKey().equals(toYearMonth))
		   {
			  MonthlySalary ms= entry.getValue();
			  amount=ms.getMonthWages();		  		
		   }
	
		  }
		
	     Payroll payroll = payrolls.get(id);
	     
	     payroll.setAmount(amount);
	     payroll.setPeriod(from.toString() + " to " + to.toString());
	     
	     return payroll; 
	     
	    }
	

	
	public HashMap<YearMonth, MonthlySalary> getAllMonthlySalary(){
    logger.info("Monthly Service for retreiving all payroll has been made");	
		   return new HashMap<YearMonth,MonthlySalary> (); 
	}
	
	
	public HashMap<YearMonth, MonthlySalary> getMonthlySalary (int id) {
	logger.info("Monthly Service for retreiving payroll :"+ id+" has been made");		
		return monthlywagesdb.get(id);
	}
	
	
	
	
	

}
