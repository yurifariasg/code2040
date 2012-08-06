package org.code2040.dashboard

class Candidate {
	// All Classes already have a attribute called ID
	String name
	String school
	String graduationDate
	String email
	String password
	String phoneNumber
	ApplicationStep currentStep = ApplicationStep.FIRST_STEP
	CandidateStatus status = CandidateStatus.CANDIDATE
	char gender
	String race
	String homeCountry
	int fellowYear
	boolean needsReview = false
	
	List<Question> questions
	List<RecruitmentInfo> recruitmentInfo
	
	int timeCreated = System.currentTimeMillis()
	int timeModified = System.currentTimeMillis()
	int timeRemoved = 0
	int lastLogin = 0
	
	// Optional
	String homeState

    static constraints = {
		name minSize:3, blank:false
		password minSize:6, blank:false
		school minSize:2, blank:false
		graduationDate blank:false
		email email: true, blank: false
		phoneNumber blank:false
		gender blank:false
		race blank:false
		homeCountry minSize:3, blank:false
	}
}