package org.code2040.dashboard.services

import org.code2040.dashboard.Answer
import org.code2040.dashboard.Candidate
import org.code2040.dashboard.ApplicationStep
import org.code2040.dashboard.Question
import org.code2040.dashboard.RecruitmentInfo
import org.code2040.dashboard.SecUserSecRole
import org.code2040.dashboard.SecRole
import org.code2040.dashboard.CandidateStatus
import org.json.simple.JSONObject


class CandidateService {
	def springSecurityService
	
	def createCandidate(String email, String password){
		Candidate c = new Candidate()
		c.username = email
		c.password = password
		c.fname = null;
		c.lname = null;
		c.school= null;
		c.graduationDate = null;
		c.phoneNumber = null;
		c.gender = "M";
		c.race = null;
		c.homeCountry = null;
		c.homeState = null;
		c.enabled = true // Enabled for Security Reasons
		c.save(flush: true)
		
		if (!c.hasErrors()) {
			// This links the candidate with the role ROLE_USER
			SecUserSecRole.create c, SecRole.findByAuthority("ROLE_USER")
		}
		return c
	}
	
	def setCandidateInfo(Candidate c, String fname, String lname, String school, String graduationDate,
			String phoneNumber, char gender, String race, String homeCountry, String homeState,
			ArrayList<Answer> answers) {
			c.fname = fname;
			c.lname = lname;
			c.school= school;
			c.graduationDate = graduationDate;
			c.phoneNumber = phoneNumber;
			c.gender = gender;
			c.race = race;
			c.homeCountry = homeCountry;
			c.homeState = homeState;
			c.answers = answers
			c.needsReview = true
			return (c.save(flush:true) != null)
	}
	
	def approveCandidate(String cID, long staffID) {
		Candidate c = getCandidate(cID)
		if (c != null && c.status != CandidateStatus.DENIED && c.lockedBy == staffID) {
			ApplicationStep ps = c.currentStep
			if (ps != ApplicationStep.FOURTH_STEP) {
				ps.increment()
				c.currentStep = ps
			} else if (c.status == CandidateStatus.CANDIDATE) {
				c.status = CandidateStatus.CURRENT_FELLOW
			} else if (c.status == CandidateStatus.CURRENT_FELLOW) {
				c.status = CandidateStatus.ALUMNI
			}
			c.skipped = false
			c.save()
			return true
		}
		return false
	}
	
	def denyCandidate(String cID, long staffID) {
		Candidate c = getCandidate(cID)
		if (c != null && c.status != CandidateStatus.DENIED && c.lockedBy == staffID) {
			c.status = CandidateStatus.DENIED
			c.skipped = false
			c.save()
			return true
		} else {
			return false
		}
	}
	
	def lockCandidate(String cID, long staffID) {
		Candidate c = getCandidate(cID)
		if (c != null) {
			println "Time Before: " + c.timeLocked
			if (!c.locked || (// Lock remains until 30 minutes
							c.timeLocked + 1800000 < System.currentTimeMillis())) {
				c.locked = true
				c.lockedBy = staffID
				c.timeLocked = System.currentTimeMillis()
				c.save()
				return true
			}
		}
		return false
	}
	
	def unlockCandidate(String cID, long staffID) {
		Candidate c = getCandidate(cID)
		if (c != null) {
			if (c.lockedBy == staffID) {
				c.locked = false
				c.lockedBy = -1
				c.timeLocked = -1
				c.save()
				return true
			}
		}
		return false
	}
	
	def getCandidate(String strId) {
		long id
		try {
			id = Long.parseLong(strId)
		} catch (Exception e) {
			id = -1
		}
		Candidate c = Candidate.get(id)
		if (c != null)
			return c
		else
			return null
	}
	
	def parseAnswers(String json) {
		ArrayList<Answer> answers = new ArrayList<Answer>()
		JSONObject jsonObject = new JSONObject(json)
		for (String key : jsonObject.keySet()) {
			int qID
			try {
				qID = Long.parseLong(key)
			} catch (Exception e) {
				qID = -1
			}
			Question q = Question.get(qID)
			if (q != null) {
				
				Answer a = new Answer()
				a.questionId = qID
				a.description = jsonObject.get(key)
				a.save()
				answers.add(a)
			}
		}
		return answers
	}
}
