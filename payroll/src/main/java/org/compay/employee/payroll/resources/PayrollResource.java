package org.compay.employee.payroll.resources;




import java.sql.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.compay.employee.payroll.model.Payroll;
import org.compay.employee.payroll.model.StaffMembers;
import org.compay.employee.payroll.service.PayrollService;





@Path("/mypayroll")
public class PayrollResource {	
	
       PayrollService payrollService=new PayrollService();	
       StaffMembers staffmember= new StaffMembers();  
       
       private static Logger logger= LogManager.getLogger(PayrollResource.class);
       
	   @GET
	   @Produces({"application/xml", "application/json"}) 
	   public List<Payroll>  getAllPayroll() { 
	   logger.info("Get Request Resouce for all payroll has been made");
		   return payrollService.getAllPayrolls(); 
	   }
	 
    
	   @GET
	   @Path("/sortpayroll")
	   @Produces({"application/xml", "application/json"}) 
	   public List<Payroll> getAllPayrollsSort() { 
	   logger.info("Get Request Resource for sorting all payroll has been made");
		  return payrollService.getAllPayrollsForSort(); 
	   }
	   
     
	   @GET
	   @Path("/{payrollId}")
	   @Produces({"application/xml", "application/json"}) 
	   public  Payroll getPayroll(@PathParam("payrollId") int id, @QueryParam("from") Date from, @QueryParam("to") Date to ) {   
	   logger.info("Get Request Resource for retreiving payroll for id :" + id +" has been made");
		   return payrollService.getAllPayrollsPaginated(id,from,to);
	   }
	 
      
       @POST
       @Consumes({"application/xml", "application/json"})
       @Produces({"application/xml", "application/json"})
       public Payroll addPayroll(Payroll payroll) {
       logger.info("post Request Resource for adding payroll has been made");   
          return payrollService.addPayroll(payroll);
       }
    
     
       @PUT
       @Path("/{payrollId}")
       @Consumes({"application/xml", "application/json"})
       @Produces({"application/xml", "application/json"})		
       public Payroll updatePayroll(@PathParam("payrollId") int id, Payroll payroll) {	
       staffmember.setId(id);	
       payroll.setStaffmember(staffmember);
       logger.info("put Request Resource for updating payroll for id :" + id + " has been made"); 
	       return payrollService.updatePayroll(payroll);	
	   }
    
    
       @DELETE
       @Path("/{payrollId}")
       @Produces({"application/xml", "application/json"})		
       public Payroll removePayroll(@PathParam("payrollId") int id) {
       logger.info("Delete Request Resource for deleting payroll for id :" + id + " has been made");	   
	       return payrollService.removePayroll(id);	
       }
  
   
    
}
