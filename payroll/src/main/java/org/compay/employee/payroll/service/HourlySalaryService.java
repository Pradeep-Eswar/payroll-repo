package org.compay.employee.payroll.service;

import java.sql.Date;
import java.time.LocalDate;


import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.compay.employee.payroll.database.DatabaseClass;
import org.compay.employee.payroll.model.HourlySalary;
import org.compay.employee.payroll.model.Payroll;
import org.compay.employee.payroll.resources.PayrollResource;


public class HourlySalaryService {
	
	
	public HourlySalaryService(){
	}
	
	private static Logger logger= LogManager.getLogger(PayrollResource.class);
	private Map<Integer, HashMap<LocalDate,HourlySalary>> hourlywagesdb = DatabaseClass.getHourlyWagesDB();
	private static Map<Integer, Payroll> payrolls = DatabaseClass.getPayrolls();
	
	
	public Map<Integer, HashMap<LocalDate,HourlySalary>> updateHourlySalary(HourlySalary hourlysalary ) {
			
		int key=hourlysalary.getId();		
		LocalDate innerkey=hourlysalary.getSalaryDate();
		hourlywagesdb.putIfAbsent(key, new HashMap<LocalDate,HourlySalary>());
     	hourlywagesdb.get(key).put(innerkey,hourlysalary);
	
		return hourlywagesdb;		
	}
	
	
	 public Payroll getPayrollHourlySalary(int id, Date from, Date to) {
		
     logger.info("Hourly Service for retreiving payroll "+ id + " with date " + from + "-" + to + "has been made");
	 
		HashMap<LocalDate,HourlySalary> innerhs = new HashMap<LocalDate,HourlySalary>();	
		innerhs=hourlywagesdb.get(id);
		double amount=0;
		
    	LocalDate fromLocal = from.toLocalDate();
    	LocalDate toLocal = to.toLocalDate();
    	
    	System.out.println("from :"+ fromLocal);
    	System.out.println("to :"+ toLocal);	
		
		
		for (HashMap.Entry<LocalDate,HourlySalary> entry : innerhs.entrySet()) {
			
 		if(entry.getKey().isAfter(fromLocal) && entry.getKey().isBefore(toLocal) || entry.getKey().isEqual(fromLocal) || entry.getKey().isEqual(toLocal))
 		     {	
 		      LocalDate localkey = entry.getKey();
 		      System.out.println("LocalDate :"+ localkey );
			  HourlySalary hs=entry.getValue();
			  double wages= hs.getWorkHours() * hs.getHourWages();
			  amount = amount+wages;
			  System.out.println("amount :"+ amount);
			  
		     }
		  }
		    
		     Payroll payroll = payrolls.get(id);   
		     payroll.setAmount(amount);
		     payroll.setPeriod(from.toString() + " to " + to.toString());     
        	
	      return payroll; 
	    }
	
	
	
	
	public HashMap<LocalDate,HourlySalary> getAllHourlySalary(){
    logger.info("Hourly Service for retreiving all payroll has been made");		
	    return new HashMap<LocalDate,HourlySalary> (); 
	}
	
	
	public HashMap<LocalDate,HourlySalary> getHourlySalary (int id) {
	logger.info("Hourly Service for retreiving payroll with id :" + id+" has been made");			
	    return hourlywagesdb.get(id);
	}

	
	
}
