package org.code2040.dashboard

class ErrorController {

    def serverError = {
        render(view:"runtime")
    }

    def notFound = {
       render(view:'notFound')
    }
}
