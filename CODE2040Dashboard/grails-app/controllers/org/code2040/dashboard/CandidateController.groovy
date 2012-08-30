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
	
	private currentUser() {
		return Candidate.get(springSecurityService.principal.id)
	}
	
    def index() { 
	}
	
	def emailconfirmation() {
		String email = params.email
		int uid
		try {
			uid = Integer.parseInt(params.uid)
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
	
	@Secured(['ROLE_USER'])
	def application() {
		
	}
	
	def login() {
		redirect(controller:"login",action:"auth")
	}
	
	def create(){
		if (request.method == 'GET') {
			def htmlContent = new File('grails-app/views/candidate_create.html').text
			render text: htmlContent, contentType:"text/html", encoding:"UTF-8"
		} else if (request.method == 'POST') {
			String email = params.email
			String password = params.password
			String secondPassword = params.retry
			String err = validationService.validateCandidateCreate(email, password, secondPassword)
			
			if (err != null) {
				 // SEND THE ERROR!...
				render err
				return
				//def htmlContent = new File('grails-app/views/login.html').text
				//render text: htmlContent, contentType:"text/html", encoding:"UTF-8"
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
		} else {
			render(params:[error_message:"Invalid Request"])
		}
	}
	
	@Secured(['ROLE_USER'])
	def setBioInfo() {
		
		if (request.method == 'GET') {
			def htmlContent = new File('grails-app/views/candidate_app.html').text
			render text: htmlContent, contentType:"text/html", encoding:"UTF-8"
		} else if (request.method == 'POST') {
		
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
			
			List<Question> questions
			List<RecruitmentInfo> recruitmentInfo
			
			String err = validationService.validateCandidateParams(
				fname, lname, school, graduationDate, email, password, secondPassword, phoneNumber,
				gender, race, homeCountry, fellowYear, questions, recruitmentInfo,
				homeState)
			
			if (err != null) {
				 // SEND THE ERROR!...
				render err
				return
				//def htmlContent = new File('grails-app/views/login.html').text
				//render text: htmlContent, contentType:"text/html", encoding:"UTF-8"
			}
			Candidate c = candidateService.createCandidate(
				fname, lname, school, graduationDate, email, password, phoneNumber,
				gender, race, homeCountry, fellowYear, questions, recruitmentInfo,
				homeState
				)
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
				render "User Created sucessfully! ID: " + c.id
			}
		} else {
			render "Invalid Request"
		}
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_USER'])
	def update() {
		int id = params.id
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
	
	def delete() {
		
	}
}
