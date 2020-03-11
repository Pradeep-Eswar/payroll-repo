package org.compay.employee.payroll.service;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.compay.employee.payroll.database.DatabaseClass;
import org.compay.employee.payroll.model.Payroll;
import org.compay.employee.payroll.model.StaffMembers;
import org.compay.employee.payroll.resources.PayrollResource;

public class PayrollService {
	
	private Map<Integer,Payroll> payrolls = DatabaseClass.getPayrolls();
	private static Logger logger= LogManager.getLogger(PayrollResource.class);
	
	StaffMembers staffmember= new StaffMembers();
	HourlySalaryService hourlySalaryService=new HourlySalaryService();
	MonthlySalaryService monthlySalaryService=new MonthlySalaryService();
	
	public PayrollService() {
	}
	
	
	public  List<Payroll> getAllPayrolls(){
	logger.info("Payroll Service for retreiving all payroll has been made");	
	    return new ArrayList<Payroll>(payrolls.values()); 
	}
	
	
	public List<Payroll> getAllPayrollsForSort() {
	logger.info("Payroll Service for sorting all payroll has been made");		
		List<Payroll> list = new ArrayList<Payroll>(payrolls.values());
		
		String a,b;
	    Payroll c,d;

	    for (int i= 0; i< list.size() ; i++){
	        for(int j=0; j< list.size() - i-1; j++){

	             a = list.get(j).getStaffmember().getName().toUpperCase().trim();
	             b = list.get(j+1).getStaffmember().getName().toUpperCase().trim();

	             c = list.get(j);
	             d = list.get(j+1);

	             if ( a.compareTo(b) > 0)  {  
	                 list.set(j+1, c);
	                 list.set(j, d);

	             } 
	        }
		    	
	    }
	    
	    return list;
	}
	
	
	
	  public Payroll getAllPayrollsPaginated(int id, Date from, Date to) {
	  logger.info("Payroll Service for retreiving payroll "+ id + " with date " + from + "-" + to + "has been made");		  
		  
		  Payroll p= payrolls.get(id);
		  Payroll salary=new Payroll();
		  
		  if(p.getSalaryType().equalsIgnoreCase("HourlySalary"))
          {
			  salary = hourlySalaryService.getPayrollHourlySalary(id,from,to);
          }		 
	  
		  
		  if(p.getSalaryType().equalsIgnoreCase("MonthlySalary"))
          {
			  salary = monthlySalaryService.getPayrollMonthlySalary(id,from,to);
          }		
		  
		  return salary;
	  
	  }	  
          

	public Payroll getPayroll(int id) {
		logger.info("Payroll Service for retreiving payroll "+ id + "has been made");		
		return payrolls.get(id);		
	}
	
	
	public Payroll addPayroll(Payroll payroll) {
	logger.info("Payroll Service for adding payroll has been made");	
	    staffmember.setId(payrolls.size()+1);	
		payroll.setStaffmember(staffmember);
		payrolls.put(payroll.getStaffmember().getId(),payroll);
		return payroll;
	}
	
	
	public Payroll updatePayroll(Payroll payroll) {
	logger.info("Payroll Service for updating payroll has been made");	
		
		if (payroll.getStaffmember().getId() <= 0) {
			return null;
		}
	    payrolls.put(payroll.getStaffmember().getId(), payroll);
		return payroll;
	}
	
	
	public Payroll removePayroll(int id) {
    logger.info("Payroll Service for removing payroll has been made");		
		return payrolls.remove(id);
	}

	
}
	

	
	
	
