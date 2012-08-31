package org.code2040.dashboard

class Comment {

	ApplicationStep step
	String comment
	int mangagerId
	int approverManagerId
	int timeCreated = System.currentTimeMillis()
	boolean resolved = false
	
	
    static constraints = {
		step minSize:3, blank:false, nullable:true
		comment minSize:3, blank:false, nullable:true
    }
}
