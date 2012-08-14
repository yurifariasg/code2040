import org.code2040.dashboard.SecRole
import org.code2040.dashboard.Manager
import org.code2040.dashboard.Candidate
import org.code2040.dashboard.SecUser
import org.code2040.dashboard.SecUserSecRole


class BootStrap {
	
	def springSecurityService

    def init = { servletContext ->
		
		// Creating the SecRoles for User and ADMIN
		def userRole = SecRole.findByAuthority("ROLE_USER") ?: new SecRole(authority: "ROLE_USER").save()
		def adminRole = SecRole.findByAuthority("ROLE_ADMIN") ?: new SecRole(authority: "ROLE_ADMIN").save()
		
		def dummyUser = new Candidate(
			username: "dummy",
			password: "pw",//springSecurityService.encodePassword("pw"),
			enabled: true)
		
		dummyUser.save(flush: true)
		
		println password: springSecurityService.encodePassword("pw")
		println "Has Errors? " + dummyUser.hasErrors()
		if (dummyUser.hasErrors()) {
			
			dummyUser.errors.allErrors.each {
				println it
			}
			
		}
		
		
		println "Testing"
		if (dummyUser == null) println "User is null"
		if (userRole == null) println "UserRole is null"
		
		SecUserSecRole.create dummyUser, userRole
		
		print dummyUser.password
		
		//def dummyAdmin = new Manager(email: "dummy@admin.com", password: springSecurityService.encodePassword("admin"))
		//dummyAdmin.save(flush: true)
		//SecUserSecRole.create dummyAdmin, adminRole
		
		
    }
    def destroy = {
    }
}
