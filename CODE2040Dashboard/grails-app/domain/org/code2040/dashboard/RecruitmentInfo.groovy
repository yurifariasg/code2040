package org.code2040.dashboard

class RecruitmentInfo {

	int candidateID//person who suggested the potential recruit
	String fname
	String lname
 	String email
	String title
	static constraints = {
		fname minSize:2, blank:false, nullable:true
		lname minSize:2, blank:false, nullable:true
	}
}
