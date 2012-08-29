package org.code2040.dashboard

class Comment {

	ApplicationStep step
	String comment
	
    static constraints = {
		step minSize:3, blank:false, nullable:true
		comment minSize:3, blank:false, nullable:true
    }
}
