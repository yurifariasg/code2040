package org.code2040.dashboard


class ManagementController {
	
	def statisticsService
	def activityService
	def candidateService

    def index() {
		int num = 0;
		num = statisticsService.serviceMethod(num)
		render "Hello! This is the Management Controller.. We're still working on it! (" + num + ")" 
	}
	
	def approveCandidate() {
		int candidateID = params.id
		
		Candidate c = candidateService.approveCandidate(candidateID)
		if (c == null || c.hasErrors()) {
			render "Couldnt approve candidate"
		} else {
			render "Candidate with ID: " + candidateID + " was approved is now in step number: " + c.currentStep
		}
	}
	
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
