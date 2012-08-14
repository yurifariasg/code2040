package org.code2040.dashboard

class RecruitmentInfo {
	int candidateID
	String name
	String email
	String title
    static constraints = {
		name minSize:3, blank:false, nullable:true
    }
}
