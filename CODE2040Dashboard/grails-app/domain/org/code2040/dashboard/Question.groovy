package org.code2040.dashboard

class Question {
	// All Classes already have a attribute called ID
	String description

    static constraints = {
		description blank:false
    }
}
