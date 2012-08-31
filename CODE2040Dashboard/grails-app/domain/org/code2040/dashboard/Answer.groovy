package org.code2040.dashboard

class Answer {
	
	long questionId
	String answer

    static constraints = {
		answer blank:false
    }
}
