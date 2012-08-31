package org.code2040.dashboard

import java.util.List
import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject
import grails.plugins.springsecurity.Secured


class CandidateController {
	
	def candidateService
	def messageSource
	def springSecurityService
	def validationService
	def emailConfirmationService
	def securityService
	
	private currentCandidate() {
		return Candidate.get(springSecurityService.principal.id)
	}
	
	private currentManager() {
		return Manager.get(springSecurityService.principal.id)
	}
	
    def index() { 
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
			Candidate c = Candidate.get(uid)
			c.enabled = true
			c.save(flush: true)
			render "Account Sucessfully Verified"	
		}
	}
	
	def login() {
		redirect(controller:"login",action:"auth")
	}

	def logout() {
		redirect(controller:"logout",action:"index")
	}
	
	def create() {
		String email = params.email
		String password = params.password
		String secondPassword = params.retry
		String err = validationService.validateCandidateCreate(email, password, secondPassword)
		
		if (err != null) {
			 render view:'index', model:[error_message:err]
			 return
		}
		Candidate c = candidateService.createCandidateA(email, password)
		if (c.hasErrors()) {
			def locale = Locale.getDefault()
			for (fieldErrors in c.errors) {
			   for (error in fieldErrors.allErrors) {
				  String message = messageSource.getMessage(error, locale)
				  render view:'index', model:[error_message:message]
				  return
			   }
			}
		} else {
			if (c.username.endsWith('@code2040.org')) {
				emailConfirmationService.sendConfirmation(c.username, // Username == Email
				  "E-Mail Confirmation", [view:'/emailconfirmation/mail/confirmationRequest'],
				  String.valueOf(c.id))
				c.enabled = false
				c.save()
				render(params:[message:"Please, verify your email"])
			} else {
				c.enabled = true
				c.save(flush:true)
				securityService.autoLogin(c.username, password)
				redirect(controller:'candidate', action:'application')
			}
		}
	}
	
	@Secured(['ROLE_USER'])
	def application() {
		if (request.method == 'POST') {
		
			String fname = params.fname
			String lname = params.lname
			String school = params.school
			String graduationDate = params.gradDate
			String email = params.email
			String password = params.password
			String secondPassword = params.retry
			String phoneNumber = params.phone
			char gender = params.gender != null ? params.gender.charAt(0) : null
			String race = params.race
			String homeCountry = params.country
			int fellowYear = Calendar.getInstance().get(Calendar.YEAR) // Get Always Current Year - ? Or let user decide ?
			String homeState = params.homeState
			List<Answer> answers = candidateService.parseAnswers(params.questions)
			
			String err = validationService.validateCandidateParams(
				fname, lname, school, graduationDate, email, password, secondPassword, phoneNumber,
				gender, race, homeCountry, fellowYear, answers, homeState)
			
			if (err != null) {
				render err
				return
			}
			Candidate c = candidateService.createCandidate(
				fname, lname, school, graduationDate, email, password, phoneNumber,
				gender, race, homeCountry, fellowYear, answers, homeState)
			if (c.hasErrors()) {
				def locale = Locale.getDefault()
				for (fieldErrors in c.errors) {
				   for (error in fieldErrors.allErrors) {
				      String message = messageSource.getMessage(error, locale)
					  render message
					  return
				   }
				}
			} else {
				render "true"
			}
		}
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_USER'])
	def update() {
		long id
		try {
			id = Long.parseLong(params.id)
		} catch (Exception e) {
			id = -1
		}
		Candidate c = Candidate.get(id)
		if (c == null) {
			render "Candidate not found"
			return
		}
		// This should be in Service!
		String updateJSON = params.updateJson
		JSONObject updatej = JSON.parse(updateJSON)
		for (String key : updatej.keys()) {
			c."$key" = updatej.getAt(key)
		}
		if (c.hasErrors()) render "Errors with parameters"
		else render "User Updated Sucessfully!"
	}
	
	@Secured(['ROLE_ADMIN'])
	def delete() {
		
	}
	
	@Secured(['ROLE_ADMIN'])
	def lock() {
		if (candidateService.lockCandidate(params.id, currentManager().id)) {
			render "true"
		} else {
			render "false"
		}
	}
	
	@Secured(['ROLE_ADMIN'])
	def unlock() {
		if (candidateService.unlockCandidate(params.id, currentManager().id)) {
			render "true"
		} else {
			render "false"
		}
	}
	
	@Secured(['ROLE_ADMIN'])
	def approve() {
		if (candidateService.approveCandidate(params.id, currentManager().id)) {
			render "true"
		} else {
			render "false"
		}
	}
	
	@Secured(['ROLE_ADMIN'])
	def deny() {
		if (candidateService.denyCandidate(params.id, currentManager().id)) {
			render "true"
		} else {
			render "false"
		}
	}
	
	@Secured(['ROLE_ADMIN'])
	def skip() {
		Candidate c = candidateService.getCandidate(params.id)
		if (c != null) {
			c.skipped = true
			c.save()
			render "true"
		} else {
			render "false"
		}
	}
}
	
