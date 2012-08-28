package org.code2040.dashboard

class Candidate extends SecUser {
	// All Classes already have a attribute called ID
	// E-MAIL SHOULD BE TREATED AS USERNAME
	String fname
	String lname
	String school
	String graduationDate
	//String password
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
	
	ArrayList<Comment> comments
	
	int timeCreated = System.currentTimeMillis()
	int timeModified = System.currentTimeMillis()
	int timeRemoved = 0
	int lastLogin = 0
	
	// Optional
	String homeState

    static constraints = {
		fname minSize:3, blank:false, nullable:true
		lname minSize:3, blank:false, nullable:true
		//password minSize:6, blank:false
		school minSize:2, blank:false, nullable:true
		graduationDate blank:false, nullable:true
		// username email: true, blank: false
		phoneNumber blank:false, nullable:true
		gender blank:false, nullable:true
		race blank:false, nullable:true
		homeCountry minSize:3, blank:false, nullable:true
		homeState nullable:true
		
	}
}