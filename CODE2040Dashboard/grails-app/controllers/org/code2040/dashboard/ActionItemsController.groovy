package org.code2040.dashboard
import java.util.List
import grails.plugins.springsecurity.Secured
import org.code2040.dashboard.Candidate

class ActionItemsController {

		def candidateService
		def messageSource
		def springSecurityService
		def validationService
		
		private currentManager() {
			return Manager.get(springSecurityService.principal.id)
		}
		
		private currentManagerId(){
			return springSecurityService.principal.id
		}
		
		@Secured(['ROLE_ADMIN'])
			def index() {
			render "Hello! This is the Comments Controller.. We're still working on it!\n" +
			"Available Endpoints:\n" +
			"/create\n" +
			"/update\n" +
			"/delete"
		}
		
		//accepts a comment id and marks it as resolved
		@Secured(['ROLE_ADMIN'])
		def resolve(){
			int comemntId = params.commentId
			Comment c = Comment.get(id)
			if (c == null) {
				render "Comment not found"
				return
			}
			c.resolved = true
			c.approverManager = currentManagerId()
			c.timeApproved = System.currentTimeMillis()
			
		}
		//accepts a candidate id adn a step and returns all comments
		//TODO: for future it will return comments for speicific step
		@Secured(['ROLE_ADMIN'])
		def lookupComments() {
			int id = params.id
			ApplicationStep step = params.step
			Candidate c = Candidate.get(id)
			if (c == null) {
				render "Candidate not found"
				return
			}
			if (c.hasErrors()) render "Errors with parameters"
			else return c.comments
			
		}
		
		//accepts caniddate, comment adn step adn assignes a new comment to a candidate
		@Secured(['ROLE_ADMIN'])
		def update() {
			int id = params.id
			Candidate can = Candidate.get(id)
			if (can == null) {
				render "Candidate not found"
				return
			}
			Comment com = new Comment()
			com.comment = params.comment
			com.step = params.step
			com.author = currentManagerId()
			can.comments.add (com)
			if (can.hasErrors()) render "Errors with adding comments"
			else render "Comments Added Sucessfully!"
		}
}
