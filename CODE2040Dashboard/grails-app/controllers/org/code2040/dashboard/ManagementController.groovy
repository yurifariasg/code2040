package org.code2040.dashboard

import grails.plugins.springsecurity.Secured
import org.code2040.dashboard.Candidate
import org.code2040.dashboard.ApplicationStep


class ManagementController {
	
	def statisticsService
	def activityService
	def candidateService
	def validationService
	def managerService
	def emailConfirmationService
	def messageSource
	
    def index() {
	}
	
	def create() {
		String email = params.email
		String password = params.password
		String secondPassword = params.retry
		String err = validationService.validateManagerCreate(email, password, secondPassword)
		
		if (err != null) {
			 render view:'index', model:[error_message:err]
			 return
		}
		
		Manager m = managerService.createManager(email, password, params.fname, params.lname)
		
		if (m.hasErrors()) {
			def locale = Locale.getDefault()
			for (fieldErrors in m.errors) {
			   for (error in fieldErrors.allErrors) {
				  String message = messageSource.getMessage(error, locale)
				  render view:'index', model:[error_message:message]
				  return
			   }
			}
		} else {
			emailConfirmationService.sendConfirmation(m.username, // Username == Email
			  "E-Mail Confirmation", [view:'/emailconfirmation/mail/confirmationRequest'],
			  String.valueOf(m.id))
			render(params:[message:"Please, verify your email"])
		}
	}
	
	def emailconfirmation() {
		String email = params.email
		long uid
		try {
			uid = Long.parseLong(params.uid)
		} catch (Exception e) {
			uid = -1
		}
		
		if (uid == -1 || email == null) {
			render "Couldnt verify your account"	
		} else {
			Manager m = Manager.get(uid)
			m.enabled = true
			m.save(flush: true)
			render "Account Sucessfully Verified"	
		}
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
