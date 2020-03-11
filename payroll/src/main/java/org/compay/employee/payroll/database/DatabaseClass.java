package org.compay.employee.payroll.database;


import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.compay.employee.payroll.model.HourlySalary;
import org.compay.employee.payroll.model.MonthlySalary;
import org.compay.employee.payroll.model.Payroll;
import org.compay.employee.payroll.model.StaffMembers;

public class DatabaseClass {
	

		private static Map<Integer, Payroll> payrolls = new HashMap<>();
		
		private static TreeMap<Integer, String> staffmembersdb = new TreeMap<>();
		
		private static Map<Integer, HashMap<LocalDate,HourlySalary>> hourlywagesdb = new HashMap<>();
		
		private static Map<Integer, HashMap<YearMonth,MonthlySalary>> monthlywagesdb = new HashMap<>();
		
		
		

		static{
			    staffmembersdb.put(1,"Employee1");
		        payrolls.put(1, new Payroll(new StaffMembers(1, "Employee1"), "HourlySalary", "", 0));
		        		       
		        staffmembersdb.put(2,"Employee2");
		        payrolls.put(2, new Payroll(new StaffMembers(2, "Employee2"), "HourlySalary", "",0));
		        
		        staffmembersdb.put(3,"Employee3");
		        payrolls.put(3, new Payroll(new StaffMembers(3, "Employee3"), "MonthlySalary","",0));
		                      
		        staffmembersdb.put(4,"Employee4");
		        payrolls.put(4, new Payroll(new StaffMembers(4, "Employee4"), "MonthlySalary","",0));
		        
		        //HashMap<YearMonth,MonthlySalary> monthlysalary = new HashMap<>();
		        //monthlywagesdb.put(4,monthlysalary.put(YearMonth.now(), new MonthlySalary(1,2,2020,1300)));
		        
		        // monthlywagesdb.put(1, new MonthlySalary(1, Month.of(3),1300));
		        // profiles.put("koushik", new Profile(1, "koushik", "Koushik", "Kothagal"));
		       } 
		
		
		public static Map<Integer, Payroll> getPayrolls() {
			return payrolls;
		}
		
		public static TreeMap<Integer, String> getStaffMembers() {
			return  staffmembersdb;
		}

		public static Map<Integer, HashMap<LocalDate, HourlySalary>> getHourlyWagesDB() {
			return hourlywagesdb;
		}
		
		public static Map<Integer, HashMap<YearMonth, MonthlySalary>> getMonthlyWagesDB() {
			return monthlywagesdb;
		}
		
		
		
	}


