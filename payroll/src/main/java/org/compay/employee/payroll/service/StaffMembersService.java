package org.compay.employee.payroll.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.compay.employee.payroll.database.DatabaseClass;
import org.compay.employee.payroll.model.Payroll;
import org.compay.employee.payroll.model.StaffMembers;



public class StaffMembersService {

private static Logger logger= LogManager.getLogger(StaffMembersService.class);	
private TreeMap<Integer, String> staffmembersdb =  DatabaseClass.getStaffMembers();
private Map<Integer,Payroll> payrollsdb = DatabaseClass.getPayrolls();

StaffMembers staffmember = new StaffMembers();
Payroll payroll = new Payroll();

	public StaffMembersService() {
	}
	
	public TreeMap<Integer, String> getAllStaffMembers() {
	logger.info("Staff Member Service for retreiving all staffmember has been made");	
		return staffmembersdb; 
	}
	
	public String getStaffMember(Integer id) {
	logger.info("Staff Member Service for retreiving staffmember :"+ id+" has been made");	
		return staffmembersdb.get(id);
	}
	
	
	public List<String> getAllStaffMembersSort() {
	logger.info("Staff Member Service for sorting all staffmember has been made");	
	    
	   List<String> list = new ArrayList<String>(staffmembersdb.values());
	   String a,b;
     
	   for (int i= 0; i< list.size() ; i++){
	       for(int j=0; j< list.size() - i-1; j++){
             
	             a = list.get(j).toUpperCase().trim();
	             b = list.get(j+1).toUpperCase().trim();

	             if ( a.compareTo(b) > 0)
	             {  
	                 list.set(j+1, a);
	                 list.set(j, b);

	             } 
	        }	        
	    }
	    return list;	    
	}
	

	public TreeMap<Integer, String> addStaffMember(StaffMembers staffmembers) {
    logger.info("Staff Member Service for adding staff member has been made");			 
		 int id=staffmembersdb.size()+1;
         staffmember.setId(id);
         System.out.println("staffmembersID :" + id);
         
         String empname= staffmembers.getName();
         staffmember.setName(empname);
         System.out.println("staffmembersName :" + empname);
		 
         staffmembersdb.put(id,empname); 
              
         payroll.setStaffmember(staffmember);
         payrollsdb.put(id, payroll);

         System.out.println("staffmembersdb :" + staffmembersdb);
         System.out.println("payrolls :" + payrollsdb);
         
		 return staffmembersdb;
	}
	
	
	public TreeMap<Integer, String> updateStaffmember(int id, StaffMembers staffmembers) {
	logger.info("Staff Member Service for updating staff member has been made");		
		if (id <= 0) {
			return null;
		}
		
		staffmembersdb.put(id,staffmembers.getName());
		
        payroll.setStaffmember(staffmembers);
        payrollsdb.put(id, payroll);
		
		return staffmembersdb;
	}
	
	
	public TreeMap<Integer, String> removeStaffMember(int id) {	
	logger.info("Staff Member Service for removing payroll has been made");		
		 staffmembersdb.remove(id);
		 payrollsdb.remove(id);
 
		 return staffmembersdb;
	}


}
