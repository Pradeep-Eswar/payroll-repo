package org.compay.employee.payroll.resources;



import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.compay.employee.payroll.model.MonthlySalary;
import org.compay.employee.payroll.service.MonthlySalaryService;


@Path("/monthlypayroll")
public class MonthlySalaryResource {
	
	
	MonthlySalaryService monthlySalaryService=new MonthlySalaryService();
	private static Logger logger= LogManager.getLogger(PayrollResource.class); 	   

	   @GET
	   @Produces({"application/xml", "application/json"}) 
	   public HashMap<YearMonth, MonthlySalary>  getPayroll() { 
	   logger.info("Get Request Resouce for all monthlysalary has been made");	 	   
		    return monthlySalaryService.getAllMonthlySalary(); 
	   }
	 

	    @GET
	    @Path("/{payrollId}")
	    @Produces({"application/xml", "application/json"})
	    public HashMap<YearMonth,MonthlySalary>   test(@PathParam("payrollId") int id) {
	    logger.info("Get Request Resource for retreiving monthly salary for id :" + id +" has been made");	   	
		      return monthlySalaryService.getMonthlySalary(id);
	    }



	    @PUT
	    @Path("/{payrollId}")
	    @Consumes({"application/xml", "application/json"})
	    @Produces({"application/xml", "application/json"})		
	    public Map<Integer, HashMap<YearMonth, MonthlySalary>>  updatePayroll(@PathParam("payrollId") int id, MonthlySalary monthlysalary) {
	    logger.info("put Request Resource for upading monthly salary has been made");  
	    monthlysalary.setId(id);
	       return monthlySalaryService.updateMonthlySalary(monthlysalary);	
		}

	  
	   
	    
	}


	