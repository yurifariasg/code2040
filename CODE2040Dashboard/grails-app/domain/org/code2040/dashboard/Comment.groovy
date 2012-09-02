package org.code2040.dashboard

class Comment {

	ApplicationStep step
	String comment
	long author
	long approverManager
	long timeCreated = System.currentTimeMillis()
	long timeApproved
	long candidateId
	boolean resolved = false
	
    static constraints = {
		comment minSize:3, blank:false, nullable:true
    }
}
