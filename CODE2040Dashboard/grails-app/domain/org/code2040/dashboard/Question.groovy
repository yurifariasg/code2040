package org.code2040.dashboard

class Question {
	// All Classes already have a attribute called ID
	String description
	boolean beingUsed = false

    static constraints = {
		description minSize:3, blank:false, nullable:true
    }
}
