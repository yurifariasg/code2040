package org.code2040.dashboard.services

import org.code2040.dashboard.Candidate
import org.code2040.dashboard.ApplicationStep
import org.code2040.dashboard.Question
import org.code2040.dashboard.RecruitmentInfo
import org.code2040.dashboard.SecUserSecRole
import org.code2040.dashboard.SecRole


class CandidateService {
	def springSecurityService
    def createCandidate(String name, String school, String graduationDate, String email,
		
		String password, String phoneNumber, char gender, String race, String homeCountry,
		int fellowYear, List<Question> questions, List<RecruitmentInfo> recruitmentInfo,
		String homeState) {
		Candidate c = new Candidate()
		c.name = name
		c.school = school
		c.graduationDate = graduationDate
		c.email = email
		c.password = springSecurityService.encodePassword(password) //Kaleb's: securityService.createHash(password)
		c.phoneNumber = phoneNumber
		c.gender = gender
		c.race = race
		c.homeCountry = homeCountry
		c.fellowYear = fellowYear
		//c.questions.addAll(questions)
		//c.recruitmentInfo.addAll(recruitmentInfo)
		c.homeState = homeState
		c.enabled = true // Enabled for Security Reasons
		c.save(flush: true)
		
		// This links the candidate with the role ROLE_USER
		SecUserSecRole.create c, SecRole.findByAuthority("ROLE_USER")
		
		return c
    }
	
	def approveCandidate(int candidateID, int stepID) {
		Candidate c = Candidate.get(candidateID)
		if (c == null) return null
		
		ApplicationStep ps = c.currentStep
		if (ps != ApplicationStep.FOURTH_STEP) {
			ps.increment()
			c.currentStep = ps
			return c.save()
		}
		return c
	}
}
