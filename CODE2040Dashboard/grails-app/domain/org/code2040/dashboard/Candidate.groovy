package org.code2040.dashboard

class Candidate extends SecUser {
	// All Classes already have a attribute called ID
	// E-MAIL SHOULD BE TREATED AS USERNAME
	String fname
	String lname
	String school
	String graduationDate
	String phoneNumber
	ApplicationStep currentStep = ApplicationStep.FIRST_STEP
	CandidateStatus status = CandidateStatus.CANDIDATE
	char gender
	String race
	String homeCountry
	int fellowYear
	boolean needsReview = false
	String homeState
	
	List<Question> questions
	List<RecruitmentInfo> recruitmentInfo
	
	ArrayList<Comment> comments
	
	long timeCreated = System.currentTimeMillis()
	long timeModified = System.currentTimeMillis()
	long timeRemoved = 0
	long lastLogin = 0
	
	// Locking
	boolean locked = false
	long lockedBy = -1
	long timeLocked = -1

    static constraints = {
		fname minSize:3, blank:false, nullable:true
		lname minSize:3, blank:false, nullable:true
		school minSize:2, blank:false, nullable:true
		graduationDate blank:false, nullable:true
		phoneNumber blank:false, nullable:true
		gender blank:false, nullable:true
		race blank:false, nullable:true
		homeCountry minSize:3, blank:false, nullable:true
		homeState nullable:true
	}
}