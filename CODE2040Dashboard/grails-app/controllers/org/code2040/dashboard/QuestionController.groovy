package org.code2040.dashboard

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured

class QuestionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	@Secured(['ROLE_ADMIN'])
    def index() {
        redirect(action: "list", params: params)
    }
	
	@Secured(['ROLE_ADMIN'])
    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [questionInstanceList: Question.list(params), questionInstanceTotal: Question.count()]
    }
	
	@Secured(['ROLE_ADMIN'])
    def create() {
        [questionInstance: new Question(params)]
    }
	
	@Secured(['ROLE_ADMIN'])
    def save() {
        def questionInstance = new Question(params)
        if (!questionInstance.save(flush: true)) {
            render(view: "create", model: [questionInstance: questionInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'question.label', default: 'Question'), questionInstance.id])
        redirect(action: "show", id: questionInstance.id)
    }

	@Secured(['ROLE_ADMIN'])
    def show() {
        def questionInstance = Question.get(params.id)
        if (!questionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'question.label', default: 'Question'), params.id])
            redirect(action: "list")
            return
        }

        [questionInstance: questionInstance]
    }

	@Secured(['ROLE_ADMIN'])
    def edit() {
        def questionInstance = Question.get(params.id)
        if (!questionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'question.label', default: 'Question'), params.id])
            redirect(action: "list")
            return
        }

        [questionInstance: questionInstance]
    }
	
	@Secured(['ROLE_ADMIN'])
    def update() {
        def questionInstance = Question.get(params.id)
        if (!questionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'question.label', default: 'Question'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (questionInstance.version > version) {
                questionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'question.label', default: 'Question')] as Object[],
                          "Another user has updated this Question while you were editing")
                render(view: "edit", model: [questionInstance: questionInstance])
                return
            }
        }

        questionInstance.properties = params

        if (!questionInstance.save(flush: true)) {
            render(view: "edit", model: [questionInstance: questionInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'question.label', default: 'Question'), questionInstance.id])
        redirect(action: "show", id: questionInstance.id)
    }

	@Secured(['ROLE_ADMIN'])
    def delete() {
        def questionInstance = Question.get(params.id)
        if (!questionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'question.label', default: 'Question'), params.id])
            redirect(action: "list")
            return
        }

        try {
            questionInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'question.label', default: 'Question'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'question.label', default: 'Question'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
