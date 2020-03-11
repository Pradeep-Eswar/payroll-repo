package org.compay.employee.payroll.model;



public class StaffMembers {



		private int id;
		private String name;
	    
	    public StaffMembers() {
	    	
	    }
	    
		public StaffMembers(int id, String name) {
			this.id = id;
			this.name = name;
		}

	
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	    
	    
	}
	

