package org.code2040.dashboard

class Manager extends SecUser {
	// All Classes already have a attribute called ManagerID
	// E-MAIL SHOULD BE TREATED AS USERNAME
	String name
	int lastLogin = 0
	String password
    static constraints = {
		name minSize:3, blank:false, nullable:true
    }
}
