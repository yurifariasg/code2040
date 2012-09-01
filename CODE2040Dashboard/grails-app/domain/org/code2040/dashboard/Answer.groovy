package org.code2040.dashboard

class Answer {
	
	long questionId
	int candidateID
	int questionID
	String description
	
    static constraints = {
		description minSize:2, blank:false, nullable:true
    }
}
