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
			username: "dummy@user.com",
			password: "dummyuser",
			enabled: true)
		
		dummyUser.save(flush: true, failOnError:true)
		SecUserSecRole.create dummyUser, userRole
		
		def dummyAdmin = new Manager(
			username: "manager@2040.com",
			password: "manager",
			enabled: true)
		
		dummyAdmin.save(flush: true, failOnError:true)
		SecUserSecRole.create dummyAdmin, adminRole
    }
    def destroy = {
    }
}
