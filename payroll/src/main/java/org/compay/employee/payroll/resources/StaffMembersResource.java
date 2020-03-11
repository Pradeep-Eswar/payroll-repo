package org.compay.employee.payroll.resources;


import java.util.List;
import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.compay.employee.payroll.model.StaffMembers;
import org.compay.employee.payroll.service.StaffMembersService;



@Path("/staffmembers")
	public class StaffMembersResource {

		StaffMembersService staffMembersservice = new StaffMembersService();
		  
	    private static Logger logger= LogManager.getLogger(PayrollResource.class); 	
		
		 @GET
		 @Produces({"application/xml", "application/json"}) 
		 public TreeMap<Integer, String> getAllStaffMembers() { 
		 logger.info("Get Request Resouce for all staffmember has been made");	 
		         return staffMembersservice.getAllStaffMembers(); 
		 }
		 
		 
		 @GET
		 @Path("/sortstaff")
		 @Produces({"application/xml", "application/json"}) 
		 public List<String> getAllStaffMembersSort() { 
	     logger.info("Get Request Resouce for sorting all staffmember has been made");			 
		    return staffMembersservice.getAllStaffMembersSort(); 
		 }
		 
		 
			
		 @GET
	 	 @Path("/{staffMemberId}")
	     @Produces({"application/xml", "application/json"})
	     public String getStaffMember(@PathParam("staffMemberId") int id) {	
		 logger.info("Get Request Resource for retreiving staffmember for id :" + id +" has been made");	 
	     	return staffMembersservice.getStaffMember(id);
	 	 }
		 
	     
		 @POST
		 @Consumes({"application/xml", "application/json"})
		 @Produces({"application/xml", "application/json"})
		 public TreeMap<Integer, String> addStaffMember(StaffMembers staffmembers) {
		 logger.info("post Request Resource for adding staffmember has been made");   	 
		        return staffMembersservice.addStaffMember(staffmembers);
		 }
		
	    
	     @PUT
	     @Path("/{staffMemberId}")
	     @Consumes({"application/xml", "application/json"})
	     @Produces({"application/xml", "application/json"})		
	     public TreeMap<Integer, String> updateStaffMember(@PathParam("staffMemberId") int id, StaffMembers staffmembers) {
	     logger.info("put Request Resource for updating staffmember for id :" + id + " has been made");  	  	
	     staffmembers.setId(id);	 
	    	 return staffMembersservice.updateStaffmember(id,staffmembers);
		 }
	    
	     @DELETE
	     @Path("/{staffMemberId}")
	     @Produces({"application/xml", "application/json"})		
	     public TreeMap<Integer, String> removeStaffMember(@PathParam("staffMemberId") int id) {
	     logger.info("Delete Request Resource for deleting staffmember for id :" + id + " has been made");	   	 
		    return staffMembersservice.removeStaffMember(id);	
		 }
	    
		    	   

}
