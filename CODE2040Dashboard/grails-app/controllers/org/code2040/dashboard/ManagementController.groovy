package org.code2040.dashboard

import grails.plugins.springsecurity.Secured
import org.code2040.dashboard.Candidate
import org.code2040.dashboard.ApplicationStep


class ManagementController {
	
	def statisticsService
	def activityService
	def candidateService
	
	@Secured(['ROLE_ADMIN'])
    def index() {
	}
	
	@Secured(['ROLE_ADMIN'])
	def master() {
		
	}
	
	@Secured(['ROLE_ADMIN'])
	def aitems() {
		render(model:[
			step_one:Candidate.findAllWhere(currentStep:ApplicationStep.FIRST_STEP,
				status:CandidateStatus.CANDIDATE, needsReview:true),
			step_two:Candidate.findAllWhere(currentStep:ApplicationStep.SECOND_STEP,
				status:CandidateStatus.CANDIDATE, needsReview:true),
			step_three:Candidate.findAllWhere(currentStep:ApplicationStep.THIRD_STEP,
				status:CandidateStatus.CANDIDATE, needsReview:true),
			step_four:Candidate.findAllWhere(currentStep:ApplicationStep.FOURTH_STEP,
				status:CandidateStatus.CANDIDATE, needsReview:true)])
	}
	
	def login() {
		redirect(controller:"login",action:"auth")
	}
	
	@Secured(['ROLE_ADMIN'])
	def dashboard() {
		
	}
}
