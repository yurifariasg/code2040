package org.code2040.dashboard

import grails.converters.JSON
import grails.plugins.springsecurity.Secured

import org.codehaus.groovy.grails.web.json.JSONObject
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper


class CandidateController {
	
	def candidateService
	def messageSource
	def springSecurityService
	def validationService
	def securityService
	
	private currentCandidate() {
		return Candidate.get(springSecurityService.principal.id)
	}
	
	private currentManager() {
		return Manager.get(springSecurityService.principal.id)
	}
	
    def index() {
		if (springSecurityService.principal != 'anonymousUser') {
			for (String s : springSecurityService.getPrincipal().getAuthorities())
				if (s == 'ROLE_USER')
					redirect(action:"application")
		}
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_USER'])
	def show() {
		Candidate c = Candidate.get(params.id)
		[candidate:c]
	}
	
	@Secured(['ROLE_USER'])
	def me() {
		redirect(action:"show", [currentCandidate().id])
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
		Candidate c = candidateService.createCandidate(email, password)
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
			c.enabled = true
			c.save(flush:true)
			securityService.autoLogin(c.username, password)
			redirect(controller:'candidate', action:'application')
		}
	}
	
	@Secured(['ROLE_USER'])
	def application() {
		if (request.method == 'POST') {
		
			String fname = params.fname
			String lname = params.lname
			String school = params.school
			String graduationDate = params.gradDate
			String phoneNumber = params.phone
			char gender = params.gender != null ? params.gender.charAt(0) : null
			String race = params.race
			String homeCountry = params.country
			int fellowYear = Calendar.getInstance().get(Calendar.YEAR) // Get Always Current Year - ? Or let user decide ?
			String homeState = params.homeState
			List<Answer> answers = candidateService.parseAnswers(params.questions)
			
			String err = validationService.validateCandidateParams(
				fname, lname, school, graduationDate, phoneNumber,
				gender, race, homeCountry, fellowYear, answers, homeState)
			
			if (err != null) {
				render(view:'application', model:[error:err])
				return
			}
			
			Candidate c = currentCandidate()
			
			if (!candidateService.setCandidateInfo(c, fname, lname, school,
				graduationDate, phoneNumber, gender, race, homeCountry, homeState, answers)) {
				render(view:'application', model:[error:"Error in Candidate Creation"])
				return
			}
			
			render "Step 1 Sucessfully Completed"
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
	
