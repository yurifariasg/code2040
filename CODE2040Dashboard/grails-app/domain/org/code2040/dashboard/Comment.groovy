package org.code2040.dashboard

class Comment {

	ApplicationStep step
	String comment
	Manager author
	Manager approverManager
	int timeCreated = System.currentTimeMillis()
	int timeApproved
	boolean resolved = false
	
	
    static constraints = {
		step minSize:3, blank:false, nullable:true
		comment minSize:3, blank:false, nullable:true
    }
}
