package org.compay.employee.payroll.resources;

import java.time.LocalDate;
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
import org.compay.employee.payroll.model.HourlySalary;
import org.compay.employee.payroll.service.HourlySalaryService;

@Path("/hourlypayroll")
public class HourlySalaryResource {
	
HourlySalaryService hourlySalaryService=new HourlySalaryService();
private static Logger logger= LogManager.getLogger(PayrollResource.class); 
   

    @GET
    @Produces({"application/xml", "application/json"}) 
    public HashMap<LocalDate,HourlySalary> getPayroll() { 
    logger.info("Get Request Resouce for all hourly salary has been made");	 	
	    return hourlySalaryService.getAllHourlySalary(); 
    }
 

    @GET
    @Path("/{payrollId}")
    @Produces({"application/xml", "application/json"})
    public HashMap<LocalDate,HourlySalary>  test(@PathParam("payrollId") int id) {
    logger.info("Get Request Resource for retreiving hourly salary for id :" + id +" has been made");	   		 	
	      return hourlySalaryService.getHourlySalary(id);
    }


    @PUT
    @Path("/{payrollId}")
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})		
    public Map<Integer, HashMap<LocalDate,HourlySalary>> updatePayroll(@PathParam("payrollId") int id, HourlySalary hourlysalary) {
    logger.info("put Request Resource for upading hourly salary has been made");  
    	hourlysalary.setId(id);
       return hourlySalaryService.updateHourlySalary(hourlysalary);	
	}

  
   
    
}
