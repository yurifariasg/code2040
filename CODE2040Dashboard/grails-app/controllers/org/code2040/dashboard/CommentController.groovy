package org.code2040.dashboard

import java.util.List
import grails.converters.JSON
import grails.plugins.springsecurity.Secured
import org.code2040.dashboard.Candidate
import org.code2040.dashboard.Comment

class CommentController {
	
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
	
	//accepts a comment id and marks it as resolved
	@Secured(['ROLE_ADMIN'])
	def resolve(){
		long commentId = params.commentId
		Comment c = Comment.get(commentId)
		if (c == null) {
			render "false"
			return
		}
		c.resolved = true
		c.approverManager = currentManagerId()
		c.timeApproved = System.currentTimeMillis()
		render "true"
		
	}
	//accepts a candidate id adn a step and returns all comments
	@Secured(['ROLE_ADMIN'])
	def lookup() {
		//ApplicationStep step = params.step
		Candidate c = candidateService.getCandidate(params.id)
		if (c == null || c.hasErrors()) {
			render "null"
			return
		}
		List<Comment> comments = Comment.findAllWhere(step: c.currentStep, candidateId: c.id)
		
		render comments.collect { it ->
			["author" : Manager.get(it.author).username, // TODO: Join the table to create less overhead here
			"comment" : it.comment]
		} as JSON
	}
	
	//accepts caniddate, comment adn step adn assignes a new comment to a candidate
	@Secured(['ROLE_ADMIN'])
	def update() {
		Candidate can = candidateService.getCandidate(params.id)
		if (can == null) {
			render "false"
			return
		}
		Comment com = new Comment()
		com.comment = params.comment
		com.step = can.currentStep
		com.candidateId = can.id
		com.author = currentManagerId()
		com = com.save(flush:true)
		can.comments.add (com)
		if (com == null || can.save() == null || can.hasErrors()) render "false"
		else render "true"
	}
}
