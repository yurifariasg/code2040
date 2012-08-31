package org.code2040.dashboard

class Comment {

	ApplicationStep step
	String comment
	int author
	int approverManager
	int timeCreated = System.currentTimeMillis()
	int timeApproved
	boolean resolved = false
	
	
    static constraints = {
		step minSize:3, blank:false, nullable:true
		comment minSize:3, blank:false, nullable:true
    }
}
