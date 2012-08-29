package org.code2040.dashboard

import grails.plugins.springsecurity.Secured
import org.code2040.dashboard.Candidate
import org.code2040.dashboard.ApplicationStep


class ManagementController {
	
	def statisticsService
	def activityService
	def candidateService
	
    def index() {
		redirect(controller:"login",action:"auth")
	}
	
	def master() {
		
	}
	
	def aitems() {
		
	}
	
	def login() {
		redirect(controller:"login",action:"auth")
	}
	
	@Secured(['ROLE_ADMIN'])
	def getNotifications() {
		int step
		try {
			step = Integer.parseInt(params.step)
		} catch (Exception e) {
			step = -1
		}
		ApplicationStep appStep = null
		switch (step) {
			case 1: appStep = ApplicationStep.FIRST_STEP; break;
			case 2: appStep = ApplicationStep.SECOND_STEP; break;
			case 3: appStep = ApplicationStep.THIRD_STEP; break;
			case 4: appStep = ApplicationStep.FOURTH_STEP; break;
			default: appStep = null; break;
		}
		
		if (appStep == null) {
			render "This is not a valid step"
			return
		}
		
		List<Candidate> candidates = Candidate.findAllWhere(currentStep:appStep, status:CandidateStatus.CANDIDATE, needsReview:true)
		render "There are " + candidates.size() + " looking forward in being approved on this step!"
	}
	
	@Secured(['ROLE_ADMIN'])
	def approveCandidate() {
		int candidateID = params.id
		
		Candidate c = candidateService.approveCandidate(candidateID)
		if (c == null || c.hasErrors()) {
			render "Couldnt approve candidate"
		} else {
			render "Candidate with ID: " + candidateID + " was approved is now in step number: " + c.currentStep
		}
	}
	
	@Secured(['ROLE_ADMIN'])
	def denyCandidate() {
		int candidateID = params.id
		
		Candidate c = candidateService.denyCandidate(candidateID)
		if (c == null || c.hasErrors()) {
			render "Couldnt deny candidate"
		} else if (c.status == CandidateStatus.DENIED) {
			render "Candidate with ID: " + candidateID + " was denied"
		} else {
			render "Error happened and Candidate has now status: " + c.status
		}
	}
}
