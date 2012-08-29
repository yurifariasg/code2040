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
	
	private currentUser() {
		return Candidate.get(springSecurityService.principal.id)
	}
	
	def emailconfirmation = {
		render "User Confirmed with UID: " + params.uid + " and email: " + params.email
	} 
	
	@Secured(['ROLE_USER']) // IS_AUTHENTICATED_FULLY - IF WE NEED MORE SECURITY [ MAKES USER AUTHENTICATES AGAIN ]
    def index() { 
		render "Hello! This is the Candidate Controller.. We're still working on it!\n" +
		"Available Endpoints:\n" +
		"/create\n" +
		"/update\n" +
		"/delete"
	}
	
	def create() {
		
		if (request.method == 'GET') {
			def htmlContent = new File('grails-app/views/candidate_app.html').text
			render text: htmlContent, contentType:"text/html", encoding:"UTF-8"
		} else if (request.method == 'POST') {
		
			String name = params.name
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
				name, school, graduationDate, email, password, secondPassword, phoneNumber,
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
				name, school, graduationDate, email, password, phoneNumber,
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
				emailConfirmationService.sendConfirmation(c.email,
				  "E-Mail Confirmation", [view:'/emailconfirmation/mail/confirmationRequest'], c.id)
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
