package org.code2040.dashboard

class Manager extends SecUser {
	
	String fname
	String lname
	int lastLogin = 0
	String password
	
	static constraints = {
		fname minSize:2, blank:false, nullable:true
		lname minSize:2, blank:false, nullable:true
	}
}
